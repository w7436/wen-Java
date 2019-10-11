public class Test{
    public static void main(String[] args) {
        int num=10;
        int i=2;
        int flg=0;
        while (i<=java.lang.Math.sqrt(num)) {
            flg=0; 
            if(num%i==0){
               flg=1;
            }
            i++;
           
        }
        if(flg==0){
            System.out.println("为素数");
        }else{
            System.out.println("不为素数");
        }
    }

}