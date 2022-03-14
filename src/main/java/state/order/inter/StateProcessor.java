package state.order.inter;

import state.order.ServiceResult;
import state.order.StateContext;

/**
 *
 */
public interface StateProcessor<T,C> {
    /**
     * 执行状态迁移的入口
     */
    ServiceResult<T> action(StateContext<C> context) throws Exception;
}
