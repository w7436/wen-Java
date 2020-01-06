
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @ClassName TestDemo
 * @Description TODO
 * @Author DELL
 * @Data 2020/1/3 15:43
 * @Version 1.0
 **/


/*
* 泛型
* 泛型类+方法
* 模拟实现ArrayList:Object+用户进行类型转换
* 好处：不需要用户自己进行显式类型转换
*
* */
public class TestDemo {

    public static void main(String[] args) {
        Collection<String> c=new ArrayList<String>();

        c.add("C语言");
        c.add("Java SE");
        c.add("数据结构");
        System.out.println(c);
        System.out.println(c.size());
        System.out.println(c.isEmpty());
        c.remove("数据结构");
        System.out.println(c.size());

        List<String> L1=new ArrayList<String>();
        ArrayList<String> a=new ArrayList<String >();



    }
}
