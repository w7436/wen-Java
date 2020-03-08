package lesson2;

/**
 * @ClassName ThreadJoin
 * @Description TODO
 * @Author DELL
 * @Data 2020/3/8 16:08
 * @Version 1.0
 **/
public class ThreadJoin {

    public static void without() throws InterruptedException {
        //打印是顺序是Thread-0   main
        Thread t=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });
        t.start();
        t.join();//等待t线程执行完毕
        System.out.println(Thread.currentThread().getName());
    }

    public static void withoutSleep() throws InterruptedException {
        //打印是顺序是Thread-0   main
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });
        t.start();
        //t线程执行时间和2秒钟谁先到，就以这个时间点作为main线程等待的时间点，到了这个时间点就往下执行
        // t执行完（比2秒钟更快），就往下执行
        t.join(2000);
        System.out.println(Thread.currentThread().getName());
    }

    public static void withsleep() throws InterruptedException {

        //执行顺序是  main   Thread-0
        Thread t =new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                    System.out.println(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
        // 当前线程main线程等待2秒钟就往下执行（因为t线程执行时间比2秒钟慢）
        t.join(2000);
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) throws InterruptedException {
        // 当前线程：代码行执行的时候，所在的线程
        // t线程：线程引用对象
        // 当前线程进行阻塞（运行态---->阻塞态）等待（满足一定条件），t线程（不做任何处理，让t执行运行）
        // 一定条件是什么：以下条件哪个先执行完，就满足
        // （1）传入的时间（时间值+时间单位毫秒）
        // （2）线程引用对象执行完毕
//     without();
       withoutSleep();
//     withsleep();
    }
}
