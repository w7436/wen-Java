package Test1;

/**
 * @ClassName ThreadDemo
 * @Description TODO
 * @Author DELL
 * @Data 2020/3/28 20:04
 * @Version 1.0
 **/
public class ThreadDemo {
    private static volatile int INDEX;

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for(int i=0; i<10; i++){
                        synchronized (ThreadDemo.class){
                            while (INDEX % 3 != 0){
                                ThreadDemo.class.wait();
                            }
                            INDEX++;
                            System.out.print("A");
                            ThreadDemo.class.notifyAll();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for(int i=0; i<10; i++){
                        synchronized (ThreadDemo.class){
                            while (INDEX % 3 != 1){
                                ThreadDemo.class.wait();
                            }
                            INDEX++;
                            System.out.print("B");
                            ThreadDemo.class.notifyAll();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for(int i=0; i<10; i++){
                        synchronized (ThreadDemo.class){
                            while (INDEX % 3 != 2){
                                ThreadDemo.class.wait();
                            }
                            INDEX++;
                            System.out.println("C");
                            ThreadDemo.class.notifyAll();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
