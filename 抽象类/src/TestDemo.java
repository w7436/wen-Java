/**
 * @ClassName TestDemo
 * @Description TODO
 * @Author DELL
 * @Data 2019/12/4 17:52
 * @Version 1.0
 **/

/**
 * 1、抽象类被继承一定重写抽象方法
 * 2、抽象类A继承了抽象类B，那么抽象类A 可以选择重写或者不重写
 * 抽象类B当中的方法
 * 3、抽象类重写了，那么继承之后就不需要重写
 *
 */
public class TestDemo {
    public static void draw(Shape2 shape2){
        shape2.draw();
    }
    public static void main(String[] args) {
        Shape2 shape2=new Rect2();
        draw(shape2);
        Cycle2 cycle2=new Cycle2();
        draw(cycle2);
        Rect2 rect2=new Rect2();
        draw(rect2);
    }
}
