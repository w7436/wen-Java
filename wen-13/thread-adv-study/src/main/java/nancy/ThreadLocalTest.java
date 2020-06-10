package nancy;

import org.junit.Test;

/**
 * @ClassName ThreadLocal
 * @Description TODO
 * @Author DELL
 * @Data 2020/6/6 10:34
 * @Version 1.0
 **/
public class ThreadLocalTest {
    private static ThreadLocal<String> HOLDER  = new ThreadLocal<>();
    @Test
    public void t1(){
//        ThreadLocal对象都和线程绑定，里面的值线程间是隔离开得
//        HOLDER.get();//获取当前线程，某个ThreadLocal对象的值
//        HOLDER.set("abc");//
//        HOLDER.remove();
        try {
            HOLDER.set("abc");

            for(int i = 0;i < 20;i++) {
                final int j = i;
                new Thread(()->{
                    try {
                        HOLDER.set(String.valueOf(j));
                        if(j == 5) {
                            Thread.sleep(500);
                            System.out.println(HOLDER.get());
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        HOLDER.remove();
                    }
                }).start();
            }
            while(Thread.activeCount() > 1){
                Thread.yield();
            }
            System.out.println(HOLDER.get());
        } finally {
            HOLDER.remove();
        }
    }

}
