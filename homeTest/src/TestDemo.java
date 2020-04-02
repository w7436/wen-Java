import java.util.Scanner;

/**
 * @ClassName TestDemo
 * @Description TODO
 * @Author DELL
 * @Data 2020/2/7 12:18
 * @Version 1.0
 **/

//public class TestDemo {
//    //返回相同位置上相同的数字的个数
//   public static int cmp(int x, int y){
//        int res = 0;
//        for(int i = 0;i < 4; i++){
//            if( x % 10 == y % 10)  res++;
//            x /= 10;
//            y /= 10;
//        }
//        return res;
//    }
//    //返回两个数相同的数字的个数
//   public static int  cmp1(int x, int y){
//        int num=0;
//        int[] a=new int[4];
//        int[] b=new int[4];
//        for (int i = 0; i < 4 ; i++) {
//            a[i] = x % 10;
//            x /= 10;
//        }
//        for (int j = 0; j < 4 ; j++) {
//            b[j] = y % 10;
//            y /= 10;
//        }
//        for (int i = 0; i < 4; i++) {
//            for (int j = 0; j < 4 ; j++) {
//                if(a[i] == b[j]){
//                    b[j] = -1;
//                    num++;
//                    break;
//                }
//            }
//        }
//        return num;
//   }
//
//   public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] book = new int[10000];
//        while (n > 0){
//            for (int i = 0; i < n ; i++) {
//                Scanner sc1 = new Scanner(System.in);
//                int num = sc1.nextInt();
//                int p = sc1.nextInt();//猜对了几个数字
//                int q = sc1.nextInt();//几个数字在正确的位置上
//                for (int j = 1000; j < 10000 ; j++) {
//
//                    if (cmp(j ,num) != q ) book[j]=1;
//                    if (cmp1(j,num) != p) book[j]=1;
//                }
//            }
//
//            int a=0,res=0;
//            for (int i = 1000; i < 10000 ; i++) {
//                if(book[i] != 1){
//                    a++;
//                    res = i;
//                }
//                if (a >= 2){
//                    break;
//                }
//            }
//            if (a != 1){
//                System.out.println("Not sure");
//            }
//            else{
//                System.out.println(res);
//            }
//        }
//   }
//}

////    static int f(int n) {
////        //1 1 1 2 3 4 6 9 13  19 28  41 60  就是这样  多理解找规律。
////
////        if (n <= 4) {        //当年份小于4时，即 1、2、3年，牛都是一头
////            return n;
////        } else {
////           return f(n - 1) + f(n - 3);
////        }
////    }
//
//    public static void main(String[] args) {
//
//        int count = 5;
//        for (int i = 0;i < count; i++){
//            count ++;
//        }
//    }
//}

//class Teacher{
////    private  static int count = 0;
////
////    public Teacher() {
////        count++;
////    }
////    public  int getCount() {
////        return count;
////    }
////}
////public class TestDemo {
////    public static void main(String[] args) {
////        Teacher t1 = new Teacher();
////        Teacher t2 = new Teacher();
////        System.out.println(t2.getCount());
////    }
////}
public class TestDemo{

    public int mid(String s ,int left,int right){
        int size = s.length();
        while(left>=0 && right < size && s.charAt(left)==s.charAt(right)){
            left--;//向左
            right++;//向右进行扩散
        }
        return right - left - 1;
    }
    public String longestPalindrome(String s) {
        if(s == null||s.length() < 1)
            return "";
        int left = 0,right = 0;
        for(int i = 0;i < s.length();i++){
            int len1 = mid(s,i,i);
            int len2 = mid(s,i,i+1);
            int len = Math.max(len1,len2);
            if(len > right - left){
                left = i - (len - 1)/2;
                right = i + len/2;
            }
        }
        return s.substring(left,right+1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str =  sc.nextLine();

    }



    /**
     * 统计回文数的个数
     */
//    public static boolean isHuiwen(String s){
//        int i = 0;
//        int j = s.length()-1;
//        while(i<j){
//            if(s.charAt(i)!=s.charAt(j)){
//                return false;
//            }
//            i++;
//            j--;
//        }
//        return true;
//    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String str1 = sc.nextLine();
//        String str2 = sc.nextLine();
//        int count = 0;
//        for(int i = 0; i <= str1.length();i++){
//            StringBuilder sb = new StringBuilder(str1);
//            sb.insert(i, str2);
//            if(isHuiwen(sb.toString())){
//                count++;
//            }
//        }
//        System.out.println(count);
//    }

//    public static void main(String[] args) {

        //读入一个字符串str，输出字符串str中的连续最长的数字串

        /**
         * 设置三个变量，max(表示最大数字字符的个树),count（计数）,last（记录数字字符的位置）
         * 如果遇到数字字符，count++
         * 否则设置count为0
         */
//            Scanner scanner = new Scanner(System.in);
//            int count=0,last = 0,max = 0;
//            String str = scanner.nextLine();
//            for(int i = 0;i < str.length();i++){
//                if(str.charAt(i) >='0'&&str.charAt(i)<='9'){
//                    count++;
//                }
//                else{
//                    count =0;
//                }
//                if(max < count){
//                    max = count;
//                    last = i;
//                }
//            }
//            System.out.println(str.substring(last-max+1,last+1));


//    }
}