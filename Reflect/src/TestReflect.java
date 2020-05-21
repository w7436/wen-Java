import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @ClassName TestReflect
 * @Description TODO
 * @Author DELL
 * @Data 2020/5/21 15:59
 * @Version 1.0
 **/
public class TestReflect {
    //1、获取Student字节码文件对象（class对象）
    public static void test1() throws ClassNotFoundException{
        //每一个类里面都有包含一个class的静态属性
        Class<?> stuClass1 = Student.class;
        System.out.println(stuClass1);

        //通过对象调用getClass()
        Student s = new Student("pater",12,14);
        Class<?> stuClass2 = s.getClass();
        System.out.println(stuClass2);
        //静态方法forName()
        Class<?> stuClass3 = Class.forName("Student");
        System.out.println(stuClass3);

        //一个类最多只会被加载一次，true
        System.out.println(stuClass1 == stuClass2);

    }

    public static void test2(){
        try {
            Class<?> stuClass = Class.forName("Student");
            //获取构造器对象
            //getConstructors()：获取所有的构造器共有的
            Constructor<?>[] stuCon1 = stuClass.getConstructors();
            System.out.println(stuCon1.length);

            //获取具体某一个共有的构造器---》想要获取那个构造器，所传参数与相对应的构造器相匹配
            Constructor<?> stuCon2 = stuClass.getConstructor();
            System.out.println(stuCon2);

            Constructor<?> stuCon3 = stuClass.getConstructor(String.class,int.class,int.class);
            System.out.println(stuCon3);

            //获取：所有的构造方法
            Constructor<?>[] stuCon4 = stuClass.getDeclaredConstructors();
            System.out.println(stuCon4.length);

            Constructor<?> stuCon5 = stuClass.getDeclaredConstructor(String.class);
            System.out.println(stuCon5);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //通过构造器来实例化对象
    public static void test3() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> stuClass = Class.forName("Student");

        Constructor<?> stuCon = stuClass.getDeclaredConstructor(String.class);

        //如果构造器为私有的，则不能直接进行实例化对象
        stuCon.setAccessible(true);//将访问权限设置为public
        Student s=(Student) stuCon.newInstance("Peter");
        System.out.println(s);

    }

    //访问属性
    public static void test4(){
        try {
            Class<?> stuClass = Class.forName("Student");

            Constructor<?> stuCon = stuClass.getDeclaredConstructor(String.class);

            //如果构造器为私有的，则不能直接进行实例化对象
            stuCon.setAccessible(true);//将访问权限设置为public
            Student s=(Student) stuCon.newInstance("Peter");

            //反射属性
            Field[] fields = stuClass.getFields();//获取所有共有的属性
            System.out.println(fields.length);

//            Field name = stuClass.getField("name");
//            System.out.println(name);

            //获取所有属性
            Field[] fields1 = stuClass.getDeclaredFields();
            System.out.println(fields1.length);

            Field age = stuClass.getDeclaredField("age");
            System.out.println(age);

            //修改name属性---》修改属性的实例的属性
            age.setAccessible(true);
            age.set(s,13);
            System.out.println(s.getAge());
            System.out.println(s);


            //反射方法
            Method setAge = stuClass.getDeclaredMethod("setAge", int.class);
            setAge.invoke(s,200);
            Method getAge = stuClass.getDeclaredMethod("getAge");
            getAge.setAccessible(true);

            System.out.println(getAge.invoke(s));
            System.out.println(s);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
//        test3();
//        Student s = new Student("peter",1,30);
        test4();

    }
}



















