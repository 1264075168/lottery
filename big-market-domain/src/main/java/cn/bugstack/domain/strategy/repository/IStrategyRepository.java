package cn.bugstack.domain.strategy.repository;

import cn.bugstack.domain.strategy.model.entity.StrategyAwardEntity;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @Author: dior
 * @CreateTime: 2024-04-22  13:41
 * @Description: 策略的仓库接口
 */
public interface IStrategyRepository {

    List<StrategyAwardEntity> queryStrateguAwardList(long strategyId);

    void storeStrategyAwardSearchRateTables(long strategyId, Integer rateRange, Map<Integer, Integer> shuffleStrategyAwardSearchRateTables);


    int getRateRange(Long strategyId);

    Integer getStrategyAwardAssemble(Long strategyId, int rateKey);
}
