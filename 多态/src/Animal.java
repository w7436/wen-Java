/**
 * @ClassName Animal
 * @Description TODO
 * @Author DELL
 * @Data 2019/12/3 21:00
 * @Version 1.0
 **/
public class Animal {
    public String name;
    public int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public Animal(){
        eat();
    }

    public void eat(){
        System.out.println("Animal::eat()");
    }
    public void fun(){
        System.out.println("Animal::func");
    }
}
