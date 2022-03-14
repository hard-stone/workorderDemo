package state.order.inter;

import state.order.ServiceResult;
import state.order.StateContext;

public interface Checker<T,C> {
    ServiceResult<T> check(StateContext<C> context);
    /**
     * 多个checker时的执行顺序
     */
    default int order() {
        return 0;
    }
}
