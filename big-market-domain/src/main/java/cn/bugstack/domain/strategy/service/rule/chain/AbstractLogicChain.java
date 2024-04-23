package cn.bugstack.domain.strategy.service.rule.chain;

/**
 * @Author: dior
 * @CreateTime: 2024-04-24  02:04
* @Description: 兜底 责任链节点
 */
public abstract class AbstractLogicChain implements ILogicChain{
    private ILogicChain next;
    @Override
    public ILogicChain appendNext(ILogicChain next) {
        this.next = next;
        return next;
    }

    @Override
    public ILogicChain next() {
        // 返回下一个节点
        return next;
    }
    protected abstract String ruleModel();//简化我们规则过滤时得getRuleModel()方法
}
