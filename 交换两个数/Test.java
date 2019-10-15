public class Test{
    public static void main(String[] args) {
        // int a=1;
        // int b=2;
        // a=a^b;
        // b=a^b;
        // a=a^b;
        // System.out.println("a="+a);
        // System.out.println("b="+b);
        int a=1,b=2,c=3;
        int tmp=0;
        if (a>b) {
            tmp=a;
            a=b;
            b=tmp;
        }
        if (a>c) {
            tmp=a;
            a=c;
            c=tmp;   
        }
        if (b>c) {
            tmp=b;
            b=c;
            c=tmp; 
        }
        System.out.println("最大数："+c);
        System.out.println("最小数："+a);


    }
}