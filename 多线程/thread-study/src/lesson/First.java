package lesson;

/**
 * @ClassName First
 * @Description TODO
 * @Author DELL
 * @Data 2020/3/4 19:57
 * @Version 1.0
 **/
public class First {

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(999999999L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

}

