package state.order.process;

import state.order.BaseResult;

/**
 * @author renbin
 * @date 2022年03月16日 10:31
 */
public interface IProcess<T> {

    BaseResult<String> create(T processInfos);

    BaseResult<String> start();

}
