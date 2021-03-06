package nancy;

import java.util.concurrent.*;

/**
 * @ClassName CallableTest
 * @Description TODO
 * @Author DELL
 * @Data 2020/6/3 18:47
 * @Version 1.0
 **/

/**
 * Callable创建线程：Future/FutureTask
 */
public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> c = new Callable() {
            @Override
            public Object call() throws Exception {
                System.out.println("call");
                return 123;
            }
        };

        //Thread使用Callable
        FutureTask<Integer> task = new FutureTask(c);
        new Thread(task).start();
        System.out.println("main");
        Integer r = task.get();//当前线程阻塞等待，直到线程执行完毕（join），但是可以获取线程的返回值
        System.out.println(r);

        //线程池使用Callable
        ExecutorService pool = Executors.newFixedThreadPool(4);
        Future<Integer> future = pool.submit(c);
        System.out.println("main");
        Integer r1 = future.get();//阻塞等待
        System.out.println(r1);
    }
}