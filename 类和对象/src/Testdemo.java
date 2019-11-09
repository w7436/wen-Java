/**
 * @ClassName Testdemo
 * @Description TODO
 * @Author DELL
 * @Data 2019/10/22 19:03
 * @Version 1.0
 */

/**
 * 类和对象
 * OOP语言的三大特征（面向对象编程）？？继承 封装 多态
 */
// class Person{
//    public String name;//属性 成员变量 实例成员变量
//    public int age;
//    //static 静态成员变量 在方法区
//    public static int count=0;
//    public static final int SIZE=20;
//    //final修饰之后 放在哪个内存区域不一定
//    public final int size=20;//属于对象，在堆里
//
//    //行为 方法 成员方法 实例成员方法
//    public void fun1(){//非静态的方法可以访问
//        System.out.println("count:"+count);
//    }
//    public static void fun2(Person per){
//        //System.out.println("name:"+name);//静态方法内部不可以访问非静态属性，属性依赖于对象
//        System.out.println("name:"+per.name);
//        count=99;
//        System.out.println("count:"+count);
//    }
//    public void eat(){
//        int b=0;//在栈上（局部变量）
//        System.out.println(name+"吃饭");
//    }
//    public void sleep(){
//        System.out.println(name+"睡觉");
//    }
//    public void show(){
//        System.out.println("name:"+name+"age:"+age);
//    }
//}
class Person{
    private String name;
    private int age;
    public Person(){
        this("小绿");//必须放在第一行
    }
    public Person(String name){
       this.name=name;
    }
    public Person (String name,int age){
        this.age=age;
        this.name=name;
    }
    public void eat(){
       int b=0;//在栈上（局部变量）
   }
    public void show() {
        System.out.println(name+" "+age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}
public class Testdemo {
    public static void main(String[] args) {

    }


//    public static void main(String[] args) {
//        Person person=new Person();
//        person.fun1();
//
//    }
//     //空指针异常
//    public static void main5(String[] args) {
//        Person person=new Person();
//        //空指针异常
//        System.out.println(person.name.length());//(null.length())
//
//    }
//    //静态成员变量的使用
//    public static void main4(String[] args) {
//        Person person1=new Person();
//        person1.count++;
//        System.out.println(person1.count);//1
//
//        Person person2=new Person();
//        person2.count++;
//        System.out.println(person1.count);//2
//
//
//
//    }
//     //成员变量如果没有赋值，就是自己的零值
//    public static void main3(String[] args) {
//        Person person=new Person();
//        System.out.println(person.name);
//        System.out.println(person.age);
//
//    }
//    public static void main2(String[] args) {
//        Person person=new Person();
//        //静态属性的访问，通过类名去访问
//        System.out.println(person.count);
//        System.out.println(Person.count);
//
//    }
//    public static void main1(String[] args) {
//        //实例化一个对象 new
//        Person person=new Person();
//        person.name="小绿";
//        person.age=18;
//        person.eat();
//
//        Person person1=new Person();
//        person1.name="小蓝";
//        person1.age=19;
//        person1.eat();
//
//        Person person2=new Person();
//        person2.name="小黄";
//        person2.age=20;
//        person2.eat();
//
//
//
//
//
//
//
//
//    }
}
