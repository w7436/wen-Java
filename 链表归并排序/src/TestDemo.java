/**
 * @ClassName TestDemo
 * @Description TODO
 * @Author DELL
 * @Data 2019/11/30 11:26
 * @Version 1.0
 **/
class ListNode {
    int  val;
    ListNode next;
    public ListNode(int val) {
        this.val = val;
    }
}
public class TestDemo {
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
                if (left.val < right.val) {
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

    public static void main(String[] args) {

    }
}

