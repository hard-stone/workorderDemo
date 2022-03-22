package state.order.node;

import lombok.Data;

import java.util.List;

/**
 * 1 双亲链表存储结构
 * 2 孩子链表存储结构
 * 3 双亲孩子链表存储结构
 * 4 孩子兄弟链表存储结构
 * @author renbin
 * @date 2022年03月16日 11:15
 */
@Data
public abstract class TreeNode{

    private String data;

    private Integer nodeId;

    private Integer parentId;//双亲链表存储结构
    private TreeNode parentNode;

    private Integer depth;

    private String nodeType; //simple-1 complex-2

    private List<Integer> childNodes;//孩子链表存储结构

    private List<Integer> brotherNodes;

    //孩子兄弟链表存储结构
    private TreeNode firstChildNode;
    private TreeNode rightNode;

    boolean isLeaf;

    boolean isRoot;

    //双亲构造
    public TreeNode(String data, Integer nodeId, Integer parentId) {
        this.data = data;
        this.nodeId = nodeId;
        this.parentId = parentId;
        this.nodeType = "1";
    }

    public TreeNode(String data, Integer nodeId, Integer parentId, String nodeType) {
        this(data,nodeId,parentId);
        this.nodeType = nodeType;
    }

    public TreeNode(String data, Integer nodeId, TreeNode parentNode, TreeNode firstChildNode, TreeNode rightNode) {
        this.data = data;
        this.nodeId = nodeId;
        this.parentNode = parentNode;
        this.firstChildNode = firstChildNode;
        this.rightNode = rightNode;
        this.nodeType="1";
    }

    public TreeNode(String data, Integer nodeId, TreeNode parentNode, String nodeType, TreeNode firstChildNode, TreeNode rightNode) {
        this(data,nodeId,parentNode,firstChildNode,rightNode);
        this.nodeType = nodeType;
    }
}
