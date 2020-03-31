package Thread7;

/**
 * @ClassName SequencePrint
 * @Description TODO
 * @Author DELL
 * @Data 2020/3/29 11:29
 * @Version 1.0
 **/
public class SequencePrint {


    public static void print(String[] arr,int count){
        Print.index = 0;
        for (int i = 0; i < arr.length; i++) {
            final int k =i;
          new Thread(new Print(arr,count,k)).start();
        }
    }

    private static class Print implements Runnable{
        private static volatile int index = 0;

        private int count;
        private String[]arr;
        private int k;


        public Print(String[]arr,int count,int k) {
            this.count = count;
            this.arr = arr;
            this.k = k;
        }
        @Override
        public void run() {
            for (int j = 0; j < count ; j++) {
                synchronized (SequencePrint.class){
                    while (index % arr.length != k){
                        try {
                            SequencePrint.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    index++;
                    System.out.print(arr[k]);
                    if (k == arr.length-1){
                        System.out.println(j);
                    }
                    SequencePrint.class.notifyAll();
                }
            }
        }
    }
    public static void main(String[] args) {
        print(new String[]{"A","B","C"},10);
        while (Thread.activeCount()>1)
            Thread.yield();
        print(new String[]{"D","E","F"},10);



    }
}
