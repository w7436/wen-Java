import java.util.Scanner;

/**
 * @ClassName EverdayTestDemo
 * @Description TODO
 * @Author DELL
 * @Data 2020/4/2 12:08
 * @Version 1.0
 **/
//class Test {
//    public static void hello() {
//        System.out.println("hello");
//    }
//}
//public class EverdayTestDemo {
//    public static void main(String[] args) {
//        /**
//         * 可以编译通过，并且正常运行
//         * 静态方法不依赖于类对象，静态的变量，在类编译的时候就应经被创建好了，
//         * 因此可以直接调用
//         */
//        Test test = null;
//        test.hello();
//    }
//}


//public class EverdayTestDemo{
//
//    public  int aMethod() {
//        static int i = 0;//static不能修饰局部变量
//        i++;
//        return i;
//    }
//    public static void main(String[] args) {
//        EverdayTestDemo test = new EverdayTestDemo();
//        test.aMethod();
//        int j = test.aMethod();
//        System.out.println(j);
//    }
//}


//    String str=new String("hello");
//
//    char[]ch={'a' ,'b'};
//
//    public static void main(String[] args) {
//        EverdayTestDemo ex = new EverdayTestDemo();
//        ex.change(ex.str, ex.ch);
//        System.out.print(ex.str + " and ");
//        System.out.print(ex.ch);
//    }
//    public void change(String str,char ch[]) {
//        str = "test ok";
//        ch[0] = 'c';
//    }

//    private static void test(){
//        System.out.println("nihao");
//    }
//
//    public static void main(String[] args) {
//        ((EverdayTestDemo)null).test();
//    }
//    static boolean out(char c){
//        System.out.println(c);
//        return  true;
//    }
//    public static void main(String[] args) {
//        int i = 0;
//        for (out('A'); out('B') && i <2 ;out('C')) {
//            i++;
//            out('D');
//        }


//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int m = sc.nextInt();
//        int avg = m * m;//几位加数的平均数
//        StringBuilder s = new StringBuilder();
//        int left = avg + 1 - m;
//        int right = avg - 1 + m;
//        for (; left <= right; left += 2) {
//            if (left == right) {
//                s.append(left);
//                break;
//            }
//            s.append(left + "+");
//        }
//        System.out.println(s.toString());





//        byte b1=1,b2=2,b3,b6;
//        final byte b4=4,b5=5;
//        b6 = b4+b5;
//        b3 = (byte) (b1+b2);



//        Object o = new Object(){
//            @Override
//            public boolean equals(Object obj) {
//                return true;
//            }
//        };
//        System.out.println(o.equals("feewa"));



//        StringBuffer a = new StringBuffer("A");
//        StringBuffer b = new StringBuffer("B");
//        oper(a,b);
//        System.out.println(a+""+b);



//        int p[] = new int[10];
//        System.out.println(p[10]);




//    private static void oper(StringBuffer a, StringBuffer b) {
//        a.append(b);
//        b=a;
//    }
public class EverdayTestDemo {
    public static void main(String[] args) {
        int i = 5;
        int s = (i++)+(++i)+(i--)+(--i);
        System.out.println(s);

    }
}




