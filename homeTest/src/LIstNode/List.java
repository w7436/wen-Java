package LIstNode;

import java.util.Stack;

/**
 * @ClassName List
 * @Description TODO
 * @Author DELL
 * @Data 2020/5/19 21:06
 * @Version 1.0
 **/
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}
public class List {

    /**
     *你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。
     * 它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表
     * 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 8 -> 0 -> 7
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        // 将链表数据入栈，栈顶为低位
        while ((l1 != null) || (l2 != null)) {
            if (l1 != null) {
                stack1.push(l1.val);
                l1 = l1.next;
            }
            if (l2 != null) {
                stack2.push(l2.val);
                l2 = l2.next;
            }
        }
        int num1 = 0;
        int num2 = 0;
        // 存储进位数据
        int carry = 0;

        // 最终结果
        ListNode result = null;

        // 出栈，出栈过程是计算相对低位数据的过程
        while (!stack1.empty() || !stack2.empty() || carry == 1) {
            num1 = stack1.empty() ? 0 : stack1.pop();
            num2 = stack2.empty() ? 0 : stack2.pop();
            ListNode listNode = new ListNode(0);
            // 有进位的情况
            if (num1 + num2 + carry > 9) {
                listNode.val = num1 + num2 + carry - 10;
                carry = 1;
            } else {
                // 无进位
                listNode.val = num1 + num2 + carry;
                carry = 0;
            }
            // 原有高位降一位
            listNode.next = result;
            // 设置最新高位
            result = listNode;
        }
        return result;
    }

}
