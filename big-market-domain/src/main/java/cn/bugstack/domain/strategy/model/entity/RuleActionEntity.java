package cn.bugstack.domain.strategy.model.entity;

import cn.bugstack.domain.strategy.model.valobj.RuleLogicCheckTypeVO;
import lombok.*;

/**
 * @Author: dior
 * @CreateTime: 2024-04-23  13:06
 * @Description:
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RuleActionEntity<T extends RuleActionEntity.RaffleEntity> {

    private String code = RuleLogicCheckTypeVO.ALLOW.getCode();
    private String info = RuleLogicCheckTypeVO.ALLOW.getInfo();
    private String ruleModel;
    private T data;

    static public class RaffleEntity {//抽奖的前中后三种规则实体都要是它的子类，（我提供几个类就传几个类，保证只有三种规则）

    }

    // 抽奖之前
    @EqualsAndHashCode(callSuper = true)
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    //抽奖前
    static public class RaffleBeforeEntity extends RaffleEntity {
        /**
         * 策略ID
         */
        private Long strategyId;

        /**
         * 权重值Key；用于抽奖时可以选择权重抽奖。（strategyId+ruleWeightValueKey两个字段参数联合装配IStrategyRepository.java）
         */
        private String ruleWeightValueKey;

        /**
         * 奖品ID；（黑名单我直接给你返回奖品就够了，不需要抽）
         */
        private Integer awardId;
    }

    // 抽奖之中
    static public class RaffleCenterEntity extends RaffleEntity {

    }

    // 抽奖之后
    static public class RaffleAfterEntity extends RaffleEntity {

    }

}
