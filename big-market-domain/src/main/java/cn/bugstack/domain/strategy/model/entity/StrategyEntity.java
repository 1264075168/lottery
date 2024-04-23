package cn.bugstack.domain.strategy.model.entity;

import cn.bugstack.types.common.Constants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

/**
 * @Author: dior
 * @CreateTime: 2024-04-22  21:33
 * @Description: 策略实体
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StrategyEntity {
    private Long strategyId;
    /** 抽奖策略描述 */
    private String strategyDesc;
    /** 抽奖规则模型 */
    private String ruleModels;

    public String[] ruleModels() {
        //首先，代码使用了 StringUtils.isBlank() 方法检查 ruleModels 是否为空或者只包含空白字符。
        // 如果 ruleModels 为空或者只包含空白字符，则直接返回 null，表示没有规则模型可供处理。
        //如果 ruleModels 不为空，则调用 split() 方法对其进行分割。分割的依据是 Constants.SPLIT，即指定的分隔符。
        // split() 方法将字符串按照指定的分隔符分割成多个子字符串，并将这些子字符串存储到一个字符串数组中。
        //最后，将分割后的字符串数组作为方法的返回值返回。
        if (StringUtils.isBlank(ruleModels)) return null;
        return ruleModels.split(Constants.SPLIT);
    }
    //如果再策略表里的ruleModels字段有rule_weight
    public String getRuleWeight() {
        String[] ruleModels = this.ruleModels();
        if (ruleModels == null) {
            // 在 ruleModels 为空时，返回一个空字符串
            return "";
        }
        for (String ruleModel : ruleModels) {
            if ("rule_weight".equals(ruleModel)) {
                return ruleModel;
            }
        }
        return null;
    }


}
