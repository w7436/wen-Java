package Test;

/**
 * @ClassName Main
 * @Description TODO
 * @Author DELL
 * @Data 2020/6/13 14:52
 * @Version 1.0
 **/
public class Main {
    public static void main(String[] args) {
        Myqueue que=new Myqueue();
        que.put("a");
        que.put("b");
        que.put("c");

        while(!que.isEmpty()){
            //获取第一个元素
            Object k=que.get();

            System.out.println(k);
        }
    }
}
