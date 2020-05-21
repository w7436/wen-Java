package jvm;

/**
 * @ClassName JVMStackLook
 * @Description TODO
 * @Author DELL
 * @Data 2020/5/18 19:14
 * @Version 1.0
 **/
public class JVMStackLook {
    private static class Node{
        private Node next;
        private String name;

        public Node(String name) {
            this.name = name;
        }
    }

    public static void test(Node node){
        node.next = new Node("B");
        node = new Node("C");
    }
    public static void main(String[] args) {//A B
        Node node = new Node("A");
        test(node);
        System.out.println(node.name);
        System.out.println(node.next.name);
    }
}
