package Thread7;

import javafx.concurrent.Task;

import javax.xml.crypto.Data;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Period;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;

/**
 * @ClassName MyTimer
 * @Description
 * 定时器：
 * 1、在约定的一个点上，执行任务
 * 2、间隔时间到了，不停的执行任务
 * @Author 文心
 * @Data 2020/3/29 10:43
 * @Version 1.0
 **/

public class MyTimer {

    private BlockingQueue<MyTimerTask> queue =new PriorityBlockingQueue();
    public MyTimer(){
        new Thread(new worker(queue)).start();
    }

    private static class MyTimerTask implements Comparable<MyTimerTask>{
       //定时任务
        private Runnable task;
        //下次执行时间
        private long next;
        private  long period;

        /**
         *
         * @param task 需要执行的任务
         * @param next 从当前时间延迟多少ms
         * @param period 间隔时间：《=0 就忽略掉，>0需要每间隔给定时间，就执行任务
         */
        public MyTimerTask(Runnable task, long next,long period) {
            this.task = task;
            this.next = next;
            this.period = period;
        }

        @Override
        public int compareTo(MyTimerTask o) {
            return Long.compare(next,o.next);
        }
    }

    public  static class worker implements Runnable{
        private BlockingQueue<MyTimerTask> queue;

        public worker(BlockingQueue<MyTimerTask> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            try {
                while(true){
                    MyTimerTask task = queue.take();//blockingQueue本身就是线程本身是安全的，所以不用加锁
                    synchronized (queue){
                        long cur = System.currentTimeMillis();
                        if (task.next > cur){
                            Thread.sleep(task.next-cur);
                            queue.put(task);

                        }
                        else{
                            task.task.run();
                            if (task.period >0){
                                task.next = task.next+task.period;
                                queue.put(task);
                            }
                        }
                    }


                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

    /**
    * @param task 需要执行的任务
    * @param delay 从当前时间延迟多少毫秒，执行任务
    * @param period 间隔period时间，就执行任务
    * */
    public void schedule(Runnable task,long delay,long period){
        try {
            queue.put(new MyTimerTask(task,System.currentTimeMillis()+delay,period));
            synchronized (queue){
                queue.notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //JDK的时间操作
    public static void main(String[] args) {

        Date date = new Date();//无参的构造方法，返回的是系统的当前时间
        Date date1 = new Date(9999);//以格林威治时间1970-01-01开始，经过给定时间数量的ms

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        System.out.println(df.format(date));
//        System.out.println(df.format(date1));

 //       long cu = System.currentTimeMillis();

//        TimerTask task = new TimerTask() {
//            @Override
//            public void run() {
//                System.out.println("你好");
//            }
//        };
        new MyTimer().schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("你好啊");
            }
        }, 1000, 1000);

//        ExecutorService pool = Executors.newFixedThreadPool(2);//只有两个正式员工，没有临时工
 //      ExecutorService pool = Executors.newSingleThreadExecutor();//线程池的员工就是一个
//        ExecutorService pool2 = Executors.newCachedThreadPool();//正式员工为0,临时工不限制
 //       ScheduledExecutorService pool = Executors.newScheduledThreadPool(4);//正式工

//        延迟时间，执行时间
//        pool.schedule(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("");
//            }
//        },1,TimeUnit.SECONDS);



//        pool.scheduleAtFixedRate(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("你好");
//            }
//        },1,1,TimeUnit.SECONDS);
    }
}














