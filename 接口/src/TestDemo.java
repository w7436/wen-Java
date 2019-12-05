/**
 * @ClassName TestDemo
 * @Description TODO
 * @Author DELL
 * @Data 2019/11/16 9:23
 * @Version 1.0
 **/
/*
接口与类之间的关系--->实现，只要普通类实现这个接口，那么接口当中的方法必须重写
 */

class Rect implements IShape {
    @Override
    public void draw() {
        System.out.println("画矩形");
    }


}
class  Cycle implements IShape{
    @Override
    public void draw() {
        System.out.println("画圆");
    }
}
public class TestDemo {

    public static void drawMap(IShape shape){
        shape.draw();
    }
    public static void main(String[] args) {
        //接口也可以向上转型
        IShape iShape=new Rect();
        IShape iShape1=new Cycle();
        drawMap(iShape);
        drawMap(iShape1);
    }


}
