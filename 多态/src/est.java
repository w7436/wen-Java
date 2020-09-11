/**
 * @ClassName est
 * @Description TODO
 * @Author DELL
 * @Data 2020/6/28 22:07
 * @Version 1.0
 **/
class A{
    private String name;
    private int id;

    public A(String name) {
        this.name = name;
    }
    public void eat(){
        System.out.println("A.name:"+this.name);
    }
}
class B extends A{


    public B(String name) {
        super(name);
    }

}
public class est{

    public static void main(String[] args) {
        B b = new B("你好");
        b.eat();

    }
}




