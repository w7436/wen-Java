import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName MySignalList
 * @Description TODO
 * @Author DELL
 * @Data 2019/10/27 15:06
 * @Version 1.0
 **/
//结点类
class ListNode{
    public int data;
    public ListNode next;
    public ListNode(int data){
        this.data=data;
        this.next=null;
    }
}
//链表类
public class MySignalList {
    public ListNode head;
    public MySignalList(){
        this.head=null;
    }
    //头插
    public void addFirst(int data){
        ListNode node=new ListNode(data);
        //如果链表为空
        if (this.head==null){
            this.head=node;
        } else{
            node.next=this.head;
            this.head=node;
        }
    }
    public ListNode addFirst1(int data,ListNode newHead){
        ListNode node=new ListNode(data);
        //如果链表为空
        if (newHead==null){
           newHead=node;
        } else{
            node.next=newHead;
            newHead=node;
        }
        return newHead;
    }

    //尾插
    public void addLast(int data){
        ListNode node=new ListNode(data);
        //链表为空
        if (this.head==null){
           this.head=node;
        } else {
            ListNode cur=this.head;
            while(cur.next!=null){
                cur=cur.next;
            }
            cur.next=node;
        }
    }

    private ListNode searchIndex(int index){
        ListNode cur=head;
        while (index-1>0){
            cur=cur.next;
            index--;
        }
        return cur;
    }
    //任意位置插入,第一个数据节点为0号下标
    public boolean addIndex(int index,int data){
        if (index<0||index>size()){
            System.out.println("位置不合法！");
            return false;
        }
        if (index==0){
            addFirst(data);
            return true;
        }
        else {
            ListNode cur = searchIndex(index);
            ListNode node=new ListNode(data);
            node.next=cur.next;
            cur.next=node;
            return true;
        }
    }
    public boolean contains(int key){
        ListNode cur=this.head;
        if (cur==null){
            System.out.println("链表为空！");
        }
        while (cur!=null){
            if (cur.data==key){
                return true;
            }
            cur=cur.next;
        }
        return false;
    }

    public int size(){
        ListNode cur=head;
        int count=0;
        if (cur==null){
            return 0;
        }
        else {
            while(cur!=null){
                count++;
                cur=cur.next;
            }
            return count;
        }
    }
    private ListNode searchPrev(int key) {
        ListNode cur=this.head;
        while (cur.next!=null){
            if (cur.next.data==key) {
                return cur;
            }
            cur=cur.next;
        }
        return null;
    }

    //删除第一次出现关键字为key的节点
    public void remove(int key){

        if(this.head == null) {
            System.out.println("单链表为空");
            return;
        }
        //0、删除的节点是否是头结点
        if(this.head.data == key) {
            this.head = this.head.next;
            return;
        }
        //1、找到key的前驱  如果返回空
        ListNode prev = searchPrev(key);
        if (prev==null) {
            System.out.println("值不存在");
            return;
        }else{
            ListNode del=prev.next;
            prev.next=del.next;
        }
    }


    //删除所有值为key的值
    public void removeAllKey(int key){
        ListNode prev=this.head;
        ListNode cur=prev.next;
        //未判断头结点是否为key
        while(cur!=null){
            if (prev.next.data==key){
                prev.next=cur.next;
                cur=cur.next;
            }
            else {
                prev=cur;
                cur=cur.next;
            }
        }
        if (this.head.data==key){
            this.head=this.head.next;
        }
    }

////反转链表
//    public ListNode reverseList(){
//        ListNode prev=null;
//        ListNode newHead=null;
//        ListNode cur=this.head;
//        while(cur!=null){
//            ListNode curNext=cur.next;
//            if (curNext==null){
//                newHead=cur;
//            }
//            cur.next=prev;
//            prev=cur;
//            cur=curNext;
//        }
//        return newHead;
//    }


    //中间结点的结点：快慢指针
    public ListNode middleNode(){
        ListNode fast=this.head;
        ListNode slow=this.head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
    //倒数第k个结点
    public ListNode findKthToTail(int k){
        if (k<=0){
            return null;
        }
        ListNode fast=this.head;
        ListNode slow=this.head;
        while(k-1>0){
            //getlength 每判断一次 判断fast是否为空
            if(fast.next!=null){
                fast=fast.next;
                k--;
            }else {
                System.out.println("没有这个结点！");
                return null;
            }
        }
        while (fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        return slow;
    }
    public void display1(ListNode head){
        ListNode cur=head;
        while(cur!=null){
            System.out.print(cur.data+" ");
            cur=cur.next;
        }
    }


    //分割链表
    public ListNode partition(int x){
        ListNode cur=this.head;
        ListNode beforeStart=null;
        ListNode beforeEnd=null;
        ListNode afterStart=null;
        ListNode afterEnd=null;
        while(cur!=null){
            //每遍历一次节点，接此节点的下一个结点置为空，
            ListNode curNext=cur.next;
            cur.next=null;
            if (cur.data<x){
                if (beforeStart==null){
                    beforeStart=cur;
                    beforeEnd=beforeStart;
                }else{
                    beforeEnd.next=cur;
                    beforeEnd=beforeEnd.next;
                }
            }
            else {
                if (afterStart==null){
                    afterStart=cur;
                    afterEnd=afterStart;

                }else{
                    afterEnd.next=cur;
                    afterEnd=afterEnd.next;
                }
            }
         //   cur=cur.next;
            cur=curNext;
        }

        if(beforeStart==null) {
            return afterStart;
        }
        beforeEnd.next=afterStart;
        //循环就是无法确定尾
//        if(afterStart!=null)
//        {
//            afterEnd.next=null;
//        }
        return beforeStart;
    }

    //在一个有序的链表中，删除重复的结点
    public ListNode deleteDuplication() {
        ListNode node = new ListNode(-1);//虚拟结点
        ListNode cur = this.head;
        ListNode tmp = node;
        while (cur != null) {
            if(cur.next != null && cur.data == cur.next.data) {
                 while(cur.next != null&&cur.data==cur.next.data) {
                     cur = cur.next;
                 }
                    cur=cur.next;
            }else {
                //当前节点 不等于下一个节点的时候
                tmp.next = cur;
                cur = cur.next;
                tmp = tmp.next;
            }
        }
        tmp.next=null;
        return node.next;
    }


    //回文
    public boolean chkPalindrome() {
        ListNode fast = this.head;
        ListNode slow = this.head;

        while (fast != null && fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //反转
        ListNode p = slow.next;
        while (p != null) {
            ListNode pNext = p.next;
            //反转
            p.next=slow;
            slow=p;
            p=pNext;
        }
        //slow往前    head 往后  .data不一样 返回false
        while(this.head!=slow){
            if(this.head.data!=slow.data){
                return false;
            }
            //偶数
            if(this.head.next==slow){
                return true;
            }
            this.head=this.head.next;
            slow=slow.next;
        }
        //直到相遇
        return true;
    }



//判断链表是否有环
    public boolean hasCycle(){
        ListNode fast=this.head;
        ListNode slow=this.head;
        while (fast != null && fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
           if(slow==fast){
               return true;
           }
        }
        return false;
    }


    public void creatLoop(){
        ListNode cur=this.head;
        while(cur.next!=null){
            cur=cur.next;
        }
        cur.next=this.head.next;
    }
    //找环的结点:
    public ListNode detectCycle(){
        ListNode fast=this.head;
        ListNode slow=this.head;
        while (fast != null && fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
            if(slow==fast){
               slow=this.head;
               break;
            }
        }
        while(slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }
        return fast;
    }
//单链表的旋转,k代表向后移动的位置
    public ListNode rotateRight(ListNode head, int k){
        if(head==null){
            return null;
        }
        ListNode cur=head;
        //1.先将链表设为有环，同时求出链表的长度
        int n;//链表的长度
        for(n=1;cur.next!=null;n++){
            cur=cur.next;
        }
        cur.next=head;
        ListNode newTail=head;
        ListNode newHead=head;
        for (int i = 0; i <(n-k%n-1) ; i++) {
            newTail=newTail.next;
        }
        newHead=newTail.next;
        newTail.next=null;
        return newHead;
    }
    //内存泄露问题
    public void clear(){
        //一个一个置为空
        while(this.head!=null){
            ListNode cur=this.head.next;
            this.head.next=null;
            this.head=cur;
        }
    }
    //链表组件,给定一个链表（链表结点包含一个整型值）的头结点 head。
    //同时给定列表 G，该列表是上述链表中整型值的一个子集。
    //返回列表 G 中组件的个数，这里对组件的定义为：链表中一段最长连续结点的值（该值必须在列表 G 中）构成的集合。
//    输入:
//    head: 0->1->2->3
//    G = [0, 1, 3]
//    输出: 2
    public int numComponents(int[] G){
        ListNode cur=this.head;
        int count=0;
        Set<Integer> Gset=new HashSet();//构造一个空的集合
        for(int x:G){
            Gset.add(x);
        }
        while(cur!=null){
            if(Gset.contains(cur.data)&&(cur.next==null||!Gset.contains(cur.next.data))){
                count++;
            }
            cur=cur.next;
        }
        return count;
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);
        ListNode h = new ListNode(0);
        ListNode res = h;
        while (left != null && right != null) {
            if (left.data < right.data) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        h.next = left != null ? left : right;
        return res.next;
    }

    //打印单链表
    public void display(){
        ListNode cur=this.head;
        while(cur!=null){
            System.out.print(cur.data+" ");
            cur=cur.next;
        }
    }
}
