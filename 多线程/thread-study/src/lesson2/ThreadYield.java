package lesson2;

/**
 * @ClassName ThreadYield
 * @Description TODO
 * @Author DELL
 * @Data 2020/3/8 16:31
 * @Version 1.0
 **/
public class ThreadYield {

    public static void main(String[] args) {


        //打印结果 Thread-0  main

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }).start();
        // 等待new Thread所有线程执行完毕，否则一直等待
        while(Thread.activeCount() > 1){//使用调试的方式运行
            Thread.yield();//将当前的线程由运行态 转变为  就绪态
        }
        System.out.println(Thread.currentThread().getName());
    }
}
