package jvm;

/**
 * @ClassName ConstantPoolLook
 * @Description TODO
 * @Author DELL
 * @Data 2020/5/21 9:10
 * @Version 1.0
 **/
public class classLoaderLook {
    public static void main(String[] args) throws ClassNotFoundException {
        Child1 child1 = new Child1(200,"child2");
//       Class.forName("jvm.Child");
       int a = Child.A;
    }

}
