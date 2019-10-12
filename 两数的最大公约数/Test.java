public class Test{
    //辗转相除法
    public static void main(String[] args) {
        int a=15,b=3;
        while(a%b!=0){
            a=b;
            b=a%b;
        }
        System.out.println(b);
    }
}