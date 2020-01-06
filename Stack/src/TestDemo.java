
import java.util.Stack;
import java.lang.String;
/**
 * @ClassName TestDemo
 * @Description TODO
 * @Author DELL
 * @Data 2020/1/4 9:50
 * @Version 1.0
 **/

/*括号匹配*/
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        for (int i=0;i<s.length();i++){
            char left=s.charAt(i);  //拿到第一个字符
            if(left=='('||left=='['||left=='{'){ //如果是左括号则入栈
                stack.push(left);
            }
            else{ //如果是右括号则进行匹配
                if (stack.isEmpty()){ //如果栈为空，则说明右括号比左括号多
                    return false;
                }
                else{//栈不为空，则进行匹配
                    if (left==')'&&stack.peek()=='('
                            ||left==']'&&stack.peek()=='['
                            ||left=='}'&&stack.peek()=='{'){
                        stack.pop();
                    }
                    else{
                        return false;
                    }
                }
            }
        }
        if (stack.isEmpty()){
            return true;
        }else{
            return false;
        }

    }



//后缀表达式求值
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack=new Stack<>();
        for (String s:tokens) {
            if (s.equals("+")){
                stack.push(stack.pop()+stack.pop());
            }else if (s.equals("-")){
                stack.push(-stack.pop()+stack.pop());
            }else if (s.equals("*")){
                stack.push(stack.pop()*stack.pop());
            }else if(s.equals("/")){
                int num1=stack.pop();
                stack.push(num1/stack.pop());
            }
            else{
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }

}

/*
public class TestDemo {

    public static void main(String[] args) {
        Stack<String> stack=new Stack<>();
        System.out.println(stack.size());
        System.out.println(stack.empty());
        stack.push("1111");
        stack.push("2222");
        stack.push("3333");
        stack.push("4444");
        stack.push("5555");

        System.out.println(stack.size());
        System.out.println(stack.empty());
        System.out.println(stack.peek());//拿到栈顶元素

        stack.pop();//删除栈顶元素
        System.out.println(stack.size());
        System.out.println(stack.peek());

    }
}
*/
class Node{

    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

}

/*
public class TestDemo {
    //逆序打印单链表
    public static void print(Node head){
        if (head!=null){
            print(head.next);
            System.out.println(head.data);
        }
    }
    public static void print1(Node head){
        Node cur=head;
        Stack<Integer> stack=new Stack<>();
        while(cur!=null){
            stack.push(cur.data);
            cur=cur.next;
        }
        while(!stack.empty()){
            System.out.println(stack.pop());
        }

    }
    public static void main(String[] args) {
        Node n1=new Node(1);
        Node n2=new Node(2);
        Node n3=new Node(3);
        Node n4=new Node(4);

        n1.next=n2;
        n2.next=n3;
        n3.next=n4;

        print(n1);
        print1(n1);

    }
}
*/
class MyStack<E>{
    private E[] array=(E[])new Object[100];
    private int size=0;
    public void push(E e){
        if (size==100)
            return;
        array[size++]=e;

    }
    public E pop(){
       if (empty())
           return null;
       E e=array[size-1];
       size--;
       return e;
    }
    public E peek(){
        if (empty())
            return null;
        return array[size-1];

    }
    public boolean empty(){
        return 0==size;
    }
    public int getSize(){
        return size;
    }
}
public class TestDemo {
    public static void main(String[] args) {
        MyStack<Integer> myStack=new MyStack<>();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);

        System.out.println(myStack.getSize());
        System.out.println(myStack.peek());

        myStack.pop();
        System.out.println(myStack.peek());

        System.out.println(myStack.getSize());

    }
}