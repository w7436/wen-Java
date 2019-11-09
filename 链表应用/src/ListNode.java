/**
 * @ClassName ListNode
 * @Description TODO
 * @Author DELL
 * @Data 2019/10/29 19:48
 * @Version 1.0
 **/
public class ListNode {
        public int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
        ListNode(){
            this.next=null;
        }

        public int Size(ListNode l1){
            int count=0;
            while(l1.next!=null){
                count++;
                l1=l1.next;
            }
            return count;
        }
        public void addLast(int data,ListNode l3){
            ListNode node=new ListNode(data);
            ListNode cur=l3;
            while(cur.next!=null){
                cur=cur.next;
            }
            cur.next=node;
        }

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int sum1=0;
            long sum=0;
            int i=0;
            int count=Size(l1);
            while(l1!=null){
                if(i<=count){
                    sum1+=l1.val*Math.pow(10,i);
                    l1=l1.next;
                    i++;
                }
            }
            long sum2=0l;
            int count2=Size(l2);
            int j=0;
            while(l2!=null){
                if(j<=count2){
                    sum2+=l2.val*Math.pow(10,j);
                    l2=l2.next;
                    j++;
                }
            }
            sum=(long)sum1+sum2;
            ListNode l3=new ListNode((int)(sum%10));
            while(sum/10!=0){
                sum/=10;
                addLast((int)(sum%10),l3);
            }
            return l3;
        }
    public void display(ListNode l1){
        ListNode cur=l1;
        while(cur!=null){
            System.out.println(cur.val);
            cur=cur.next;
        }
    }
}
