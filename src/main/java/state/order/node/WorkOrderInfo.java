package state.order.node;

import lombok.Data;

import java.util.Random;

/**
 * @author renbin
 * @date 2022年03月16日 17:09
 */
@Data
public class WorkOrderInfo {

    private String nodeType;//1 普通
    private String nodeName;
    private String nodeVale;
    private String creatBy;


    public Integer createWorkOrder(){
        //插入节点信息
        Integer nodeId = insertWorkOrder();
        //构造节点
        TreeNode treeNode = new OrderNode("test",nodeId,0);
        return nodeId;
    }

    public Integer insertWorkOrder(){
        //插入表
        System.out.println("插入表："+this.toString());
        Random random = new Random();
        return random.nextInt(10);
    }




}
