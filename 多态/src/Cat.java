/**
 * @ClassName Cat
 * @Description TODO
 * @Author DELL
 * @Data 2019/12/3 21:00
 * @Version 1.0
 **/
public class Cat extends Animal{
    public String sex;

    public Cat() {

    }

    public Cat(String name, int age, String sex) {
        super(name, age);//显示调用父类的构造方法
        this.sex = sex;
    }
//    public void eat(){
//        System.out.println("Cat:eat()");
//    }
    public void jump(){
        System.out.println(this.name+"跳");
    }
    public void eat(){
        System.out.println("Cat::eat()");
    }


}
