import java.util.*;

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
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        ArrayList<ArrayList<Integer>> l = new ArrayList<>(num);

        for (int i = 0; i < arr.length; i++) {
            ArrayList<Integer> l1 = new ArrayList<>();
            //从右边找
            if (i == 0) {
                int rm = arr[i];
                for (int j = i + 1; j < arr.length; j++) {
                    if (rm > arr[j]) {
                        l1.add(-1);
                        l1.add(j);
                        break;
                    }
                }
            } else if (i == arr.length - 1) {
                int rm = arr[i];
                for (int j = i - 1; j >= 0; j--) {
                    if (rm > arr[j]) {
                        l1.add(j);
                        l1.add(-1);
                        break;
                    }
                }
            } else {
                int rm = arr[i];
                //从左边
                for (int j = i - 1; j >= 0; j--) {
                    if (rm > arr[j]) {
                        l1.add(j);
                        break;
                    }
                }
                //从右边
                for (int j = i + 1; j < arr.length; j++) {
                    if (rm > arr[j]) {
                        l1.add(j);
                        break;
                    }
                }
            }
            l.add(l1);
        }
        for (int k = 0; k < l.size(); k++) {
            for(int m = 0;m < l.get(k).size();m++){
                System.out.print(l.get(k).get(m));
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
//    public static void main0(String[] args){
//        Scanner in = new Scanner(System.in);
//        int num = in.nextInt();
//        int sum = in.nextInt();
//        int[] arr = new int[num];
//
//        long[] dp = new long[sum+1];
//        dp[0] = 1;
//        for(int i = 0;i < num;i++){
//            arr[i] = in.nextInt();
//            for(int j = sum;j >= 0;j--){
//                if(j >= arr[i]){
//                    dp[j] += dp[j-arr[i]];
//                }
//            }
//        }
//        System.out.println(dp[sum]);
//    }
//
//    public static void main1(String[] args) {
//
//        //false
//        Integer i = new Integer(1);
//        Integer j= new Integer(1);
//        System.out.println(i==j);
//
//        //true
//        //java在编译Integer i1 = 1时，会翻译成Integer i1 = Integer.valueOf(1)
//        Integer o1 = 1;
//        Integer o2 = 1;
//        System.out.println(o1==o2);
//
//        //false（Integer类型范围值-128 ~127 ，如果超过这个区间，就会创建新的类型）
//        Integer o3 = 128;
//        Integer o4 = 128;
//        System.out.println(o3==o4);
//
//        //false
//        Integer i1= 127;
//        Integer j1= new Integer(127);
//        System.out.println(i1==j1);
//
//        //true
//        Integer i5 = 127;
//        int  j5 = 127;
//        System.out.println(i5==j5);
//
////        true
////        包装类Integer变量在与基本数据类型int变量比较时，Integer会自动拆包装为int，
////         然后进行比较，实际上就是两个int变量进行比较
//        Integer i2 = 128;
//        int j2 = 128;
//        System.out.println(i2 == j2);
//
////            Scanner in = new Scanner(System.in);
////
////                String s1 = in.nextLine();
////                String s2 = in.nextLine();
////
////                Map<Character,Integer> map= new HashMap<>();
////                for(char c :s1.toCharArray()){
////                    map.put(c,map.getOrDefault(c,0)+1);
////                }
////
////                int count = 0;//代表缺的珠子
////                for(char s:s2.toCharArray()){
////                    int len = map.getOrDefault(s,0);
////                    if(len <= 0)
////                        count++;
////                    map.put(s,len-1);
////
////                }
////                if(count == 0){
////                    System.out.println("YES"+" " +(s1.length()-s2.length()));
////                }else{
////                    System.out.println("NO" + " "+count);
////                }
//
//    }
//}
//
//
//
//
//
