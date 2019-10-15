import java.util.Scanner;

/**
 * @ClassName Test
 * @Description TODO
 * @Author DELL
 * @Data 2019/10/15 17:59
 * @Version 1.0
 **/
public class Test {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入数字：");
        int a=sc.nextInt();
        int i=0;
        int count=0;
        for (i=0;i<32;i++){
            if (((a>>i)&1)==1){
                count++;
            }
        }
        System.out.println(count);

    }
}
