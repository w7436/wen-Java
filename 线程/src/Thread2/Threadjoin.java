package Thread2;

import javax.swing.plaf.SliderUI;

/**
 * @ClassName Threadjoin
 * @Description TODO
 * @Author DELL
 * @Data 2020/3/23 16:41
 * @Version 1.0
 **/
public class Threadjoin {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                    System.out.println(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();

        //当前线程：代码执行的时候，所在的线程
        //t线程：线程引用对象
        //当前进程进行阻塞，等待（满足一定的要求），t线程不做任何约束
        //一定的条件：哪个时间先执行完，就执行
        // （1）如果有时间，就有时间条件（2）线程引用对象执行完毕
//         t.join();
        t.join(2000);
        System.out.println(Thread.currentThread().getName());
    }
}
