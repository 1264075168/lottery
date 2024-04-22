package cn.bugstack.domain.strategy.service.armory;

/**
 * @Author: dior
 * @CreateTime: 2024-04-22  20:58
 * @Description: 策略抽奖的调度
 */
public interface IStrategyDispatch {
    /**
     * 获取抽奖策略装配的随机结果
     *
     * @param strategyId 策略ID
     * @return 抽奖结果
     */
    Integer getRandomAwardId(Long strategyId);
    Integer getRandomAwardId(Long strategyId, String ruleWeightValue);
}
