import sun.reflect.generics.tree.Tree;

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
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.right.left=new TreeNode(4);
        TestDemo testDemo=new TestDemo();
        System.out.println(testDemo.maxDepth(root));
    }
}
