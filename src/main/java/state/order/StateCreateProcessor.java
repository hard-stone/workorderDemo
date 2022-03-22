package state.order;

import state.order.inter.StateProcessor;

/**
 * @Author renbin
 * @Description
 * @Date 2022/3/14 21:32
 */
@OrderProcessor(state = "TempSave", event = "create", bizCode = "workorder")
public class StateCreateProcessor extends AbstractStateProcessor<String,CreateOrderContext>{


    @Override
    public ServiceResult<String> check(StateContext<CreateOrderContext> context) {
        return null;
    }

    @Override
    public String getNextState(StateContext<CreateOrderContext> context) {
        return null;
    }

    @Override
    public ServiceResult<String> action(String nextState, StateContext<CreateOrderContext> context) throws Exception {
        return null;
    }

    @Override
    public ServiceResult<String> save(String nextState, StateContext<CreateOrderContext> context) throws Exception {
        return null;
    }

    @Override
    public void after(StateContext<CreateOrderContext> context) {

    }

    @Override
    public void doProcess() {

    }
}
