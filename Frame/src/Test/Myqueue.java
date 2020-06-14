package Test;

import java.util.LinkedList;

/**
 * @ClassName Myqueue
 * @Description TODO
 * @Author DELL
 * @Data 2020/6/13 14:52
 * @Version 1.0
 **/
public class Myqueue {
    LinkedList<Object> data=new LinkedList<>();

    public boolean isEmpty(){

        return data.size()==0?true:false;

    }

    public void put(Object o){

        data.add(o);

    }

    public Object get(){

        //从队列中获取元素，获取最先放入元素，获取后从队列中删除该元素

        Object obj=data.getFirst();

        //获取后从队列中删除该元素

        data.removeFirst();
        return obj;
    }
}
