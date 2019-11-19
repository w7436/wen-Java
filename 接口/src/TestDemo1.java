import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * @ClassName TestDemo1
 * @Description TODO
 * @Author DELL
 * @Data 2019/11/17 9:27
 * @Version 1.0
 **/
interface IFlying{
    void fly();
}
interface IRunning{
    void run();
}
interface ISwimming{
    void swim();
}
class Animal {
    public String name;

    public Animal(String name) {
        this.name = name;
    }
}
class Cat extends Animal implements IRunning{
    public Cat(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(this.name+"run()");
    }
}
class Bird extends Animal implements IFlying,IRunning{
    public Bird(String name) {
        super(name);
    }

    @Override
    public void fly() {
        System.out.println(this.name+"fly");
    }

    @Override
    public void run() {
        System.out.println(this.name+"run");
    }
}
public class TestDemo1 {
    public static void walk(IRunning running){
        System.out.println("散步");
        running.run();
    }
    public static void main(String[] args) {
        Cat cat=new Cat("小明");
        walk(cat);
    }
}
