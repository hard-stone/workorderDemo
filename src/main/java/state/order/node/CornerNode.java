package state.order.node;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author renbin
 * @date 2022年03月22日 19:32
 * 转交节点
 */

public class CornerNode extends SimpleNode {


    public CornerNode(String nodeId, String data, String type){
        super(nodeId,data,type);

    }

    public CornerNode(String nodeId, String data, String type,AbsNode rightNode){
        this(nodeId,data,type);
        super.setRightNode(rightNode);
    }



}
