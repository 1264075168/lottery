package cn.bugstack.test.domain;

import cn.bugstack.domain.strategy.service.armory.IStrategyArmory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @Author: dior
 * @CreateTime: 2024-04-22  16:17
 * @Description:
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class StrategyArmoryTest {
    @Resource
    IStrategyArmory strategyArmory;
    @Test
    public void test_strategyArmory_notNull() {
        // 断言 strategyArmory 不为空
        Assert.assertNotNull(strategyArmory);
    }
    @Test
    public void test_assembleLotteryStrategy_withNonNullStrategyId() {
        // 定义一个非空的 strategyId
        Long strategyId = 100002L;

        // 断言 strategyId 不为空
        Assert.assertNotNull(strategyId);

        // 调用被测试的方法并进行其他测试逻辑...
    }

    @Test
    public void test_strategyArmory(){
        strategyArmory.assembleLotteryStrategy(100001L);
    }
    @Test
    public void test_getAssembleRandomVal(){
        log.info("测试结果：{} - 奖品ID值", strategyArmory.getRandomAwardId(100001L));
        log.info("测试结果：{} - 奖品ID值", strategyArmory.getRandomAwardId(100001L));
        log.info("测试结果：{} - 奖品ID值", strategyArmory.getRandomAwardId(100001L));
    }
}
