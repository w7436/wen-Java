import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @ClassName TestDemo
 * @Description TODO
 * @Author DELL
 * @Data 2020/1/5 9:38
 * @Version 1.0
 **/


/**
 * 用两个队列模拟实现栈
 * 入栈:将元素插入到q1队列中，
 * 出栈：
 * 1、将q1中的元素，移动size-1个
 * 2、将剩下的一个元素删除掉
 * 3、交换q1,q2,
 * 判空：只要q1是空的
 * 获取栈顶：
 * 1、将q1中的元素，移动size-1个
 * 2、从q1中取栈顶元素
 * 3、将q1中的元素搬移到q2
 * 4、交换
 * */
class MyStack {

    Queue<Integer> q1=null;
    Queue<Integer> q2=null;
    /** Initialize your data structure here. */
    public MyStack() {
        q1=new LinkedList<>();
        q2=new LinkedList<>();
    }
    /** Push element x onto stack. */
    public void push(int x) {
        q1.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while(q1.size()>1){
            q2.offer(q1.poll());
        }
       int ret= q1.poll();
        Queue<Integer> tmp=q1;
        q1=q2;
        q2=tmp;
        return ret;
    }
    /** Get the top element. */
    public int top() {
        while(q1.size()>1){
            q2.offer(q1.poll());
        }
        int ret= q1.peek();
        q2.offer(q1.poll());
        Queue<Integer> tmp=q1;
        q1=q2;
        q2=tmp;
        return ret;

    }
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty();
    }
}


/**
 * 栈实现队列
 * 入队列：将元素放置s1
 * 出队列：检测s2是否为空，为空，将s1中的元素搬移到s2,删除s2栈顶的元素，不为空，直接删除s2
 * 获取队头：检测s2是否为空，否，直接从栈顶获取，是，将s1中的元素搬移到s2,直接获取
 *
 * 判空：两个栈都是空的
 * */
class MyQueue {

    /** Initialize your data structure here. */
    Stack<Integer> s1=null;
    Stack<Integer> s2=null;
    public MyQueue() {
        s1=new Stack<>();
        s2=new Stack<>();
    }
    /** Push element x to the back of queue. */
    public void push(int x) {
        s1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
       if(s2.isEmpty()){
           while(!s1.isEmpty()){
               s2.push(s1.pop());
           }
       }
       int ret=s2.pop();
       return ret;
    }

    /** Get the front element. */
    public int peek() {
        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
       return s1.empty()&&s2.empty();
    }
}
/**
 * 循环队列
 * */
class MyCircularQueue {
    private int[] array=null;
    private int capacity=0;
    private int size=0;
    private int front=0;
    private int rear=0;
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        array=new int[k];
        capacity=k;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (size==capacity){
            return false;
        }
        array[rear++]=value;
       // rear%=capacity;
        if (rear==capacity){
            rear=0;
        }
        size++;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (isEmpty()){
            return false;
        }
        front++;
        if (front==capacity){
            front=0;
        }
        size--;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if (isEmpty()){
            return -1;
        }
        return array[front];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if (isEmpty()){
            return -1;
        }
        return array[(rear-1+capacity)%capacity];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return 0==size;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        if(size==capacity){
            return true;
        }
        return false;
    }
}
class Node <E>{
    public Node<E> next;
    public E data;
    public Node(E e){
        next=null;
        data=e;
    }
    public Node(){
        next=null;
    }
}
class MyQueue1<E>{
    private Node<E> front;
    private Node<E> rear;
    private int size;
    MyQueue1(){
        front=rear=new Node<E> ();
        size=0;
    }
    boolean offer(E e){
        Node<E> node =new Node<>(e);
        rear.next=node;
        rear=rear.next;
        size++;
        return true;
    }
    E poll(){
        if (isEmpty()){
            return null;
        }
        E ret=front.next.data;
        front.next=front.next.next;
        size--;
        return ret;
    }
    E peek(){
        if (isEmpty()){
            return null;
        }
        return front.next.data;
    }
    int getSize(){
        return size;
    }
    boolean isEmpty(){
        return 0==size;
    }
}
public class TestDemo {
    public static void main1(String[] args) {
        Queue<String> q=new LinkedList<>();
        System.out.println(q.isEmpty());
        System.out.println(q.size());

        q.offer("1");
        q.offer("2");
        q.offer("3");
        q.offer("4");
        System.out.println(q.size());
        System.out.println(q.peek());
        q.poll();
        q.poll();
        System.out.println(q.peek());
    }
}
