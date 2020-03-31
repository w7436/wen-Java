package Thread2;

/**
 * @ClassName DaempoThread
 * @Description TODO
 * @Author DELL
 * @Data 2020/3/23 16:08
 * @Version 1.0
 **/
public class DaempoThread {
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(99999999L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        //设置守护线程，
        t.setDaemon(true);
        t.start();

    }
}
