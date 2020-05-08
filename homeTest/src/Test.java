import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Test
 * @Description TODO
 * @Author DELL
 * @Data 2020/5/2 11:04
 * @Version 1.0
 **/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Test {
    /**
     * 树的子结点

     * @return
     */

    public boolean isSubStructure(TreeNode A, TreeNode B){
        if(B == null || A == null) return false;
        if(isEuql(A,B)) return true;
        else
            return isSubStructure(A.left,B)||isSubStructure(A.right,B);
    }
    boolean isEuql(TreeNode A,TreeNode B){
        if(B == null) return true;
        if(A == null ) return false;
        if(A.val == B.val){
            return isEuql(A.left,B.left) && isEuql(A.right,B.right);
        }
        else return false;
    }
    //从根路径到指定结点存储路径上的结点
    public static boolean search(TreeNode root, TreeNode node , List<TreeNode> path ){
        if (root == null) return false;
        path.add(root);
        if (root == node) return true;
        boolean ret = search(root.left, node, path) || search(root.right, node, path);
        if (ret) return true;
        path.remove(path.size()-1);
        return false;
    }
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        List<TreeNode> ppath = new ArrayList<>();
//        List<TreeNode> qpath = new ArrayList<>();
//        search(root, p, ppath);
//        search(root, q, qpath);
//        int i = 0, len = Math.min(ppath.size(), qpath.size());
//        while (i < len && ppath.get(i) == qpath.get(i)) ++i;
//        return ppath.get(i-1);

        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        else if (left != null) return left;
        else return right;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(3);
        TreeNode c = new TreeNode(4);
        TreeNode d = new TreeNode(5);
        TreeNode e = new TreeNode(6);

        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;
        b.right = e;


        lowestCommonAncestor(root,d,e);


    }
}
