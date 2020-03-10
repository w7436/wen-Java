import sun.reflect.generics.tree.Tree;

import java.util.Stack;

/**
 * @ClassName TestDemo
 * @Description TODO
 * @Author DELL
 * @Data 2019/12/20 22:49
 * @Version 1.0
 **/
public class TestDemo {
    //确定二叉树的深度
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int left_height = maxDepth(root.left);
        int right_height = maxDepth(root.right);
        return java.lang.Math.max(left_height, right_height)+1 ;
    }

    public static void inOrderNor(TreeNode root){
        if(null == root){
            return;
        }
        //找root为根的二叉树最左侧的结点，并且保存路径中所有的节点
        TreeNode cur  = root;
        Stack<TreeNode> s = new Stack<>();

        while(!s.empty()||cur != null){
            //当结点不为空时，入栈
            while (null != cur){
                s.push(cur);
                cur = cur.left;
            }
            //当结点为空,表示该树已经遍历完成
            //可以遍历Cur的根节点，也就是栈顶元素
            cur = s.peek();
            System.out.println(cur.val);
            s.pop();

            //以cur为根的二叉树
            cur = cur.right;
        }



    }
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.right.left=new TreeNode(4);
        TestDemo testDemo=new TestDemo();
        System.out.println(testDemo.maxDepth(root));
    }
}
