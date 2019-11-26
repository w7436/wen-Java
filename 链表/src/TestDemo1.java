import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.List;

/**
 * @ClassName TestDemo1
 * @Description TODO
 * @Author DELL
 * @Data 2019/10/27 15:23
 * @Version 1.0
 **/
public class TestDemo1 {
    public static int length(ListNode head){
        int count=0;
        if (head==null){
            return 0;
        }
        else{
            while(head!=null){
                count++;
                head=head.next;
            }
        }
        return count;
    }
  //  public static void

    //链表的交点
    public static ListNode  getIntersectionNode
    (ListNode headA,ListNode headB){
        if(headA == null || headB == null) {
            return null;
        }
        int len=0;
        ListNode pL = headA;     //永远指向最长的单链表
        ListNode pS = headB;    //永远指向最短的单链表
        int lenA =length(headA);
        int lenB=length(headB);
        //求长度的差值
        len = lenA-lenB;
        //如果是负数-》
        if (len<0){
            pL = headB;
            pS = headA;
            len = lenA-lenB;
        }
        //只需要让pL走len步就好了
        while(len>0){
            pL= pL.next;
            len--;
        }
        //走完len步之后  两个同时开始走  一直走 走到next值相同时 就是交点
        //万一没有相交，两个链表一样长
        while (pL != pS && pL != null) {
            pL = pL.next;
            pS = pS.next;
        }
        if(pL == pS && pS != null) {
            return pL;
        }
        return null;
    }

    //合并两个有序链表
    public static ListNode mergeTwoLists(ListNode headA,ListNode headB){
        ListNode newHead=new ListNode(-1);//创建虚拟的链表
        ListNode tmp=newHead;
        while(headA!=null&&headB!=null){
            if(headA.data<headB.data){
                tmp.next=headA;
                headA=headA.next;
                tmp=tmp.next;
            }else{
                tmp.next=headB;
                headB=headB.next;
                tmp=tmp.next;
            }
        }
        if(headA==null){
            tmp.next=headB;
        }
        if(headB==null){
            tmp.next=headA;
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        MySignalList mysignallist=new MySignalList();

        mysignallist.addLast(1);
        mysignallist.addLast(2);
        mysignallist.addLast(0);
        mysignallist.addLast(4);

        int[] array={0,1,2,3,4};
        int m=mysignallist.numComponents(array);
        System.out.println(m);

    }


    public static void main2(String[] args) {
       MySignalList mysignallist=new MySignalList();

       mysignallist.addLast(1);
        mysignallist.addLast(7);
        mysignallist.addLast(3);
        mysignallist.addLast(2);
        mysignallist.addLast(3);

//        mysignallist.addFirst(3);
//        mysignallist.addFirst(2);
//        mysignallist.addFirst(3);
//        mysignallist.addFirst(7);
//        mysignallist.addFirst(1);
        mysignallist.creatLoop();
        ListNode node=mysignallist.detectCycle();
        System.out.println(node.data);
//        MySignalList mysignallist2=new MySignalList();
//        mysignallist.addFirst(1);
//        mysignallist.addFirst(2);
//        mysignallist.addFirst(4);
//        mysignallist.addFirst(5);
//        mysignallist.addFirst(6);

//        //分割结点
//        ListNode head=mysignallist.partition(4);
//        mysignallist.display1(head);







      //  mysignallist.creatLoop();
//        mysignallist.display();
//        System.out.println();
      //  System.out.println(mysignallist.chkPalindrome());
//        ListNode node=mysignallist.detectCycle();
//        System.out.println(node.data);



        //删除相同结点
//        ListNode head=mysignallist.deleteDuplication();
//        mysignallist.display1(head);


//        System.out.println("-----------------");
//        mysignallist.addLast(1);
//        mysignallist.addLast(2);
//        mysignallist.addLast(3);
//        mysignallist.addLast(4);

//        ListNode node=mysignallist.reverseList1();
//        mysignallist.display1(node);
//        mysignallist.display();
//        ListNode mid=mysignallist.middleNode();
//        System.out.println(mid.data);
//        ListNode tail=mysignallist.findKthToTail(6);


       // System.out.println(tail.data);
//        ListNode head=mysignallist.reverseList();
//        mysignallist.display1(head);




    }
}
