package state.order.node;

import lombok.Data;

/**
 * @author renbin
 * @date 2022年03月16日 11:20
 */
@Data
public abstract class AbsNode implements INode<String> {

    private String nodeId;
    private String data;
    private String type;//去掉？

    private AbsNode parentNode;
    private AbsNode leftNode;
    private AbsNode rightNode;
    private AbsNode firstChildNode;


    public AbsNode(String nodeId,String data, String type) {
        this.nodeId = nodeId;
        this.data = data;
        this.type = type;
    }

    @Override
    public String toString() {
        return "AbsNode{" +
                "nodeId='" + nodeId + '\'' +
                ", data='" + data + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
