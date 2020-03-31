package Thread2;

public class Advantage {

    private static final int NUM = 5;

    private static void increment(){
        int count = 10_0000_0000;
        for(int i=0; i<count; i++){
            count++;
        }
    }
    // 串行（代码行依次执行）
    private static void serial(){
        long start = System.currentTimeMillis();// 1970-01-01开始，到当前时间的毫秒数
        for(int i=0; i<NUM; i++){
            increment();
        }
        long end = System.currentTimeMillis();
        System.out.printf("串行执行时间：%s毫秒\n", end-start);
    }
    // 并发（有时候Java语义里边，并发这个词即表达并发、也表达并行）
    private static void parallel(){
        long start = System.currentTimeMillis();
        for(int i=0; i<NUM; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    increment();
                }
            }).start();
        }
        //等待 new Thread 所有的线程执行完毕
        while(Thread.activeCount() > 1){//使用调试的方式运行
            Thread.yield();//当前线程由运行态转变为就绪态
        }
        long end = System.currentTimeMillis();
        System.out.printf("并发执行时间：%s毫秒\n", end-start);
    }

    public static void main(String[] args) {
        serial();
        parallel();
    }
}

