package cn.bugstack.domain.strategy.service.rule;

import cn.bugstack.domain.strategy.model.entity.RuleActionEntity;
import cn.bugstack.domain.strategy.model.entity.RuleMatterEntity;

/**
 * @Author: dior
 * @CreateTime: 2024-04-23  12:31
 * @Description: 抽奖规则过滤接口 LogicFilter逻辑过滤器
 */
public interface ILogicFilter <T extends RuleActionEntity.RaffleEntity>{
    RuleActionEntity<T> filter(RuleMatterEntity ruleMatterEntity);
}
