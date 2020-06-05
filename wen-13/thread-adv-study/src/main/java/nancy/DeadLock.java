package nancy;

/**
 * @ClassName DeadClock
 * @Description TODO
 * @Author DELL
 * @Data 2020/6/3 19:58
 * @Version 1.0
 **/

/**
 * 死锁产生的条件：
 * 1、互斥条件：这个资源只由当前线程占有，如果其他线程请求这个资源就只有等待，直到占有资源的线程释放资源
 * 2、请求并且持有条件：指的是一个线程已经持有了至少一个资源但是又提了新的资源的申请，而新资源被其他线程占用，
 *    所以当前线程会被阻塞，阻塞的同时又不释放自己已经拥有的资源
 * 3、不可剥夺的条件：指线程获取到的资源在自己使用完之前不能被其他线程抢占，只有自己执行完才可以释放该资源
 * 4、环路等待条件：只在发生死锁的时候，必然存在一个线程-资源的环路链
 *
 *
 * 避免死锁：我们只需要破坏一个条件就好，目前只有请求并持有，环路等待是可以破坏的
 * 资源申请的有序性，我们可以保证b的获取资源的顺序和a一样
 */
public class DeadLock {
    private static Object resourceA = new Object();
    private static Object resourseB = new Object();
    public static void main(String[] args) {
        //创建线程A
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA){
                    System.out.println(Thread.currentThread().getName()+"get ResourceA");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"waiting get ResourcesB");
                    synchronized (resourseB){
                        System.out.println(Thread.currentThread().getName()+"get RourceseB");
                    }
                }
            }
        });
        //创建线程B
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourseB){
                    System.out.println(Thread.currentThread().getName()+"get ResourceB");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"waiting get ResourcesA");
                    synchronized (resourceA){
                        System.out.println(Thread.currentThread().getName()+"get RourceseA");
                    }
                }
            }
        });
        threadA.start();
        threadB.start();


    }

}