
import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * @ClassName TestDemo
 * @Description TODO
 * @Author DELL
 * @Data 2019/11/27 18:45
 * @Version 1.0
 **/
public class TestDemo {
    public static boolean func(String str){
        char[] array=str.toCharArray();
        for (int i = 0; i <array.length ; i++) {
            if (array[i]<'0'||array[i]>'9'){
                return false;
            }
        }
        return true;
//        for (int i = 0; i <str.length() ; i++) {
////            if(str.charAt(i)<'0'||str.charAt(i)>'9'){
////                return false;
////            }
////        }
////        return true;
    }

    public static String func2(){
        char[] array={'a','b','c','d'};
        //也是将数组转为字符串
        //return new String(array);
        return String.copyValueOf(array);
    }
    public static void main(String[] args) {
//        String str=func2();
//        System.out.println(str);

//        char[] array={'a','b','c','d'};
//        String str3=new String(array);
//        System.out.println(str3);

//        String str4=new String (array,1,2);
//      System.out.println(str4);//bc

        String str1="123456";
        boolean flg=func(str1);
        System.out.println(flg);
        char[] array=str1.toCharArray();
        System.out.println(Arrays.toString(array));

        char ch=str1.charAt(2);
        System.out.println(ch);




    }
    //反射
    public static void main7(String[] args) throws NoSuchFieldException, IllegalAccessException {
        String str="hello";
        Class clc=String.class;
        Field field=clc.getDeclaredField("value");
        field.setAccessible(true);
        //将value属性获取到
        char[] value =(char[]) field.get(str);
        System.out.println(Arrays.toString(value));
        value[0]='H';
        System.out.println(Arrays.toString(value));
    }
    public static void main6(String[] args) {
//        String str="abcdef";
//        String str2=new String ("abcdef").intern();
//        System.out.println(str==str2);//true

//        String str=new String ("abcdef").intern();
//        String str2="abcdef";
//        System.out.println(str2==str);

//        char[] array={'a','b','c','d','e','f'};
//        String str3=new String(array).intern();//手动入池
//        String str="abcdef";
//        System.out.println(str==str3);

        String str="Hello";
        //提取一个子串：从1号下标开始提取子串
        str="h"+str.substring(1);//hello
        System.out.println(str);



    }
    public static void main5(String[] args) {
//        String str=null;
//        String str2=new String("abcdef");
//        System.out.println(str.equals(str2));//java.lang.NullPointerException
//        System.out.println(str2.equals(str));//false

        String str1="abcdef";
        String str2="abcdef";
        System.out.println(str2.compareTo(str1));//可以使用compareTo,因为String类实现了Comparable接口
    }
    public static void main4(String[] args) {
        String str="abcdef";
        String str2=str;
        str="hello";
        System.out.println(str2);//"abcdef"
    }
    public static void main3(String[] args) {
        int a=10;
        String str="abc"+"def"+360;//"abcdef360"
    }

    public static void main2(String[] args) {
        String str="abcdef";
        String str2=new String("abcdef");
        char[] array={'a','b','c','d','f'};
        String str3=new String(array);
        String str4="abc"+"def";//编译期间已经确定"abcdef"
        String str5="abc"+new String("def");
        System.out.println(str==str2);//false
        System.out.println(str==str3);//false
        System.out.println(str==str4);//true
        System.out.println(str==str5);//false
        String str6="abc";
        String str7="def";
        String str8=str6+str7;
        System.out.println(str==str8);//false

    }
    public static void main1(String[] args) {
        String str="adcdef";//直接赋值
        System.out.println(str);
        String str2=new String("adcdef");
        System.out.println(str2);
        char[] array={'a','b','c','d','f'};
        String str3=new String(array);
        System.out.println(str==str2);
        System.out.println(str==str3);
    }
}
