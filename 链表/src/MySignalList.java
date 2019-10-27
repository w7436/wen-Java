import java.util.List;

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
    //打印单链表
    public void display(){
        ListNode cur=this.head;
        while(cur!=null){
            System.out.println(cur.data);
            cur=cur.next;
        }
    }
}
