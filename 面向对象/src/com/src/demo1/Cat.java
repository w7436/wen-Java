package com.src.demo1;

/**
 * @ClassName Cat
 * @Description TODO
 * @Author DELL
 * @Data 2019/11/13 17:17
 * @Version 1.0
 **/
//子类/派生类 继承 父类/基类/超类


/*
子类继承父类的除构造方法外的所有的东西，帮助父类进行构造
super() 表示调用父类的构造方法，只能放在第一行
super.数据成员
super.成员方法

 */
public class Cat extends Animal{

    private String sex;

    public Cat(String name, int age, String sex) {
        super(name, age);//只能放在第一行
        this.sex = sex;
        System.out.println("Cat(String,int,String)");

    }
//    public void eat(){
//        System.out.println(this.getName()+"eat()");
//    }
    public void func(){
        super.sleep();
        int a=super.a;
    }





}
