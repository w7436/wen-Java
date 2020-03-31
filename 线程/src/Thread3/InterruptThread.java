package Thread3;

/**
 * @ClassName InterruptThread
 * @Description TODO
 * @Author DELL
 * @Data 2020/3/11 18:45
 * @Version 1.0
 **/
public class InterruptThread {

    //中断一个线程，但是线程没有处理
    public static void test1(){
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){

                }
            }
        });
        t.start();
        t.interrupt();  //在main线程中中断子线程
    }

    public static void test2() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
//                while (Thread.currentThread().isInterrupted()){
                while(Thread.interrupted()){
                    System.out.println(Thread.currentThread().getName());
                }
            }
        });
        t.start();//t线程的中断表示位false
        t.interrupt();//中断标志位为true
    }

    public static void test3(){
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().isInterrupted());//true
                    Thread.sleep(3000);//线程调用wait()/join()/sleep()阻塞时，如多当前线程中断，直接抛出异常
                    //阻塞状态，通过捕获处理异常，进行中断，抛出异常之后，线程中断表示位重置
                    System.out.println(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println(Thread.currentThread().isInterrupted());//false
                }
            }
        });
        t.start();//false
        t.interrupt();//true
    }
    public static void test4(){
        Thread t= new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0;i < 10;i++){
                  //  System.out.println(Thread.interrupted());//返回并重置标志位
                    System.out.println(Thread.currentThread().isInterrupted());
                }
            }
        });
        t.start();
        t.interrupt();
    }

    private static volatile boolean IS_INTERRUPPTED;
    // 使用自定义的中断
    public static void test5(){
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                //自定义的的满足运行态
//                while (!IS_INTERRUPPTED){
//                    System.out.println(Thread.currentThread().isInterrupted());
//                }
                try {
                    Thread.sleep(999);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }) ;
        t.start();
        IS_INTERRUPPTED = true;
    }
    public static void main(String[] args) {
       test5();
    }
}
