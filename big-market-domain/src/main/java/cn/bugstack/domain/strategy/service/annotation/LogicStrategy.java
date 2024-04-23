package cn.bugstack.domain.strategy.service.annotation;
import cn.bugstack.domain.strategy.service.rule.filter.factory.DefaultLogicFactory;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * @Author: dior
 * @CreateTime: 2024-04-23  13:47
 * @Description:  * @description 策略自定义枚举（为了增加一个自定义注解，是我们的对象啊可以通过注解扫描的方式自动注入进去）
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface LogicStrategy {

    DefaultLogicFactory.LogicModel logicMode();

}