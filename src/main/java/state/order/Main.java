package state.order;

import state.order.node.*;
import state.order.process.OrderProcess;

import java.util.concurrent.*;

/**
 * @author renbin
 * @date 2022年03月16日 17:28
 */
public class Main {
    public static void main(String[] args) throws Exception {
        testNode();
//        testOrderNode();
    }

    private static void testNode() throws Exception {
        RootNode rootNode = new RootNode("1", "根节点1", "1");
        CornerNode cornerNode = new CornerNode("2", "转交节点2", "3" );
        SimpleNode node3 = new SimpleNode("3", "node3", "2");
        SimpleNode node4 = new SimpleNode("4", "node4", "2");
        rootNode.setFirstChildNode(cornerNode);

        cornerNode.setRightNode(node3);
        node3.setRightNode(node4);

        OrderProcess orderProcess = new OrderProcess();
        orderProcess.setRootNode(rootNode);
        orderProcess.outputNodeSequence(rootNode);
        //2转派给5,插入5
        SimpleNode simpleNode5 = new SimpleNode("5", "2转派给5", "2");
        orderProcess.reAssign(cornerNode,simpleNode5);
        orderProcess.outputNodeSequence(rootNode);
//        AbsNode<String> leftNode = orderProcess.selectAssignNodeLeftNode("3");
//        System.out.println("左节点:"+leftNode.toString());
    }

    private static void testSelectLeftNode() {

    }

    private static void testOrderNode() throws ExecutionException, TimeoutException {
//
//        RootNode node0 = new RootNode("0","0node","0", firstChildNode);
//        Node node1 = new Node("1","1node","1");
//        Node node2 = new Node("2","2node","2");
//        Node node3 = new Node("3","3node","3");
//        Node node4 = new Node("4","4node","4");
//
//        node0.setFirstChildNode(node1);
//
//        node1.setRightNode(node2);
//        node1.setParentNode(node0);
//
//        node2.setLeftNode(node1);
//        node2.setRightNode(node3);
//        node3.setLeftNode(node2);
//        node3.setRightNode(node4);
//        node4.setLeftNode(node3);
//
//
//        //遍历
//
//        ExportNodeSeq(node0);
//
//        System.out.println("加签");
//
//        AbsNode temp = node0;
//
//        while (temp.getFirstChildNode()!=null || temp.getRightNode()!=null){
//            if (temp.getNodeId().equals("3")){
//                //加签，任意节点通过则往下 1、替换简单节点为复杂节点 TODO 判断是否有父节点为complexNode，有就直接加right
//                AbsNode firstNode = temp.getFirstChildNode();
//                AbsNode rightNode = temp.getRightNode();
//                AbsNode parentNode = temp.getParentNode();
//                AbsNode leftNode = temp.getLeftNode();
//                ComplexNode complexNode = new ComplexNode("5","complexNode5node","2");
//                //找到上一个节点,修改的兄弟节点
//                if (leftNode!=null){
//                    leftNode.setRightNode(complexNode);
//                    complexNode.setLeftNode(leftNode);
//                }
//                if (rightNode!=null){
//                    rightNode.setLeftNode(complexNode);
//                    complexNode.setRightNode(rightNode);
//                }
//                if (parentNode!=null){
//                    parentNode.setFirstChildNode(complexNode);
//                    complexNode.setParentNode(parentNode);
//                }
//                //复杂节点关联被替换的子节点
//                complexNode.setFirstChildNode(temp);
//                temp.setParentNode(complexNode);
//                //删除被替换子节点多余关系
//                temp.setLeftNode(null);
//                temp.setRightNode(null);
//                break;
//            }else if (temp.getRightNode()!=null){
//                temp = temp.getRightNode();
//            }else if (temp.getFirstChildNode()!=null){
//                temp = temp.getFirstChildNode();
//            }
//        }
//
//
//        //遍历
//        ExportNodeSeq(node0);
//
//
//    }
//
//    private static void ExportNodeSeq(RootNode node0) {
//        System.out.println(node0.getData());
//        AbsNode temp1 = node0;
//        while (temp1.getFirstChildNode()!=null || temp1.getRightNode()!=null){
//            if (temp1.getFirstChildNode()!=null){
//                temp1 = temp1.getFirstChildNode();
//                System.out.println(temp1.getData());
//            }else if (temp1.getRightNode()!=null){
//                temp1 = temp1.getRightNode();
//                System.out.println(temp1.getData());
//            }else {
//                System.out.println("end");
//                break;
//            }
//        }
    }


}
