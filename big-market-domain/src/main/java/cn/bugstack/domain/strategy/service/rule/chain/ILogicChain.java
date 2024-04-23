package cn.bugstack.domain.strategy.service.rule.chain;

/**
 * @Author: dior
 * @CreateTime: 2024-04-24  01:51
 * @Description: 责任链接口
 */

public interface ILogicChain extends ILogicChainArmory{

    /**
     * 责任链接口
     *
     * @param userId     用户ID
     * @param strategyId 策略ID
     * @return 奖品ID
     */
    Integer logic(String userId, Long strategyId);



}

