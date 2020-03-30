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
         return b == 0 ? a : gcd(b , a % b);
    }
    //最小公倍数
    public static int lcm(int a,int b){

    }
    //最小公倍数


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> l = new ArrayList<>();
        for(int i = 0; i < 4; i ++ ){
            l.add(sc.nextInt());
        }
    }
}
