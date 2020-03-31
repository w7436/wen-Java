package Thread7;

import java.util.concurrent.*;

/**
 * @ClassName ThreadPoolExecuteTest
 * @Description TODO
 * @Author DELL
 * @Data 2020/3/29 15:05
 * @Version 1.0
 **/
public class ThreadPoolExecuteTest {
    public static void main(String[] args) {
//        ExecutorService pool = Executors.newFixedThreadPool(4);
        ExecutorService pool = new ThreadPoolExecutor(//线程池
                3,//核心线程数（正式工）
                5,//最大线程数（正式工+临时工）
                //临时工雇佣：正式员工忙不过来，创建临时工
                //临时工解雇：空闲时间超过设置的时间范围，就结棍
                1000,//时间树量
                TimeUnit.SECONDS,//时间单位（时间数量+时间单位表示一定范围的时间）
                new ArrayBlockingQueue<>(1000),//阻塞队列：存放包裹的仓库（存放任务的数据结构）
                new ThreadFactory(){
                    @Override
                    public Thread newThread(Runnable r) {
                        return null;
                    }
                },//线程池创建Thread线程的工厂类。没有提供的话，就是用线程池内部默认的创建线程的方法
                //拒绝策略仓库已经满了，
                // CallerRunsPolicy()：谁（execute代码行所在的线程）让我送快递，就自己去
                //.CallerRunsPolicy():直接抛出异常
                //.DiscardOldestPolicy():从阻塞队列丢弃最老的任务
                //.DiscardPolicy():丢弃最新的任务

                new ThreadPoolExecutor.AbortPolicy());

        pool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("你好");
            }
        });
        pool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("世界");
            }
        });


        System.out.println("我们");
    }
}
