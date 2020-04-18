package lesson1;

import java.util.Scanner;

/**
 * @ClassName ScannerTest
 * @Description TODO
 * @Author DELL
 * @Data 2020/4/4 11:09
 * @Version 1.0
 **/
public class ScannerTest {



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 10 ; i++) {



            //多线程的阻塞也是满足一定的条件才返回
            //都是阻塞式方法，造成当前线程阻塞
            //满足一定的条件才返回
//            sc.hasNext...
//            hasNext()//满足换行符特殊字符，next满足换行符/空格
//            hasNextLine()满足换行符
//            hasNextInt()读取到不满足Int数值的字符返回

        //IO流中的数据，进行读/取操作只能执行一次
//            while (sc.hasNext()){//非读取数据的操作
//                System.out.println(sc.next());//读取的操作，返回恶数据不包含特殊字符
//
//            }


            int count = sc.nextInt();
            for (int j = 0; j < count ; j++) {
                int current = sc.nextInt();
            }

        }
    }
}
