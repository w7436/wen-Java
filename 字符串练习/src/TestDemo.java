
import java.util.Scanner;

/**
 * @ClassName TestDemo
 * @Description TODO
 * @Author DELL
 * @Data 2019/12/6 9:19
 * @Version 1.0
 **/

//输入abcdabcd输出“abcd”
public class TestDemo {
    public static void main(String[] args) {
        String str=new String("Abc");
        str=str.toLowerCase();
        System.out.println(str);
    }
    public static void main1(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        char[] arr=str.toCharArray();
        //新创建的数组
      String str3="";
      int k=0;
        //将不重复的字符放在一个数组中，
    for (int i = 0,j=0; i <arr.length ; i++,j++) {
        for ( k = i+1; k <arr.length ; k++) {
            if (arr[i]==arr[k]){
               break;
            }
        }
        if (k==arr.length){
           str3=str3+arr[i];
        }
    }
    System.out.println(str3);
}
//        String str1="abcdfr";
//        char[] arr={'1','2','3','4','5','6'};
//        String str2=new String(arr);
////        String str3=new String(arr,1,3);
//    System.out.println(str2);
////        System.out.println(str3);
////        System.out.println(str2.charAt(0));
//        char[] arr2=str2.toCharArray();
//        System.out.println(Arrays.toString(arr2));
//
//
//
//
////        char[] array={'1','2','3','4'};
////        String str=new String(array);
////       //String和StringBuffer类不能直接转换。如果要想互相转换
////
////        StringBuffer str2=new StringBuffer(str);//使用构造方法
//////        StringBuffer str3=new StringBuffer();//使用append方法
////////        str3.append(str);
////        str2=str2.reverse();
////        //将StringBuffer转变为String
////        String str3=str2.toString();
////        //将字符串转变为字符数组
////        char[] array1=str3.toCharArray();
////        System.out.println(Arrays.toString(array1));
//
//
//    }
}