package model;

/**
 * @ClassName duck
 * @Description TODO
 * @Author DELL
 * @Data 2020/6/7 10:54
 * @Version 1.0
 **/
public class Duck {
    private String name;
    private Integer age;


    public Duck(){

    }
    public Duck(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Duck{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
