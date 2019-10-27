/**
 * @ClassName TestDemo1
 * @Description TODO
 * @Author DELL
 * @Data 2019/10/27 15:23
 * @Version 1.0
 **/
public class TestDemo1 {
    public static void main(String[] args) {
        MySignalList mysignallist=new MySignalList();
        mysignallist.addFirst(1);
        mysignallist.addFirst(2);
        mysignallist.addFirst(3);
        mysignallist.addFirst(4);
        mysignallist.display();

        System.out.println("-----------------");
        mysignallist.addLast(1);
        mysignallist.addLast(3);
        mysignallist.addLast(4);
        mysignallist.addLast(5);
        mysignallist.addIndex(4,0);
        mysignallist.display();
    }
}
