import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @ClassName TestDemo
 * @Description TODO
 * @Author DELL
 * @Data 2019/12/2 20:39
 * @Version 1.0
 **/
/**
 * 1、自定义异常的时候 需要自己定义一个类实现
 * 2、在抛出异常的时候 需要自己进行throw
 * 3、编译时期--->受查异常
 * 继承自 Exception 的异常默认是受查异常
 * 继承自 RuntimeException 的异常默认是非受查异常
 */
class MyException extends Exception{
    public MyException(String message) {
        super(message);
    }
}
class Person implements Cloneable{
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
public class TestDemo {

    public static void main(String[] args) {
        Person person1=new Person();
        try{
            Person person2=(Person) person1.clone();
            System.out.println("hello");
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
 public static void funcException()throws MyException{
     int a=10;
     if (a==10){
         throw new MyException("a==10");
     }
 }
 //自定义异常
    public static void main5(String[] args) {
        try{
            funcException();
        } catch (MyException e) {
            e.printStackTrace();
        }
    }
//在方法中处理异常
public static String readFile(){
    //尝试打开文件，并且读取其中一行
    File file=new File("d:/log.txt");
    try{
        //使用文件对象构造Scanner对象
        Scanner sc=new Scanner(file);
        return sc.nextLine();
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
    return null;
}
    public static void main4(String[] args) {
        System.out.println(readFile());
    }
    //异常说明
    public static int div(int a,int b) throws ArithmeticException{
        if (b==0){
            throw new ArithmeticException("算数异常！");
        }
        return a/b;
    }

    public static void main3(String[] args) {
        try{
            int ret=div(10,0);
            System.out.println(ret);
        }catch (ArithmeticException e){
            e.printStackTrace();
            System.out.println("算数异常！");
        }finally {

        }
    }


    public static int func(){
        try{
            int a=10/0;
            return 88;
        }catch (ArithmeticException e){
            e.printStackTrace();
            System.out.println("算数异常！");
            return 99;
        }finally {
            //建议return 不要放在finally中
            //因为会抑制catch和try当中的返回值
            System.out.println("finally");

        }
    }
    public static void main2(String[] args) {
        try{
            int ret=func();
        }catch (ArithmeticException e){
            e.printStackTrace();
            System.out.println("算数异常！");
        }
//        System.out.println(func());
    }

    public static void main1(String[] args) {
        int[] array={1,23,4,55};
        //alt+int
        try (Scanner scanner = new Scanner(System.in)) {
           // int num = scanner.nextInt();
            System.out.println(array[20]);
            System.out.println("hello");
            System.out.println(array.length);//有可能出现异常的语句
        } catch (NullPointerException | ArrayIndexOutOfBoundsException e) {     //即将捕获的异常
            e.printStackTrace(); // 打印出现异常的调用栈
            System.out.println("异常捕获");
        } finally {
            //资源的关闭  文件打开 文件关闭

            //System.out.println("finaly永远会被执行！");
        }
        System.out.println("after");

    }
}
