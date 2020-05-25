/**
 * @ClassName Student
 * @Description TODO
 * @Author DELL
 * @Data 2020/5/21 16:05
 * @Version 1.0
 **/
public class Student {
    private String name;
    private int gender;
    private int age;

    public Student(){

    }
    private Student(String name) {
        this.name = name;
    }

    public Student(String name, int gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student["+name+","+gender+","+age+"]";
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age){
        this.age = age;
    }

}
