import sun.reflect.generics.tree.Tree;

/**
 * @ClassName TestDemo
 * @Description TODO
 * @Author DELL
 * @Data 2019/12/20 22:49
 * @Version 1.0
 **/
class TreeNode {
    int val;
    TreeNode left ;
    TreeNode right ;

    public TreeNode(int val) {
        this.val = val;
    }

}
public class TestDemo {
//    //确定二叉树的深度
//    public int maxDepth(TreeNode root) {
//        if(root==null){
//            return 0;
//        }
//        int left_height = maxDepth(root.left);
//        int right_height = maxDepth(root.right);
//        return java.lang.Math.max(left_height, right_height)+1 ;
//    }
//
//    public static void inOrderNor(TreeNode root){
//        if(null == root){
//            return;
//        }
//        //找root为根的二叉树最左侧的结点，并且保存路径中所有的节点
//        TreeNode cur  = root;
//        Stack<TreeNode> s = new Stack<>();
//
//        while(!s.empty()||cur != null){
//            //当结点不为空时，入栈
//            while (null != cur){
//                s.push(cur);
//                cur = cur.left;
//            }
//            //当结点为空,表示该树已经遍历完成
//            //可以遍历Cur的根节点，也就是栈顶元素
//            cur = s.peek();
//            System.out.println(cur.val);
//            s.pop();
//
//            //以cur为根的二叉树
//            cur = cur.right;
//        }
//    }

    private TreeNode root = null;

    public TestDemo() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);

        root = n1;
        n1.left = n2;
        n1.right = n4;
        n2.left = n3;
        n4.left = n5;
        n4.right = n6;


    }

    //前序遍历
    private void preOrder (TreeNode root){
        if (root != null){
            System.out.print(root.val + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public void preOrder(){
        System.out.print("前序遍历：");
        preOrder(root);
        System.out.println();
    }

    private void inOrder (TreeNode root){
        if(null != root){
            inOrder(root.left);
            System.out.println(root.val + " ");
            inOrder(root.right);
        }
    }
    public void inOrder(){
        System.out.print("中序遍历：");
        inOrder(root);

    }
    private void postOrder(TreeNode root){
        if (null != root){
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.val + ' ');

        }
    }
    public static void main(String[] args) {
        TestDemo testDemo= new TestDemo();
        testDemo.preOrder();

    }
}
