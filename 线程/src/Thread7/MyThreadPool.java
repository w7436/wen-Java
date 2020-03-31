package Thread7;

import Thread6.MyBlockingQueue;

/**
 * @ClassName MyThreadPool
 * @Description TODO
 * @Author DELL
 * @Data 2020/3/29 10:29
 * @Version 1.0
 **/
public class MyThreadPool {

    private int size;//线程的数量
    private MyBlockingQueue<Runnable> queue;

    public MyThreadPool(int size, int capacity) {

       queue = new MyBlockingQueue<>(capacity);
       //创建正式员工
        for (int i = 0; i < size; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while(true){//正式员工一直运行
                            //从仓库取包：
                            //1、成功取包裹，方法返回
                            //2、仓库里取不出包裹（其他员工正在取，阻塞在synchronized代码行，仓库空了wait方法阻塞）
                            Runnable task = queue.take();
                            //正式员工来送快递（当前线程通过实例方法调用来执行任务）
                            task.run();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

    public void execute(Runnable task){
        try {
            queue.put(task);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        MyThreadPool pool = new MyThreadPool(5,100);
        pool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("A");
            }
        });
        pool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("B");
            }
        });
        pool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("C");
            }
        });
    }
}






















