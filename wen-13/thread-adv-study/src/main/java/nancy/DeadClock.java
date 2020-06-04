package nancy;

/**
 * @ClassName DeadClock
 * @Description TODO
 * @Author DELL
 * @Data 2020/6/3 19:58
 * @Version 1.0
 **/
class Pen {
    private String pen = "笔" ;
    public String getPen() {
        return pen;
    }
}
class Book {
    private String book = "本" ;
    public String getBook() {
        return book;
    }
}
class DeadCLock {
    private static Pen pen = new Pen() ;
    private static Book book = new Book() ;
    public static void main(String[] args) {
        new DeadCLock().deadLock();
    }
    public void deadLock() {
        Thread thread1 = new Thread(new Runnable() { // 笔线程
            @Override
            public void run() {
                try {
                    synchronized (pen) {
                        System.out.println(Thread.currentThread()+" :我有笔，我就不给你");
                        Thread.sleep(1000);
                        synchronized (book) {
                            System.out.println(Thread.currentThread()+" :把你的本给我！");
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"Pen") ;
        Thread thread2 = new Thread(new Runnable() { // 本子线程
            @Override
            public void run() {
                try {
                    synchronized (book) {
                        System.out.println(Thread.currentThread()+" :我有本子，我就不给你！");
                        Thread.sleep(1000);
                        synchronized (pen) {
                            System.out.println(Thread.currentThread()+" :把你的笔给我！");
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"Book") ;
        thread1.start();
        thread2.start();
    }
}