import java.util.Scanner;

/**
 * @ClassName Test
 * @Description TODO
 * @Author DELL
 * @Data 2019/10/15 17:31
 * @Version 1.0
 **/
public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count=0;
        String code="qaz...";
        String wri="";
        while(count++<3){
            System.out.print("请输入密码：");
            wri=sc.nextLine();
            if ( wri.equals(code)) {
                System.out.println("密码输入正确");
                break;
            }
        }
        if (count==3) {
            System.out.println("傻蛋，密码都忘了");

        }
    }
}
