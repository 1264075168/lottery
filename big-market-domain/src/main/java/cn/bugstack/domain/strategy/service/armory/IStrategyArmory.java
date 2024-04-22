package cn.bugstack.domain.strategy.service.armory;

/**
 * @Author: dior
 * @CreateTime: 2024-04-22  13:36
 * @Description: 策略装配库（兵工厂） 负责初始化策略计算
 */
public interface IStrategyArmory {
    void assembleLotteryStrategy(long strategyId);
    Integer getRandomAwardId(Long strategyId);
}
