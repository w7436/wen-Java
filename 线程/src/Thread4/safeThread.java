package Thread4;

/**
 * @ClassName safeThread
 * @Description TODO
 * @Author DELL
 * @Data 2020/3/24 13:16
 * @Version 1.0
 **/
public class safeThread {
    public static int num = 0 ;//局部变量int内型的值，处于-128~127之间是在常量池，超过也存在堆里
    public static void main(String[] args) {
        //同时启动20个线程，每个线程对同一个变量执行操作：循环100000次，每次循环++操作
        for (int i = 0; i < 20; i++ ){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0 ; i < 10000; i++){
//                        increment();
                        synchronized (safeThread.class){
                            num++;
                        }
                    }
                }
            }).start();
        }
        while (Thread.activeCount()> 1){
            Thread.yield();
        }
        //1、不是我们预期的结果
        //2、每次的结果不一样
        System.out.println(num);

    }

    /**
     * 等同于synchronized（safeThread.class）
     */
    //对当前类对象进行加锁
    public static synchronized void increment(){
        num++;
    }

    /**
     * 等同于synchronized（this）{}
     */
    // new safeThread().increment1();
    public synchronized void increment1(){

    }

//    public void increment2(){
//        synchronized (this){
//
//        }
//    }
}
