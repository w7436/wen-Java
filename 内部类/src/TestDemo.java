/**
 * @ClassName TestDemo
 * @Description TODO
 * @Author DELL
 * @Data 2019/12/2 21:29
 * @Version 1.0
 **/

/**
 * 内部类：
 * 实例内部类
 * 静态内部类
 * 匿名内部类
 * 本地内部类
 */
//实例内部类
class OuterClass{
    public int data1=10;
    public static int data2=20;
    private int data3=30;
    //实例内部类   实例方法   实例数据
    /**
     * 1、实例内部类不能有静态的数据方法??????
     *     静态内部类可以认为是外部类的方法，其是依赖于对象的，而静态的不依赖对象，这就出现了矛盾
     * 2、怎样拿到内部类的对象??????
     *     OuterClass outerClass=new OuterClass();
     *     OuterClass.InnerClass innerClass=outerClass.new InnerClass();
     * 通过外部类的引用
     * 3、实例内部类是否拥有外部类的对象/额外的开销
     */
    public void method(){
        //外部类可以通过内部类的对象调用内部类的成员和方法
        System.out.println(new InnerClass().data1);
        System.out.println(InnerClass.data2);
    }
    class  InnerClass{
       public int data1=100;
        /**
         * 实例内部类不能存在任何的静态方法和属性，但是变量可以被static final修饰???
         *    主要原因是final类型在编译期间jvm有优化，常量池会维护这些变量，
         *    虽然非静态的内部类不能脱离外部类的对象，
         *    但是常量池使得final使得变量脱离了类实例化这个条件，编译期间就可以确定
         */

        public static final int data2=200;
        public InnerClass() {
            System.out.println("InnerClass()");
        }

         public void func(){
            //当内部类与外部类有同名成员变量和方法时，内部类可通过Outer.this方式来引用外部类成员。
            System.out.println("data2"+data2);
            System.out.println("data1"+this.data1);//this代表的是内部类的引用
            System.out.println("data1"+OuterClass.this.data1);
            System.out.println("data3"+data3);//内部类可以直接访问外部类私有的成员属性和方法

        }
    }
}
//静态内部类

/**1、OuterClass1.InnerClass1 in=new OuterClass1.InnerClass1();
 *2、静态内部类 不可以直接访问外部类的非静态数据成员 但是可以间接访问
 *
 */
class OuterClass1{
    public int data1=10;
    public static int data2=20;
    public void method(){
        System.out.println("外部的成员方法");
    }
static class InnerClass1{
    public int data1=100;
    public static int data2=200;
    public void func(){
        System.out.println("data1:"+this.data1);
        System.out.println("data2:"+data2);
        System.out.println(new OuterClass().data1);//可以间接访问外部类的非静态数据成员
        new OuterClass1().method();
        System.out.println(OuterClass.data2);
    }
}
}

/**
 * 匿名内部类
 *
 */
class MyThread{
    public void func(){
        System.out.println("func()");
    }

}

/**
 * 匿名内部类其实就是一个没有名字的方法内部类，所以它符合方法内部类的所有约束
 * 1、匿名内部类中是不能定义构造函数的。
 *2、匿名内部类中不能存在任何的静态成员变量和静态方法。
 * 3、 匿名内部类为局部内部类，所以局部内部类的所有限制同样对匿名内部类生效。
 *4、匿名内部类不能是抽象的，它必须要实现继承的类或者实现的接口的所有抽象方法。
 */
public class TestDemo {
    //匿名内部类
    public static void main3(String[] args) {
        new MyThread(){
            @Override
            public void func() {
                System.out.println("hello");
            }
        }.func();
    }
    //静态内部类
    public static void main2(String[] args) {
        //静态内部类依赖于外部类的对象
        OuterClass1.InnerClass1 in=new OuterClass1.InnerClass1();
        in.func();//100 200 10 20
    }
    //实例内部类
    public static void main(String[] args) {
        //实例内部类是依附于外部类的，只有创建了外部类才可以创建内部类
               OuterClass o=new OuterClass();
        OuterClass.InnerClass in=o.new InnerClass();
        in.func();//200 100 10
//        OuterClass o=new OuterClass();
//        o.method();
    }
}
