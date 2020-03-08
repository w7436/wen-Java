package lesson2;

/**
 * @ClassName ThreadAdvantage
 * @Description TODO
 * @Author DELL
 * @Data 2020/3/8 9:38
 * @Version 1.0
 **/
public class ThreadAdvantage {

    private static final int NUM = 5;

    private static void increment(){
        int count = 10_0000_0000;
        int r=0;
        for(int i=0; i<count; i++){
            r++;
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
        while(Thread.activeCount() > 1){//使用调试的方式运行
            Thread.yield();
        }
        long end = System.currentTimeMillis();
        System.out.printf("并发执行时间：%s毫秒\n", end-start);
    }

    public static void main(String[] args) {
        serial();
        parallel();
    }
}


