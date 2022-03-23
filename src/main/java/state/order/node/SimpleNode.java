package state.order.node;

/**
 * @author renbin
 * @date 2022年03月22日 19:31
 */
public class SimpleNode extends AbsNode<String> {


    public SimpleNode(String nodeId, String data, String type) {
        super(nodeId, data, type);
    }

    public SimpleNode(String nodeId, String data, String type, AbsNode rightNode) {
        this(nodeId, data, type);
        super.setRightNode(rightNode);
    }


}
