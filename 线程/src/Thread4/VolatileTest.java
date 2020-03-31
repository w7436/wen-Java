package Thread4;

/**
 * @ClassName VolatileTest
 * @Description TODO
 * @Author DELL
 * @Data 2020/3/24 16:37
 * @Version 1.0
 **/
public class VolatileTest {
    public static int num = 0 ;//int内型的值，处于-128~127之间是在常量池，超过也存在堆里
    public volatile static int sum = 0;
    public static void main(String[] args) {
        //同时启动20个线程，每个线程对同一个变量执行操作：循环100000次，每次循环++操作
        for (int i = 0; i < 20; i++ ){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0 ; i < 10000; i++){
//                        increment();
                            sum++;
                            //分界三条指令
                        // 读取主内存SUM变量
                        //sum = sum + 1
                        //写回主内存
                        //volatile不能保证原子性，所以不能满足n++,n--操作的线程安全
                        //对变量进行赋值操作时候，需要的是常量（不能依赖变量）
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
//    public static synchronized void increment(){
//        num++;
//    }
}
