package state.order;

import state.order.node.Node;

/**
 * @author renbin
 * @date 2022年03月22日 17:18
 */
public class Test {
    public static void main(String[] args) {
        Node sss = new Node("1", "sss", "1");
        if (sss.getRightNode()==null){
            System.out.println(sss.getData());
        }
    }
}
