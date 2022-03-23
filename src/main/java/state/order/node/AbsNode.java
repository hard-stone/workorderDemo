package state.order.node;

import lombok.Data;

/**
 * @author renbin
 * @date 2022年03月16日 11:20
 */
@Data
public abstract class AbsNode<String> implements INode<String> {

    private String nodeId;
    private String data;
    private String type;//去掉？ root-1.sim-2,con-3,com-4

    private AbsNode<String> firstChildNode;
    //去掉ParentNode
//    private ComplexNode parentNode;
    //去掉LeftNode
//    private AbsNode<String> leftNode;
    private AbsNode<String> rightNode;

    public AbsNode() {
    }

    public AbsNode(String nodeId, String data, String type) {
        this.nodeId = nodeId;
        this.data = data;
        this.type = type;
    }

    @Override
    public String getElement() {
        return this.data;
    }

    @Override
    public void setElement(String data) {
        this.data = data;
    }

    @Override
    public java.lang.String toString() {
        return "AbsNode{" +
                "nodeId=" + nodeId +
                ", data=" + data +
                ", type=" + type +
                '}';
    }
}
