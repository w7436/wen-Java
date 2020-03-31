package Thread5;

/**
 * @ClassName BreadOperator
 * @Description TODO
 * @Author DELL
 * @Data 2020/3/24 20:33
 * @Version 1.0
 **/
public class BreadOperator {

    //库存面包数量：上线100，
    public static volatile int SUM;

    public static void main(String[] args) {
        //生产者
        for (int i =0; i <5;i++){
            new Thread(new Producer(),"面包师傅"+i).start();
        }
        //消费者
        for (int i = 0; i < 2; i++) {
            new Thread(new comsumer(),"消费者"+i).start();
        }
    }
    //默认生产者:一次生产3个，每个生产20次
    private static class Producer implements Runnable{
        @Override
        public void run() {
            try {
                for (int i = 0; i < 20 ; i++) {
                    synchronized (BreadOperator.class){
                        while (SUM +3 > 100){
                            //释放对象锁
                            BreadOperator.class.wait();
                        }
                        SUM+=3;
                        Thread.sleep(100);
                        BreadOperator.class.notifyAll();
                        System.out.println(Thread.currentThread().isInterrupted()+",生产了，库存为："+SUM);

                    }
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //默认消费者
    private static class comsumer implements Runnable{
        @Override
        public void run() {
            try {
                while(true){
                    synchronized (BreadOperator.class){
                        while (SUM == 0){
                            BreadOperator.class.wait();
                        }
                        SUM--;
                        //notify/notifyAll，notify随机唤醒一个
                        //在synchronized代码块结束之后，也就是释放对象锁之后，才可以唤醒
                        //等于说，synchronized结束之后，wait和synchronized阻塞的都可以唤醒
                        Thread.sleep(100);

                        BreadOperator.class.notifyAll();
                        System.out.println(Thread.currentThread().isInterrupted()+",消费了，库存为："+SUM);
                    }
                    Thread.sleep(100);

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}






































