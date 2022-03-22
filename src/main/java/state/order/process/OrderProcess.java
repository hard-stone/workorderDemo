package state.order.process;

import state.order.BaseResult;
import state.order.node.WorkOrderInfo;

import java.util.List;
import java.util.Random;

/**
 * @author renbin
 * @date 2022年03月16日 17:15
 */
public class OrderProcess extends AbsOrderProcess {

    //插入串行简单节点
    //删除串行简单节点
    //插入并行节点
    //删除并行节点

    @Override
    public Integer createPro(ProcessInfo processInfo) {
        //插入流程信息...
        Integer proId = insertProInfo(processInfo);
        //构造节点
        List<WorkOrderInfo> workOrderInfos = processInfo.getWorkOrderInfos();
        return null;
    }

    private Integer insertProInfo(ProcessInfo processInfo) {
        Random random = new Random();
        return random.nextInt(100);
    }

    @Override
    public BaseResult<String> start() {
        return null;
    }


}
