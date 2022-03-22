package state.order;


import java.util.Random;
import java.util.concurrent.*;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * @author renbin
 * @date 2022年03月17日 16:10
 */
public class FutureTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

//        testFuture();
        testFutureCom();//异步API

    }

    private static void testFutureCom() throws ExecutionException, InterruptedException {
        System.out.println("start get price...");
        long startTime = System.nanoTime();
        System.out.println("调用异步方法");
//        CompletableFuture<Integer> completedFuture = getAsycPrice("fruit");
        CompletableFuture<Integer> completedFuture = simpleGetAsycPrice("fruit");
        System.out.println("异步调用完成，顺序执行..");
        Integer integer = completedFuture.get();
        System.out.println("只是把获取动作置后，获取的时候还是阻塞..");
        System.out.println("price:"+integer);
        long entTIME = System.nanoTime();
        System.out.println("阻塞时间:"+(entTIME-startTime)/1_000_000);

    }

    private static CompletableFuture<Integer> simpleGetAsycPrice(String fruit) {
        return CompletableFuture.supplyAsync(()-> {
            Integer price = null;
            try {
                price = caculatePrice(fruit);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return price;
        });
    }

    private static CompletableFuture<Integer> getAsycPrice(String fruit) {
        CompletableFuture<Integer> integerCompletedFuture = new CompletableFuture<Integer>();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                Integer price = null;
                try {
                    price = caculatePrice(fruit);
                } catch (InterruptedException e) {
                    integerCompletedFuture.completeExceptionally(e);
                }
                integerCompletedFuture.complete(price);
            }
        });
        return integerCompletedFuture;
    }

    private static void testFuture() throws InterruptedException, ExecutionException, TimeoutException {
        System.out.println("start get price...");
        long startTime = System.nanoTime();
        Integer fruit = getPrice("fruit");
        long entTIME = System.nanoTime();
        System.out.println("price:"+fruit);
        System.out.println("阻塞时间:"+(entTIME-startTime)/1_000_000);
    }

    private static Integer getPrice(String fruit) throws InterruptedException, TimeoutException, ExecutionException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<Integer> integerFuture = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return caculatePrice(fruit);
            }
        });
        System.out.println("我也可以顺序执行，get阻塞动作置后..");
        return integerFuture.get(3000, SECONDS);
    }

    private static Integer caculatePrice(String fruit) throws InterruptedException {
        Thread.sleep(5000);
        Random random = new Random();
        return random.nextInt(100);
    }
}
