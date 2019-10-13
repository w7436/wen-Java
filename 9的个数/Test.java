public class Test{
    public static void main(String[] args) {
        double i=1;
        int count=0;
        for(i=1;i<=100;i++){
            if(i%10==9){
                count++;
            }
            if (i/10==9) {
               count++; 
            }
        }
        System.out.println(count);
    }
}