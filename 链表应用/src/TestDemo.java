/**
 * @ClassName TestDemo
 * @Description TODO
 * @Author DELL
 * @Data 2019/10/29 17:26
 * @Version 1.0
 **/
public class TestDemo {
    public static void main(String[] args) {
        ListNode l1=new ListNode(1);
//        l1.addLast(1,l1);
//        l1.addLast(2,l1);
//        l1.addLast(3,l1);
        //l1.display(l1);
        ListNode l2=new ListNode(1);
        l2.addLast(9,l2);
        l2.addLast(9,l2);
        l2.addLast(9,l2);
        l2.addLast(9,l2);
        l2.addLast(9,l2);
        l2.addLast(9,l2);
        l2.addLast(9,l2);
        l2.addLast(9,l2);
        l2.addLast(9,l2);
        //l2.display(l2);
        ListNode l3=new ListNode();
        l3=l3.addTwoNumbers(l1,l2);
        l3.display(l3);
    }
}
