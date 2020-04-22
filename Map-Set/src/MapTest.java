/**
 * @ClassName MapTest
 * @Description TODO
 * @Author DELL
 * @Data 2020/4/22 15:24
 * @Version 1.0
 **/

import java.util.*;

/**
 * Map是一个接口，接口没有继承Collection
 * Map中存在键值对时，要求key不能重复
 * Map中的键值对，键值对体现：在Map内部实现定义Entry接口，该接口中含有K,V
 *
 */
public class MapTest {
    public static void testTreeMap(){
        Map<String ,String> map = new TreeMap<>();
        map.put("apple","苹果");

        map.put("peach","桃");

        //map中的key不可以重复
        //如果key存在，则使用value值替换原key所对应的value
        //如果key不存在，则直接插入
        //在插入是会保证key是一个有序的序列(则key为空，抛出异常)
        //而对于自定义的类，则必须可以进行比较大小，实现Comparable接口当中的Comparator

        //返回值：如果key不存在，则将键值对插入，然后返回null
              //  如果key存在,用value覆盖原key对应value,并且返回原来的value
        map.put("banana","香蕉");
        map.put("banana","香香");
        System.out.println(map.size());
        System.out.println(map);

        System.out.println(map.get("banana"));//返回当前的value
        System.out.println(map.get("nanana"));//如果不存在返回null
   //     System.out.println(map.get(null));//抛出空指针异常


        //remove(key)：将Map中的key所对应的键值对删除掉
        //如果key存在，则返回该value
        //如果key不存在，则返回null
        System.out.println(map.remove("banana"));
        System.out.println(map);

        //寻址key是根据Map底层的特性来进行比较，时间复杂度（O（logN））
        //寻找value的时间复杂度为（O(N)）

        //打印key
        for(String s : map.keySet()){
          System.out.print(s+" ");
        }
        for(String s:map.values()){
            System.out.println(s+" ");
        }
        for(Map.Entry<String,String> e:map.entrySet()){
            System.out.print(e.getKey()+"---->"+e.getValue());
        }
        System.out.println();

    }

    public static void testTreeSet(){
        Set<String> s = new TreeSet<>();
        s.add("小绿");
        s.add("小蓝");
        s.add("小红");
        System.out.println(s.size());
        System.out.println(s);

        //遍历:迭代器：设计模式：依次寻访容器中的元素，而又不需要了解其底层数据结构或者无须暴露接口实现

        Iterator<String> it = s.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

        System.out.println(s.remove("小红"));
    }
    public static void main(String[] args) {
   //     testTreeMap();
        testTreeSet();
    }
}

















