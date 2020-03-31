import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName TestDemo
 * @Description ：求N个数的最大公约数，最小公倍数
 * @Author nan_xi
 * @Data 2020/3/30 19:51
 * @Version 1.0
 **/
public class TestDemo {


    //最大公约数
    public static int gcd(int a,int b){
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

    //最小公倍数
    public static int lcm(int a,int b){
        int ret = gcd(a,b);//得到最大公约数
        return a*b/ret;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> l = new ArrayList<>();
        int sum = 0;
        System.out.print("请输入组数：");
        int num = sc.nextInt();
        while(num > 0) {
            System.out.print("请输入数据：");
            for (int i = 0; i < 4; i++) {
                l.add(sc.nextInt());
            }
            if(l.get(0)%l.get(1) != 0||l.get(3)%l.get(2)!=0){
                System.out.println("请重新输入");
                l.clear();
                continue;
            }
            for (int i = l.get(1); i <= l.get(3); i++) {
                if (gcd(i, l.get(0)) == l.get(1) && lcm(i, l.get(2)) == l.get(3)) {
                    sum++;
                }
            }
            System.out.println(sum);
            num--;

        }

    }
}
