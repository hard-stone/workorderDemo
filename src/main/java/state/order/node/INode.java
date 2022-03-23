package state.order.node;

/**
 * @author renbin
 * @date 2022年03月16日 11:20
 */

public interface INode<T> {

    T getElement();
    void setElement(T data);


}
