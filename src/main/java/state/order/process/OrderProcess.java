package state.order.process;

import state.order.BaseResult;
import state.order.node.AbsNode;
import state.order.node.ComplexNode;
import state.order.node.RootNode;
import state.order.node.SimpleNode;

/**
 * @author renbin
 * @date 2022年03月16日 17:15
 */
public class OrderProcess extends AbsOrderProcess{

    //插入串行简单节点
    //删除串行简单节点
    //插入并行节点
    //删除并行节点
    private RootNode rootNode;//储存根节点

    public RootNode getRootNode() {
        return rootNode;
    }

    public void setRootNode(RootNode rootNode) {
        this.rootNode = rootNode;
    }

    private void initProcess(){

    }

    public void outputNodeSequence(AbsNode<String> node){
        recursion(node);
    }

    /**
     * 查找指定节点
     * @param nodeId
     * @return
     * @throws Exception
     */
    public AbsNode<String> selectAssignSimpleNode(String nodeId) throws Exception {
        AbsNode<String> node = recursion(rootNode, nodeId);
        if (node==null){
            throw new Exception("无法查找指定节点:"+nodeId);
        }
        return node;
    }

    /**
     * 查找指定节点的左节点
     * @param nodeId
     * @return
     */
    public AbsNode<String> selectAssignNodeLeftNode(String nodeId) throws Exception {
        AbsNode<String> node = recursionLeftNode(rootNode, nodeId);
        if (node==null){
            throw new Exception("无法查找指定节点的左节点:"+nodeId);
        }
        return node;
    }

    /**
     * 查找指定节点的上节点
     * @param nodeId
     * @return
     */
    private AbsNode<String> selectAssignNodePreNode(String nodeId) throws Exception {
        AbsNode<String> node = recursionPreNode(rootNode, nodeId);
        if (node==null){
            throw new Exception("无法查找指定节点的上一个节点:"+nodeId);
        }
        return node;
    }

    private AbsNode<String> recursionPreNode(AbsNode<String> node, String nodeId) {
        if (node.getFirstChildNode()!=null){//TODO hasNext
            if (node.getFirstChildNode().getNodeId().equals(nodeId)){
                return node;
            }
            return recursionLeftNode(node.getFirstChildNode(),nodeId);
        }
        if (node.getRightNode()!=null){
            if (node.getRightNode().getNodeId().equals(nodeId)){
                return node;
            }
            return recursionLeftNode(node.getRightNode(),nodeId);
        }
        return null;
    }


    private AbsNode<String> recursionLeftNode(AbsNode node, String nodeId) {
        if (node.getFirstChildNode()!=null){//TODO hasNext
            return recursionLeftNode(node.getFirstChildNode(),nodeId);
        }
        if (node.getRightNode()!=null){
            if (node.getRightNode().getNodeId().equals(nodeId)){
                return node;
            }
            return recursionLeftNode(node.getRightNode(),nodeId);
        }
        return null;
    }


    private AbsNode<String> recursion(AbsNode<String> rootNode, String nodeId) {
        if (rootNode.getNodeId().equals(nodeId))
            return rootNode;
        if (rootNode.getFirstChildNode()!=null){//TODO hasNext
            return recursion(rootNode.getFirstChildNode(),nodeId);
        }
        if (rootNode.getRightNode()!=null){
            return recursion(rootNode.getRightNode(),nodeId);
        }
        return null;
    }

    private void recursion(AbsNode<String> node) {
        System.out.println(node.getData());
        if (node.getFirstChildNode()!=null){//TODO hasNext
            recursion(node.getFirstChildNode());
        }
        if (node.getRightNode()!=null){
            recursion(node.getRightNode());
        }
    }

    @Override
    public BaseResult<String> create(ProcessInfo processInfos) {
        return null;
    }

    @Override
    public BaseResult<String> start() {
        return null;
    }

    /**
     * 转派-插入节点
     * @param operaNode
     * @param assignTo
     * @return
     * @throws Exception
     */
    @Override
    public Boolean reAssign(SimpleNode operaNode, SimpleNode assignTo) throws Exception {
        //查找原节点的右节点,修改插入节点的右节点
        AbsNode<String> rightNode = operaNode.getRightNode();
        assignTo.setRightNode(rightNode);
        //修改原节点的右节点为新插入节点
        operaNode.setRightNode(assignTo);
//        AbsNode<String> leftNode = selectAssignNodeLeftNode(operaNode.getNodeId());
//        AbsNode<String> preNode = selectAssignNodePreNode(operaNode.getNodeId());
//        if (preNode.getFirstChildNode()!=null){//如果有长子节点
//            preNode.setFirstChildNode(assignTo);
//        }else{//否则就是左节点
//            preNode.setRightNode(assignTo);
//        }
        return true;
    }

    /**
     * 加签 任一节点通过则通过
     * @return
     */
    public Boolean addSign(SimpleNode operaNode,SimpleNode addSigner){
//        new ComplexNode();
        return true;
    }


}
