import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName TestDemo
 * @Description TODO
 * @Author DELL
 * @Data 2020/1/3 16:01
 * @Version 1.0
 **/
/*
* ArrayList检测是否扩容？？怎么扩容？？？？
* */
public class TestDemo {
    public static void main(String[] args) {
        List<Integer> L=new LinkedList<>();
        L.add(1);
        L.add(2);
        L.add(3);
        L.add(4);
        System.out.println(L);
        System.out.println(L.size());
        System.out.println(L.indexOf(4));


        //获取任意位置的数据
        System.out.println(L.get(0));
    //    System.out.println(L.get(10));


        //任意位置的插入
        L.add(0,0);
        System.out.println(L);

        L.remove(1);

        if(L.contains(1)){
            System.out.println("remove:失败");

        }else{
            System.out.println("remove:成功");
        }
        L.add(0);
        System.out.println(L.indexOf(0));
        System.out.println(L.lastIndexOf(0));

        //0 2 3 4 0
        List<Integer> L1=L.subList(1,3);
        System.out.println(L1);
    }
}
