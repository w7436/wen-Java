package Thread2;

/**
 * @ClassName YieldThread
 * @Description TODO
 * @Author DELL
 * @Data 2020/3/23 16:36
 * @Version 1.0
 **/
public class YieldThread {

    //先打印Thread-0
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }).start();
        while (Thread.activeCount() >1){
            Thread.yield();  //main线程由运行太转变为就绪态
        }
        System.out.println(Thread.currentThread().getName());
    }
}
