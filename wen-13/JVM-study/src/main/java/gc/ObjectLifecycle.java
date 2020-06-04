package gc;

/**
 * @ClassName ObjectLifecycle
 * @Description TODO
 * @Author DELL
 * @Data 2020/5/28 16:28
 * @Version 1.0
 **/
class person{
    /**
     * 静态变量和静态代码块---》合并为类构造方法（字节码<client>）--->执行一次
     *
     */
    /**
     * 1、OK变量（方法区，元空间）
     * 2、常量池OK字符串对象
     * 3、OK变量引用产生：指向OK字符串对象
     */
    public static String OK="ok";
    /**
     * 1、创建类变量（方法区/元空间）
     * 2、new person()在堆里面
     * 3、产生引用：p指向person对象
     */
    public static person p = new person();
}
public class ObjectLifecycle {
    public static void test1(){
        /**
         * 1、创建局部变量，存在于方法栈帧里面
         * 2、new person()在堆里面
         * 3、产生引用：p指向person对象
         *4、类加载产生类变量和相关对象
         */
        person p = new person();
    }//销毁main线程该次调用方法栈帧---》p没有了---》person对象没有应用指向（gc roots不可达）

    public static void main(String[] args) {
        test1();//创建main线程对test1()该次调用方法的栈帧
        //person类相关的变量始终还是指向对象

        //要明确把person类中的person对象回收，要将该对象的引用清除（person p）
        //person p  = null/其他对象
    }
}
