package Thread1;

/**
 * @ClassName First
 * @Description TODO
 * @Author DELL
 * @Data 2020/3/9 13:53
 * @Version 1.0
 **/
public class First {
//    public static void main(String[] args) throws InterruptedException {
//        Thread.sleep(9999999999L);
//
//    }
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
               //try {
                    System.out.println(Thread.currentThread().getName());
//                    Thread.sleep(9999999999L);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
                // }
            }
        }).start();
        System.out.println( Thread.currentThread().getName());
    }
}
