package com.bit;

import com.src.demo1.Animal;

/**
 * @ClassName Bird
 * @Description TODO
 * @Author DELL
 * @Data 2019/12/4 15:54
 * @Version 1.0
 **/

/*protect访问，可以通过子类的引用去访问数据属性
*不可以直接通过父类的引用去访问
*/
public class Bird extends Animal{

    public Bird(String name, int age) {
        super(name, age);
    }

    public static void main(String[] args) {
//        Animal animal=new Animal("hah",2);
//        animal.name;
        Bird bird=new Bird("haha",2);
        System.out.println(bird.name);
    }
}
