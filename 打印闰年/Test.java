public class Test{
    //输出 1000 - 2000 之间所有的闰年
    public static void main(String[] args) {
        int year=1000;
        while(year<2001){
            if(year%400==0||((year%4==0)&&(year%100!=0))){
                System.out.println(year);
            }
            year++;
        }
    }
}