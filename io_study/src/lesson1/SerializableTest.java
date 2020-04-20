package lesson1;

import java.io.*;

/**
 * @ClassName SerializableTest
 * @Description TODO
 * @Author DELL
 * @Data 2020/4/20 15:48
 * @Version 1.0
 **/
public class SerializableTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person person = new  SerializableTest.Person();

        ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("D:\\bit\\github\\wen-Java\\io_study\\res\\person.txt"));
        oos.writeObject(person);
        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("D:\\bit\\github\\wen-Java\\io_study\\res\\person.txt"));
        Person person1 = (Person) ois.readObject();
        System.out.println(person1);
    }

    private static class Person implements Serializable{
        private String name;
        private Integer age;

    }
}

























