package Thread6;

/**
 * @ClassName MyBlockingQueue
 * @Description TODO
 * @Author DELL
 * @Data 2020/3/27 19:15
 * @Version 1.0
 **/

import com.oracle.jrockit.jfr.Producer;

import java.util.function.Consumer;

/**
 *实现阻塞式队列
 * 1、满足线程安全的生产，消费的功能
 * 2、生产，消费达到上限/下限，需要阻塞等待
 * */

public class MyBlockingQueue<E> {

    private Object[] items;
    private int putIndex;//添加元素的索引位置
    private int takeIndex;//弹出元素的索引位置
    private int size;//有效容量

    public MyBlockingQueue(int capacity) {
       items = new Object[capacity];
    }

    public synchronized void put(E e) throws InterruptedException {
        while (size == items.length){//达到上限需要等待的操作
            //对当前线程进行阻塞
            wait();
        }
        putIndex = (putIndex+1)%items.length;//需要满足循环队列索引>数组情况的操作
        items[putIndex] = e;
        size++;
        notifyAll();
    }

    public synchronized E take() throws InterruptedException {
        while (size == 0){
            wait();
        }
        takeIndex = (takeIndex + 1)%items.length;
        size--;
        notifyAll();
        return (E)items[takeIndex];
    }

    public static void main(String[] args) throws InterruptedException {
        MyBlockingQueue<Integer> queue = new MyBlockingQueue<>(100);
        for(int i = 0;i < 5;i++){
            final int k = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        for (int j = 0;j < 100;j++){
                            queue.put(k*100+j);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        while(true){
            int num = queue.take();
            System.out.println(num);
        }
    }
}






















