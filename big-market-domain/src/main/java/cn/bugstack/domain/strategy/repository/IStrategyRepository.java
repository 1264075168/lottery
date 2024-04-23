package cn.bugstack.domain.strategy.repository;

import cn.bugstack.domain.strategy.model.entity.StrategyAwardEntity;
import cn.bugstack.domain.strategy.model.entity.StrategyEntity;
import cn.bugstack.domain.strategy.model.entity.StrategyRuleEntity;

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

    void storeStrategyAwardSearchRateTables(String key, Integer rateRange, Map<Integer, Integer> shuffleStrategyAwardSearchRateTables);


    int getRateRange(Long strategyId);


    int getRateRange(String key);

    Integer getStrategyAwardAssemble(String key, int rateKey);

    StrategyEntity queryStrategyEntityByStrategyId(long strategyId);

    StrategyRuleEntity queryStrategyRule(long strategyId, String ruleModel);

    String queryStrategyRuleValue(Long strategyId, Integer awardId, String ruleModel);

}
