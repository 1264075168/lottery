package cn.bugstack.domain.strategy.service.armory;

import cn.bugstack.domain.strategy.model.entity.StrategyAwardEntity;
import cn.bugstack.domain.strategy.repository.IStrategyRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.SecureRandom;
import java.util.*;

/**
 * @Author: dior
 * @CreateTime: 2024-04-22  13:37
 * @Description: 策略装配库（兵工厂） 负责初始化策略计算 (装配抽奖策略)
 */
@Service
public class StrategyArmory implements IStrategyArmory{
    @Resource
    private IStrategyRepository repository;
    //第一个动作=========装配========================================
    @Override
    public boolean assembleLotteryStrategy(long strategyId) {
    //第一步：根据策略id查值，DDD架构不需要自己去调Dao，交给基础层去调
       //查询策略配置
        List<StrategyAwardEntity> strategyAwardEntities = repository.queryStrateguAwardList(strategyId);
        // 2. 获取最小概率值
        BigDecimal minAwardRate = strategyAwardEntities.stream()
                .map(StrategyAwardEntity::getAwardRate)
                .min(BigDecimal::compareTo)
                .orElse(BigDecimal.ZERO);
        // 如果最小概率值为 0，设置一个默认值，避免除以零
        if (minAwardRate.equals(BigDecimal.ZERO)) {
            minAwardRate = BigDecimal.ONE; // 或者设置为其他非零值
        }
        // 3. 获取概率值总和
        BigDecimal totalAwardRate = strategyAwardEntities.stream()
                .map(StrategyAwardEntity::getAwardRate)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        // 4. 用 1 % 0.0001 获得概率范围，百分位、千分位、万分位
        BigDecimal rateRange = totalAwardRate.divide(minAwardRate, 0, RoundingMode.CEILING);

        // 5. 生成策略奖品概率查找表「这里指需要在list集合中，存放上对应的奖品占位即可，占位越多等于概率越高」
        List<Integer> strategyAwardSearchRateTables = new ArrayList<>(rateRange.intValue());
        for (StrategyAwardEntity strategyAward : strategyAwardEntities) {
            Integer awardId = strategyAward.getAwardId();
            BigDecimal awardRate = strategyAward.getAwardRate();
            // 计算出每个概率值需要存放到查找表的数量，循环填充
            for (int i = 0; i < rateRange.multiply(awardRate).setScale(0, RoundingMode.CEILING).intValue(); i++) {
                strategyAwardSearchRateTables.add(awardId);
            }

        }
        // 6. 对存储的奖品进行乱序操作
        Collections.shuffle(strategyAwardSearchRateTables);

        // 7. 生成出Map集合，key值，对应的就是后续的概率值。通过概率来获得对应的奖品ID
        Map<Integer, Integer> shuffleStrategyAwardSearchRateTables = new LinkedHashMap<>();
        for (int i = 0; i < strategyAwardSearchRateTables.size(); i++) {
            shuffleStrategyAwardSearchRateTables.put(i, strategyAwardSearchRateTables.get(i));
        }

        // 8. 存放到 Redis
        //第二个参数不能传rateRange，如果概率总和不为1，Map就会剩余空位，查询为空
        repository.storeStrategyAwardSearchRateTables(strategyId, shuffleStrategyAwardSearchRateTables.size(), shuffleStrategyAwardSearchRateTables);
        return true;
    }
    //第2个动作=========抽奖========================================
    @Override
    public Integer getRandomAwardId(Long strategyId) {
        // 分布式部署下，不一定为当前应用做的策略装配。也就是值不一定会保存到本应用，而是分布式应用，所以需要从 Redis 中获取。
        int rateRange = repository.getRateRange(strategyId);
        // 通过生成的随机值，获取概率值奖品查找表的结果
        return repository.getStrategyAwardAssemble(strategyId, new SecureRandom().nextInt(rateRange));
        //nextInt(rateRange) 是 SecureRandom 类的一个方法，它生成一个随机的整数，范围是从 0 到 rateRange - 1，
        // 即 [0, rateRange)。这个方法的参数 rateRange 指定了随机数的范围，即生成的随机数不会超过 rateRange - 1。
    }




}
