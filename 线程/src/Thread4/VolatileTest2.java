package Thread4;

/**
 * @ClassName VolatileTest2
 * @Description TODO
 * @Author DELL
 * @Data 2020/3/24 16:50
 * @Version 1.0
 **/
public class VolatileTest2 {
    private volatile static int SUM;
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10000; j++) {
                        if (SUM <100000){
                            synchronized (VolatileTest2.class){
                                   if (SUM <100000) SUM++;
                                }
                            }
                        }
                }
            }).start();

        }
        while (Thread.activeCount()>1){
            Thread.yield();
        }
        System.out.println(SUM);
    }
}





