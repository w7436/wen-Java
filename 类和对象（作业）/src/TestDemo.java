/**
 * @ClassName TestDemo
 * @Description TODO
 * @Author 文心
 * @Data 2019/10/23 23:04
 * @Version 1.0
 **/
//class Calculator{
//    private int num1;
//    private int num2;
//    Calculator(int num1,int num2){
//        this.num1=num1;
//        this.num2=num2;
//    }
//    public int add(){
//        return num1+num2;
//    }
//    public int sub(){
//        return num1-num2;
//    }
//    public int mul(){
//        return num1*num2;
//    }
//    public int div(){
//        return num1/num2;
//    }
//}
//
//public class TestDemo {
//    public static void main(String[] args) {
//        Calculator cal=new Calculator(2,1);
//        System.out.println("和为："+cal.add());
//        System.out.println("减为："+cal.sub());
//        System.out.println("积为："+cal.mul());
//        System.out.println("除为："+cal.div());
//    }
//}

class Teacher{
    private String name;
    private int age;
    Teacher (){
        System.out.println("teacher");
    }
    Teacher(String name){
        this.name=name;
        System.out.println("name");
    }
    Teacher(String name,int age){
        this.name=name;
        this.age=age;
        System.out.println("name,age");
    }
    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
public class TestDemo {
    public static void main(String[] args) {
        Teacher teacher=new Teacher();
        System.out.println(teacher);
        Teacher teacher1=new Teacher("小绿");
        System.out.println(teacher1);
        Teacher teacher2=new Teacher("小绿",18);
        System.out.println(teacher2);
    }
}

//public class TestDemo{
//    public static void change(int []arr){
//        int tmp=arr[0];
//        arr[0]=arr[1];
//        arr[1]=tmp;
//    }
//    //数组打印
//    public static void print(int[] a) {
//        for (int i : a) {
//            System.out.print(i + " ");
//        }
//        System.out.println();
//    }
//    public static void main(String[] args) {
//        int []arr={1,2};
//        change(arr);
//        print(arr);
//    }
//}

