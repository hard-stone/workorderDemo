package state.order.process;

import state.order.BaseResult;
import state.order.node.SimpleNode;

/**
 * 加签（任一通过则通过） 转派（插入节点）  并行会签（所有人都通过）
 * @author renbin
 * @date 2022年03月16日 10:31
 */
public interface IProcess<T> {

    BaseResult<String> create(T processInfos);

    BaseResult<String> start();

    //转派
    Boolean reAssign(SimpleNode operaNode, SimpleNode assignTo) throws Exception;


}
