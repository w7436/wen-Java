/**
 * @ClassName Testdemo
 * @Description TODO
 * @Author DELL
 * @Data 2019/10/22 19:03
 * @Version 1.0
 */
// class Person{
//    public String name;//属性 成员变量 实例成员变量
//    public int age;
//    //static 静态成员变量 在方法区
//    public static int count=0;
//    public static final int SIZE=20;
//    //final修饰之后 放在哪个内存区域不一定
//    public final int size=20;
//
//    //行为 方法 成员方法 实例成员方法
//    public void sayHello(){
//        System.out.println("小绿");
//    }
//    public void sleep(){
//        System.out.println("睡觉");
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
        //会调用不带参数的构造方法
        Person person=new Person();
//        person.setAge(10);
//        person.setName("小绿");
//        System.out.println(person.getName());
//        System.out.println(person.getAge());

        Person person1=new Person("小蓝");

        Person person2=new Person("小黄",18);

        System.out.println(person2);


    }
}
