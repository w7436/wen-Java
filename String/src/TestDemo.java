
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.util.Arrays;
//javap -c TestDemo//反编译
/**
 * @ClassName TestDemo
 * @Description TODO
 * @Author DELL
 * @Data 2019/11/27 18:45
 * @Version 1.0
 **/
public class TestDemo {

    //字符串的拆分
    public static void main13(String[] args) {
        String str="abc-ac-vf";
        String[] strings=str.split("-",2);//分为两组
        String[] strings1=str.split("-");
        System.out.println(Arrays.toString(strings));

        String str2="192.322.1.1";
        String[] strings2=str2.split("\\.");//   \  (\.)正则表达式，对于* | + -
        System.out.println(Arrays.toString(strings2));

        String str3="abc=def ght=gb";
        String[] strings3=str2.split(" ");//   \  (\.)正则表达式，对于* | + -
        System.out.println(Arrays.toString(strings3));
        for (String s:strings3) {
            String[] ss=s.split("=");
            System.out.println(Arrays.toString(ss));

        }


    }
    //字符串的替换
    public static void main12(String[] args) {
        String str="ablab";
      //  str= str.replaceAll("ab","luy");
        str=str.replaceFirst("ab","he");
        System.out.println(str);
    }
    //查找
    public static void main11(String[] args) {
        String str="bcd";
        String str2="bcdefbcd";
        System.out.println(str2.contains(str));
        System.out.println(str2.indexOf(str));//从头开始查找第一个出现 //效率高//1
        System.out.println(str2.indexOf(str,3));//6
        System.out.println(str2.lastIndexOf(str));//6
        //从后面的位置开始往前找
        System.out.println(str2.lastIndexOf(str,3));//1
        System.out.println(str2.lastIndexOf(str,8));//6
        System.out.println(str2.lastIndexOf(str,0));//-1
        System.out.println(str2.startsWith("b"));//判断当前字符串是否以 开头
        System.out.println(str2.startsWith("d",2));//2代表偏移量
        System.out.println(str2.endsWith("cd"));//判断字符串是否以 结束

    }
    //字符串的比较
    public static void main10(String[] args) {
        String str="Abc";
        String str2="abc";
        System.out.println(str.equals(str2));
        System.out.println(str.equalsIgnoreCase(str2));//忽略大小写
        System.out.println(str.compareTo(str2));

    }

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
//字符与字符串
    public static void main9(String[] args) throws UnsupportedEncodingException {
        byte[] bytes={97,98,99,100};
        String str=new String(bytes,1,2);   //@Deprecated 方法过时
        System.out.println(str);//bc

        String str2="abc";
        byte[] bytes1=str2.getBytes();
        System.out.println(Arrays.toString(bytes1));//[97,98,99]

        String str3="文";
        byte[] bytes2=str3.getBytes("utf8");//编码
        System.out.println(Arrays.toString(bytes2));
    }
    public static void main8(String[] args) {
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
        field.setAccessible(true);//将这个字段的访问属性设置为true
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
        String str1="def";
        String str="abc"+"def"+str1;//两个对象
//        int a=10;
//        String str="abc"+"def"+360;//"abcdef360"//一个对象
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
    public static void main1(String[] args) {//运行时参数
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
