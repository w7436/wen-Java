/**
 * @ClassName DoubleList
 * @Description TODO
 * @Author DELL
 * @Data 2019/11/6 21:05
 * @Version 1.0
 **/
class ListNode {
    public int data;
    public ListNode prev;//前驱
    public ListNode next;//后继
    //new ListNode(10);
    public ListNode(int data) {
        this.data = data;
    }
}

class DoubleList {
    public ListNode head;//头
    public ListNode last;//尾巴
    public void addFirst(int data) {
        ListNode node = new ListNode(data);
        if(this.head == null) {
            this.head = node;
            this.last = node;
        }else {
            node.next = this.head;
            this.head.prev = node;
            this.head = node;
        }
    }
    //尾插
    public void addLast(int data){
        ListNode node = new ListNode(data);
        if(this.head==null){
            this.head=node;
            this.last=node;
        }else{
            this.last.next=node;
            node.prev=this.last;
            this.last=node;
        }
    }
    private int size(){
       int count=0;
       if(head==null){
           return 0;
       }else{
           while(head!=null){
               count++;
               head=head.next;

           }
           return count;
       }
    }
    private ListNode searchIndex(int index) {
        if(index<0||index>size()){
            return null;
        }
        ListNode cur=this.head;
        while(index>0) {
            cur = cur.next;
            index--;
        }
        return cur;
    }

    //任意位置插入,第一个数据节点为0号下标
    public boolean addIndex(int index,int data){
        ListNode node=new ListNode(data);//插入的结点
        if(index==0){
            addFirst(data);//头插
            return true;
        }
        if(index==size()){
            addLast(data);//尾插
            return true;
        }
        ListNode tmp=searchIndex(index);


        node.next=tmp;
        tmp.prev.next=node;
        node.prev=tmp.prev;
        tmp.prev=node;

        return true;
    }

//删除第一次处出现关键字为key的结点
    public int remove(int key){
        int oldData=-1;//存储要删除的数字
        ListNode cur=this.head;
        while(cur!=null){
            if(cur.data==key) {
                oldData=cur.data;
                if(cur==this.head){
                    this.head=cur.next;
                    cur.next.prev=null;
                    return oldData;
                }
                else if(cur==this.last){
                    this.last=cur.prev;
                    cur.prev.next=null;
                    return oldData;
                }else{
                    cur.prev.next=cur.next;
                    cur.next.prev=cur.prev;
                    return oldData;
                }
            }
            cur=cur.next;
        }
        return 0;
    }

    public void removeAllKey(int key){
        int oldData=-1;//存储要删除的数字
        ListNode cur=this.head;
        while(cur!=null){
            if(cur.data==key) {
                oldData=cur.data;
                if(cur==this.head){
                    this.head=cur.next;
                    cur.next.prev=null;

                }
                else if(cur==this.last){
                    this.last=cur.prev;
                    cur.prev.next=null;

                }else{
                    cur.prev.next=cur.next;
                    cur.next.prev=cur.prev;

                }
            }
            cur=cur.next;
        }

    }
    //防止内存泄露
    public void clear(){

        while(this.head!=null){
           ListNode cur=this.head.next;
           this.head.next=null;
           this.head.prev=null;
           this.head=cur;
        }
        this.last=null;
}
    //打印
    public void display(){
        ListNode cur=this.head;
        while(cur!= null){
            System.out.print(cur.data+" ");
            cur=cur.next;
        }
    }

}