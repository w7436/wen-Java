package lesson2;

/**
 * @ClassName DaemonThread
 * @Description TODO
 * @Author DELL
 * @Data 2020/3/8 16:37
 * @Version 1.0
 **/
public class DaemonThread  {
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(99999);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        //设置线程为守护线程
        t.setDaemon(true);
        t.start();

    }

}
