package Thread2;

/**
 * @ClassName MyThread
 * @Description TODO
 * @Author DELL
 * @Data 2020/3/23 15:50
 * @Version 1.0
 **/
public class Main{
    public static void main(String[] args) {
        //方法1
        MyThread myThread = new MyThread();
        //run是方法的调用,不会启动线程，是在当前线程里调用方法
//        myThread.run();    //main
        myThread.start();    //Thread-0

        //方式2
//        new Thread(new MyRunnable()).start();//线程启动是通过Start方法启动的

        //
    }
}
class MyThread extends Thread {
    @Override
    public void run() {
        //代码
        System.out.println(Thread.currentThread().getName());
    }
}

class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
