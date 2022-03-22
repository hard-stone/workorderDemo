package state.order.node;

/**
 * @author renbin
 * @date 2022年03月16日 17:07
 */
public class OrderNode extends TreeNode {

    public OrderNode(String data, Integer nodeId, Integer parentId) {
        super(data, nodeId, parentId);
    }

    public OrderNode(String data, Integer nodeId, Integer parentId, String nodeType) {
        super(data, nodeId, parentId, nodeType);
    }

    public OrderNode(String data, Integer nodeId, TreeNode parentNode, TreeNode firstChildNode, TreeNode rightNode) {
        super(data, nodeId, parentNode, firstChildNode, rightNode);
    }

    public OrderNode(String data, Integer nodeId, TreeNode parentNode, String nodeType, TreeNode firstChildNode, TreeNode rightNode) {
        super(data, nodeId, parentNode, nodeType, firstChildNode, rightNode);
    }
}
