import java.util.Scanner;

/**
 * @ClassName Test
 * @Description
 * @Author wenxin
 * @Data 2019/10/15 19:32
 * @Version 1.0
 **/
public class Test {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入数字：");
        int num=sc.nextInt();
        while(num!=0){
            System.out.println((num%10));
            num/=10;
        }
    }
}
