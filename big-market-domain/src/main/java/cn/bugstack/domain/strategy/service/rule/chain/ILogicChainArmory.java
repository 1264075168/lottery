package cn.bugstack.domain.strategy.service.rule.chain;

/**
 * @Author: dior
 * @CreateTime: 2024-04-24  04:31
 * @Description:
 */
public interface ILogicChainArmory {
    ILogicChain appendNext(ILogicChain next);//填充这个节点的信息
    ILogicChain next();//获取下一个节点
}
