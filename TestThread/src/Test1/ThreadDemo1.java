package Test1;

/**
 * @ClassName ThreadDemo1
 * @Description TODO
 * @Author DELL
 * @Data 2020/6/4 10:00
 * @Version 1.0
 **/

/**
 *多线程练习模拟三个人同时买100张火车票，每个人相当于一个线程
 */
public class ThreadDemo1 {
    static volatile int SUM = 100;
    public static void main(String[] args) {
        Tickets tickets = new Tickets();

        Thread thread1 = new Thread(tickets);
        thread1.start();

        Thread thread2 = new Thread(tickets);
        thread2.start();

        Thread thread3 = new Thread(tickets);
        thread3.start();
    }
}
class Tickets implements Runnable{
    @Override
    public void run() {
        while (true){
            synchronized (this){
                if(ThreadDemo1.SUM <= 0) break;
                else{
                    try {
                        Thread.sleep(10);
                        System.out.println(Thread.currentThread().getName()+":"+ ThreadDemo1.SUM);
                        ThreadDemo1.SUM--;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
