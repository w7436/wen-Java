import java.util.Random;
import java.util.Scanner;
import java.util.Random;
public class Test{
    //猜数字
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        Random random=new Random();//产生随机值

        int randNum=random.nextInt(100)+1;//[0,100)+=[0,101)
        int num=0;
        while (true) {
            System.out.print("请输入你猜的数：");
            num=sc.nextInt();
            if (num==randNum) {
                System.out.println("正确");
                break;
            }
            if (num<randNum) {
                System.out.println("小了");
            }
            if (num>randNum) {
                System.out.println("大了");

            }

        }
    }

}


