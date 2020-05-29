import java.util.*;

/**
 * @ClassName TestDemo
 * @Description TODO
 * @Author DELL
 * @Data 2019/12/21 18:53
 * @Version 1.0
 **/


/*
public class TestDemo {
//Map
    public static void main2(String[] args) {
        Map<String,String> m=new HashMap<>();
        m.put("apple","苹果");
        m.put("orange","橘子");
        m.put("graps","葡萄");
        System.out.println(m.size());
        System.out.println(m.get("orange"));

        String str1=m.getOrDefault("apple","苹果");
        String str2=m.getOrDefault("pear","梨");

        System.out.println(m.containsKey("pear"));
        System.out.println(m.containsKey("orange"));

        System.out.println(m.containsValue("梨"));
        System.out.println(m.containsValue("橘子"));

        for (Map.Entry<String,String> e:m.entrySet()) {
            System.out.println(e.getKey()+"----->"+e.getValue());
        }
        m.clear();
        System.out.println(m.size());


    }
    //Collection接口
    public static void main1(String[] args) {
        Collection<String> c=new ArrayList<>();
        System.out.println(c.isEmpty());
        c.add("C语言");
        c.add("Java SE");
        System.out.println(c.size());
        System.out.println(c.isEmpty());
        System.out.println(c);

        c.remove("C语言");
        System.out.println(c);

        List<String> L1=new ArrayList<>();
        ArrayList<String> L2=new ArrayList<>();
    }

}
*/



//Object类  是所有类的基类
//
//class  Book{}
//class Person{
//    public void Print(){
//        System.out.println("你好，南夕");
//    }
//}
//
//
//class MyArrayList{
//    Object[] array;
//    int capacity;//空间的总大小
//    int size;//空间存储有效元素的个数
//
//    public MyArrayList(int capacity) {
//        this.array = new Object[capacity];
//        this.capacity = capacity;
//        this.size = 0;
//    }
//    void add(Object e){
//        array[size++]=e;
//    }
//    int size(){
//        return size;
//    }
//    Object get(int index){
//        //检测index不能越界
//        return array[index];
//    }
//    boolean isEmpty(){
//        return 0==size;
//    }
//}
//
//
//public class TestDemo {
//    public static void main(String[] args) {
//        MyArrayList L1=new MyArrayList(10);
//        L1.add(new Person());
//        L1.add(new Book());
//
//
//        //向下转型:不安全
//        Person p=(Person)L1.get(0);
//        Person pp=(Person) L1.get(1);//error
//        System.out.println(p);
//        System.out.println(pp);
//
//
//
////        MyArrayList L2=new MyArrayList(10);
////        L2.add(new Book());
////        L2.add(new Book());
////        L2.add(new Book());
////
////        Book b=(Book)L2.get(0);//返回类型Object---->Book
////
////
////        pp.Print();
//    }
//}








//泛型类
class  Book{}
class Person{
    public void Print(){
        System.out.println("你好，南夕");
    }
}
class MyArrayList<E>{
    E[] array;
    int capacity;
    int size;
    public MyArrayList(int capacity){
        this.array=(E[]) new Object[capacity];
        size=0;
        this.capacity=capacity;
    }
    public void add(E e){
        array[size]=e;
    }
    public int size(){
        return size;
    }
    E get(int index){
        //检测index不能越界
        return array[index];
    }
    boolean isEmpty(){
        return 0==size;
    }
}
public class TestDemo {
    public static void main(String[] args) {
        //L1只能存储Person类型的对象
        MyArrayList<Person> L1 = new MyArrayList<>(10);
        L1.add(new Person());
        L1.add(new Person());
//        L1.add(new Book());//在编译阶段，发现类型不匹配，编译器报错
        Person p = L1.get(0);
  //       Book b = (Book)L1.get(0); // 在编译阶段，发现类型不匹配，强转也不行

        MyArrayList<Book> L2=new MyArrayList<>(10);
        L2.add(new Book());

        System.out.println(L1.getClass());//得到类的名字
        System.out.println(L1.getClass());

        //MyArrayList<int> L3=new MyArrayList<int>(10);//int为基本类型，没有对象的存在
    }
}



/*
//基本类型转换
public class TestDemo {
    public static void main(String[] args) {
        Integer i1 = 100;
        Integer i2 = 100;
        Integer i3 = 200;
        Integer i4 = 200;

        Integer i5 = Integer.valueOf(100);
        Integer i6 = Integer.valueOf(200);

        System.out.println(i1 == i2);//true   -128-127之间
        System.out.println(i3 == i4);//false
    }


    public static void main1(String[] args) {
        int i=10;
        Integer i2=Integer.valueOf(i);//装箱：将基础类型定义的变量转化为对饮的包装类型
        int i3=i2.intValue();//拆箱：将包装类对象中的数据拿出

        Integer i1=i;//自动装箱：编译器在编译阶段会使用i构造一个包装类型的对象，然后使用i1引用 Integer.valueOf(i)
        int i4=i1;//自动拆箱：将包装类型的对象直接赋值给对应的基础类型的变量
    }
}
*/

//import java.util.List;
//import java.util.ArrayList;
//public class TestDemo {
//    public static void main(String[] args) {
//        List<Integer> L1=new ArrayList<>();
//        L1.add(10);
//        L1.add(20);
//        L1.set(0,0);
//        L1.set(1,1);
//        L1.set(2,2);//代码崩溃，2号位置没有元素 越界
//        L1.set(3,3);
//
//    }
//    public static void main1(String[] args) {
//        List<Integer> L1=new ArrayList<>();//一维的动态数组
//        List<Integer> L2=new ArrayList<>();//一维的动态数组
//        List<Integer> L3=new ArrayList<>();//一维的动态数组
//
//        List<List<Integer>> L=new ArrayList<>();
//        L.add(L1);
//        L.add(L2);
//        L.add(L3);
//
//    }
//}