import java.util.Scanner;

/**
 * @ClassName Test
 * @Description TODO
 * @Author DELL
 * @Data 2019/10/15 19:01
 * @Version 1.0
 **/
public class Test {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("输入数字：");
        int a=sc.nextInt();
        int i=0;
        System.out.print("奇数位：");
        for(i=7;i>=1;i-=2){
            int c=(a>>i)&1;
            System.out.print(c);
        }
        System.out.print("偶数位：");
        for(i=8;i>=1;i-=2){
            int d=(a>>i)&1;
            System.out.print(d);
        }
    }
}
