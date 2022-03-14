package state.order;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import state.order.inter.Checker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Future;

/**
 * @Author renbin
 * @Description
 * @Date 2022/3/14 22:21
 */
@Slf4j
public class CheckerExecutor {
    /**
     * 执行并行校验器，
     * 按照任务投递的顺序判断返回。
     */
//    public ServiceResult<T, C> parallelCheck(List<Checker> checkers, StateContext<C> context) {
//        if (!CollectionUtils.isEmpty(checkers)) {
//            if (checkers.size() == 1) {
//                return checkers.get(0).check(context);
//            }
//            List<Future<ServiceResult>> resultList = Collections.synchronizedList(new ArrayList<>(checkers.size()));
//            checkers.sort(Comparator.comparingInt(Checker::order));
//            for (Checker c : checkers) {
//                Future<ServiceResult> future = executor.submit(() -> c.check(context));
//                resultList.add(future);
//            }
//            for (Future<ServiceResult> future : resultList) {
//                try {
//                    ServiceResult sr = future.get();
//                    if (!sr.isSuccess()) {
//                        return sr;
//                    }
//                } catch (Exception e) {
//                    log.error("parallelCheck executor.submit error.", e);
//                    throw new RuntimeException(e);
//                }
//            }
//        }
//        return new ServiceResult<>();
//    }
}
