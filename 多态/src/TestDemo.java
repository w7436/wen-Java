/**
 * @ClassName TestDemo
 * @Description TODO
 * @Author DELL
 * @Data 2019/11/13 18:52
 * @Version 1.0
 **/
public class TestDemo {
    //构造方法可以发生运行时绑定
    public static void main5(String[] args) {
        Cat cat =new Cat();
        cat.eat();
        //打印两次Cat::eat()
    }

    //向下转型
    public static void main(String[] args) {
        Animal animal=new Bird();
        animal.eat();
        Bird bird = (Bird) animal;
        bird.fly();
//        if (animal instanceof Cat){
//            Cat cat=(Cat) animal;
//            cat.jump();
//        }


//        Bird bird=(Bird )animal;
//        bird.fly();
//

    }
    public static Cat func2(){
        Cat cat=new Cat();
        return cat;
    }
    public static void main4(String[] args) {
        Animal animal=func2();
    }

    public static void func (Animal animal){
        animal.eat();
    }
    public static void main3(String[] args) {
        Cat cat=new Cat();
        func(cat);
    }

    public static void main2(String[] args) {
        //向上转型:父类引用子类的对象
        Animal animal=new Cat();
        //animal.jump();//，父类只能调用父类自己的方法不可以调用子类特有的方法
        animal.eat();

    }
    public static void main1(String[] args) {
        Cat cat=new Cat("huha",12,"male");
        cat.jump();
        cat.eat();

    }

}
