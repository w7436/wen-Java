package com.src.demo1;

/**
 * @ClassName Animal
 * @Description TODO
 * @Author DELL
 * @Data 2019/11/13 17:09
 * @Version 1.0
 **/
public class Animal {

    protected String name;
    private int age;
    public int a;
    
    static {
        System.out.println("Animal::static{}");
    }
    {
        System.out.println("Animal::instance");
    }
//alt+insert
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("Animal(String,int)");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public void eat(){
        System.out.println(this.name+" eat()");
    }
    public void sleep(){
        System.out.println("sleep()");
    }
}
