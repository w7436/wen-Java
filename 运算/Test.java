public class Test{
    public static void main(String[] args) {
        int flg=-1;
        double i=1;
        double sum=0.0;
        for(i=1;i<=100;i++){
            flg*=-1;
            sum+=(double)(flg/i);
           
        }
        System.out.printf("%.2f",sum);
    }
}