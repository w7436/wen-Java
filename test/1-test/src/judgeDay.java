import java.util.Scanner;

/**
 * @ClassName judgeDay
 * @Description TODO
 * @Author DELL
 * @Data 2020/5/31 18:06
 * @Version 1.0
 **/
public class judgeDay {
    public static int[] days= {31,28,31,30,31,30,31,31,30,31,30,31};
    public static int count(int year,int month,int day){
        int sum = 0;
        for(int i = 0;i < month-1;i++){
            sum+=days[i];
        }
        //闰年
        if (year % 400 ==0 || (year % 4 == 0 && year%100!=0)){
            sum +=1;
        }
        sum+=day;
        return sum;
    }
    public static void main(String[] args) {
        System.out.print("请输入年月日：");
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        int month = sc.nextInt();
        int day = sc.nextInt();
        System.out.print("天数为："+ count(year,month,day));
        System.out.println();
    }
}
