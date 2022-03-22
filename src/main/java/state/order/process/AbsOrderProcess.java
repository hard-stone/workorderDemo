package state.order.process;

import state.order.BaseResult;
import state.order.node.OrderNode;
import state.order.node.WorkOrderInfo;

/**
 * @author renbin
 * @date 2022年03月16日 10:34
 */
public abstract class AbsOrderProcess implements IProcess<ProcessInfo>{

    @Override
    public BaseResult<String> create(ProcessInfo processInfo) {
        System.out.println("创建流程...");
        System.out.println("输入节点信息:");
        createPro(processInfo);
        return new BaseResult<>();
    }

    public abstract Integer createPro(ProcessInfo processInfo);
}
