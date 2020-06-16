package model;

/**
 * @ClassName Person
 * @Description TODO
 * @Author DELL
 * @Data 2020/6/7 11:42
 * @Version 1.0
 **/
public class Person {
    private Duck duck;

    @Override
    public String toString() {
        return "Person{" +
                "duck=" + duck +
                '}';
    }

    public Duck getDuck() {
        return duck;
    }

    public void setDuck(Duck duck) {
        this.duck = duck;
    }
}

