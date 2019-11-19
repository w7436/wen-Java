/**
 * @ClassName TestDemo4
 * @Description TODO
 * @Author DELL
 * @Data 2019/11/17 11:03
 * @Version 1.0
 **/
/**
 * Cloneable 当中没有抽象方法
 * 空接口——>标志当前类可以进行克隆
 * */
class Money implements Cloneable{
    double m=12.9;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
class Person implements Cloneable{
    public String name;
    Money money;

    public Person(){

    }
    public Person(String name) {
        this.name = name;
        this.money = new Money();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {

        Person p=(Person)super.clone();
        p.money=(Money)this.money.clone();
        return p;
       //return super.clone();
    }
}
public class TestDemo4 {
    public static void main(String[] args)throws CloneNotSupportedException {
        Person person=new Person("caocao");
        Person person1=(Person) person.clone();
        person1.money.m=99.0;
        System.out.println(person.money.m);
        System.out.println(person1.money.m);
    }
    public static void main1(String[] args)throws CloneNotSupportedException {
        Person person=new Person();
        person.name="caocao";
        System.out.println(person.name);
        System.out.println("clone");

        Person person1=(Person)person.clone();
        person1.name="liubei";
        System.out.println(person.name);
        System.out.println(person1.name);


    }
}
