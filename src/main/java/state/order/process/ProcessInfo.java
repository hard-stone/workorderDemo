package state.order.process;

import lombok.Data;
import state.order.node.WorkOrderInfo;

import java.util.List;

/**
 * @author renbin
 * @date 2022年03月16日 17:23
 */
@Data
public class ProcessInfo {

    private String processName;
    private String customName;
    private List<WorkOrderInfo> workOrderInfos;

}
