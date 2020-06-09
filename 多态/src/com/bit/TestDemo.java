package com.bit;

/**
 * @ClassName TestDemo
 * @Description TODO
 * @Author DELL
 * @Data 2019/12/4 17:32
 * @Version 1.0
 **/
//类的调用者不需要关注类的实现者
public class TestDemo {
    public static void draw(Shape shape){
        shape.draw();
    }
    public static void main(String[] args) {
        Rect rect=new Rect();
        Cycle cycle=new Cycle();
        draw(rect);
        draw(cycle);
    }
}
