package com.src.demo1;

/**
 * @ClassName Dog
 * @Description TODO
 * @Author DELL
 * @Data 2019/11/13 17:21
 * @Version 1.0
 **/
public class Dog extends Animal{

    private String sex;

    public Dog(String name, int age, String sex) {
        super(name, age);
        this.sex = sex;
        System.out.println("Dog(String,int,String)");

    }
    public void bark(){
        System.out.println(this.name+"wangwang");

    }
}
