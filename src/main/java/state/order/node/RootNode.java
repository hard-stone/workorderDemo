package state.order.node;

import lombok.Data;

/**
 * @author renbin
 * @date 2022年03月22日 16:32
 */

public class RootNode extends ComplexNode {


    public RootNode(String nodeId, String data, String type) {
        super(nodeId, data, type);
    }

    public RootNode(String nodeId, String data, String type, AbsNode<String> firstChildNode) {
        this(nodeId, data, type);
        super.setFirstChildNode(firstChildNode);
    }
}
