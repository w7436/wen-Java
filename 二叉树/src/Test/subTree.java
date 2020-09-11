package Test;

/**
 * @ClassName subTree
 * @Description TODO
 * @Author DELL
 * @Data 2020/3/28 15:37
 * @Version 1.0
 **/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
public class subTree {
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(q == null&& p == null){
            return true;
        }
        if(p==null|| q == null){
            return false;
        }
        if(p.val != q.val){
            return false;
        }
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
    public static boolean isSubtree(TreeNode s, TreeNode t) {

        if (s == null) {
            return false;
        }

        if (t == null) {
            return true;
        }
        if (isSameTree(s, t)) {
            return true;
        }
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }
    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b= new TreeNode(2);
        a.left = b;
        a.right = null;

        TreeNode a1 = new TreeNode(1);
        TreeNode b2= new TreeNode(2);
        a1.left = null;
        a1.right = b2;

        TreeNode p = a;
        TreeNode q = a1;

        System.out.println(isSameTree( p,  q));


    }

}
