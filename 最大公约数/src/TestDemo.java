import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestDemo {
    //辗转相除法，求取最大公约数
    public static int gcd1(int a,int b){
        int temp;
        if(a<b)
        {
            temp=a;
            a=b;
            b=temp;
        }
        while(b!=0)
        {
            temp=a%b;
            a=b;
            b=temp;
        }
        return a;
    }

    //穷举法
    static int gcd2 (int a,int b) /*自定义函数求两数的最大公约数*/
    {
        int  temp;          /*定义义整型变量*/
        temp=(a>b)?b:a;    /*采种条件运算表达式求出两个数中的最小值*/
        while(temp>0)
        {
            if (a%temp==0&&b%temp==0) /*只要找到一个数能同时被a,b所整除，则中止循环*/
                break;
            temp--;      /*如不满足if条件则变量自减，直到能被a,b所整除*/
        }
        return temp; /*返回满足条件的数到主调函数处*/
    }


    //更相减损法
    static int gcd3(int m,int n)
    {
        int i=0,temp;
        int x = 0;
        while(m%2==0 && n%2==0)  //判断m和n能被多少个2整除
        {
            m/=2;
            n/=2;
            i+=1;
        }
        if(m<n)     //m保存大的值
        {
            temp=m;
            m=n;
            n=temp;
        }
        while( x != n)
        {
            x=m-n;//代表相减的结果
            m=(n>x)?n:x;
            n=(n<x)?n:x;
            if(n==(m-n))
                break;
        }
        if(i==0)
            return n;
        else
            return (int)Math.pow(2,i)*n;
    }


    //Stein算法
    public static int gcd4(int a,int b){
        if(a == 0) return b;
        if(b == 0) return a;
            //都为偶数
        if(a % 2 == 0 && b % 2 == 0){
            return 2 * gcd4(a>>1,b>>1);
        }else if(a % 2 != 0 && b % 2 != 0){
            return gcd4((a+b)>>1,(a - b) >>1);
        }else if(a % 2 == 0 && b % 2 != 0){
            return gcd4(a>>1,b);
        }else {
            return gcd4(a,b>>1);
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        long startTime1=System.nanoTime();   //获取开始时间
        System.out.println(gcd1(a,b));
        long endTime1=System.nanoTime(); //获取结束时间
        System.out.println("程序运行时间： "+(endTime1-startTime1)+"ns");

        long startTime2=System.nanoTime();   //获取开始时间
        System.out.println(gcd2(a,b));
        long endTime2=System.nanoTime(); //获取结束时间
        System.out.println("程序运行时间： "+(endTime2-startTime2)+"ns");

        long startTime3=System.nanoTime();   //获取开始时间
        System.out.println(gcd3(a,b));
        long endTime3=System.nanoTime(); //获取结束时间
        System.out.println("程序运行时间： "+(endTime3-startTime3)+"ns");

        long startTime4=System.nanoTime();   //获取开始时间
        System.out.println(gcd4(a,b));
        long endTime4=System.nanoTime(); //获取结束时间
        System.out.println("程序运行时间： "+(endTime4-startTime4)+"ns");

    }



/**
 * @ClassName TestDemo
 * @Description ：求N个数的最大公约数，最小公倍数
 * @Author nan_xi
 * @Data 2020/3/30 19:51
 * @Version 1.0
 **/


//    //最大公约数
//    public static int gcd(int a,int b){
//        int temp;
//        if(a<b)
//        {
//            temp=a;
//            a=b;
//            b=temp;
//        }
//        while(b!=0)
//        {
//            temp=a%b;
//            a=b;
//            b=temp;
//        }
//        return a;
//    }
//
//    //最小公倍数
//    public static int lcm(int a,int b){
//        int ret = gcd(a,b);//得到最大公约数
//        return a*b/ret;
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        List<Integer> l = new ArrayList<>();
//        int sum = 0;
//        System.out.print("请输入组数：");
//        int num = sc.nextInt();
//        while(num > 0) {
//            System.out.print("请输入数据：");
//            for (int i = 0; i < 4; i++) {
//                l.add(sc.nextInt());
//            }
//            if(l.get(0)%l.get(1) != 0||l.get(3)%l.get(2)!=0){
//                System.out.println("请重新输入");
//                l.clear();
//                continue;
//            }
//            for (int i = l.get(1); i <= l.get(3); i++) {
//                if (gcd(i, l.get(0)) == l.get(1) && lcm(i, l.get(2)) == l.get(3)) {
//                    sum++;
//                }
//            }
//            System.out.println(sum);
//            num--;
//
//        }
//
//    }

}
