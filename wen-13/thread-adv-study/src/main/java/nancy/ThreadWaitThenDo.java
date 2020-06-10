package nancy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

/**
 * @ClassName ThreadWaitThenDo
 * @Description TODO
 * @Author DELL
 * @Data 2020/6/6 9:34
 * @Version 1.0
 **/
public class ThreadWaitThenDo {

    @Test
    public void t1(){
        for(int i = 0;i < 20;i++){
            new Thread(()->{
                System.out.println(Thread.currentThread().getName());
            }).start();
        }
        while(Thread.activeCount()>1){
            Thread.yield();
        }
        System.out.println("执行完毕："+Thread.currentThread().getName());
    }
    @Test
    public void t2() throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        for(int i = 0;i < 20;i++){
            Thread t = new Thread(()->{
                System.out.println(Thread.currentThread().getName());
            });
            threads.add(t);
            t.start();
        }
        for(Thread t : threads){
            t.join();
        }
        System.out.println("执行完毕："+Thread.currentThread().getName());
    }
    @Test
    public void t3() throws InterruptedException {
        CountDownLatch cd1 =  new CountDownLatch(20);//计数器的初始值
        for(int i = 0;i < 20;i++){
            new Thread(()->{
                System.out.println(Thread.currentThread().getName());
                cd1.countDown();//计数器的值减一
            }).start();
        }
        cd1.await();//当前线程阻塞等待，直到计数器为0
        System.out.println("执行完毕："+Thread.currentThread().getName());
    }
    @Test
    public void t4() throws InterruptedException {
        Semaphore s = new Semaphore(0);
        for(int i = 0;i < 20;i++){
            new Thread(()->{
                System.out.println(Thread.currentThread().getName());
                s.release();
            }).start();
        }
        s.acquire(20);
        System.out.println("执行完毕："+Thread.currentThread().getName());
    }
    public void t5() throws InterruptedException {
        Semaphore s = new Semaphore(0);
        for(int i = 0;i < 20;i++){
            new Thread(()->{
                //模拟每个线程处理客户端http请求
                System.out.println(Thread.currentThread().getName());
                s.release();
            }).start();
        }
        s.acquire(20);
        System.out.println("执行完毕："+Thread.currentThread().getName());
    }



}
