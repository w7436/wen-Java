
import java.util.LinkedList;
import java.util.Queue;

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
            System.out.print(root.val + " ");
            inOrder(root.right);
        }
    }
    public void inOrder(){
        System.out.print("中序遍历：");
        inOrder(root);
        System.out.println();

    }
    private void postOrder(TreeNode root){
        if (null != root){
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.val + " ");

        }
    }
    public void postOrder(){
        System.out.print("后序遍历为：");
        postOrder(root);
        System.out.println();
    }


    //获取二叉树节点的个数，左子树+右子树+1
    private int  getNodeCount(TreeNode root){
        if(root == null){
            return 0;
        }
        return  getNodeCount(root.left) + getNodeCount(root.right)+1;
    }
    public void getNodeCount(TreeNode root, int k){
        System.out.println(getNodeCount(this.root));
    }


    //获取叶子结点 左子树+右子树
    private int getLeafCount(TreeNode root){
        if (root == null){
            return 0;
        }
        //判断叶子结点
        if(root.left == null && root.right == null){
           return 1;
        }
        return getLeafCount(root.left) + getLeafCount(root.right);
    }

    public void getLeafCount(){
        System.out.println(getLeafCount(root));
    }


    //获取第k层结点的个数
    private int getKNodeCount(TreeNode root ,int k){
        if (root == null || k < 0){
            return 0;
        }
        if (k == 1){
            return 1;
        }
         return getKNodeCount(root.left,k-1) + getKNodeCount(root.right,k-1);

    }
    public int getKNodeCount(int k){
       return getKNodeCount(root , k);
    }


    //求二叉树的高度
    private int getHeight(TreeNode root){
        if (null == root){
            return 0;
        }
        int leftHeight= getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return leftHeight > rightHeight ? leftHeight+1 : rightHeight+1;
    }
    public int getHeight(){
        return getHeight(root);
    }

//    //获取Val在树中对应的结点，找到并返回该节点
    public TreeNode find (TreeNode root,int val){
        TreeNode ret = null;
        if(root == null){
            return null;
        }
        if(root.val == val ){
            return root;
        }
        if (null != (ret = find(root.left,val)) || null != (ret = find(root.right,val)))
            return ret;
        return null;
    }


    //判断是否为相同的树
    public boolean isSameTree(TreeNode p, TreeNode q){
        if(p == null && q==null){
            return true;
        }
        if (p == null || q == null){
            return false;
        }
        if (p.val != q.val){
            return false;
        }
        return isSameTree(p.left,q.left ) && isSameTree(p.right,q.right);
    }

    //一棵树是另一颗树的子树
    public boolean isSubtree(TreeNode s,TreeNode t){
        if(null == s){
            return false;
        }
        //s不为空，t是空数
        if (null == t){
            return true;
        }
        //s 和 t都不为空
        //1、是相同的树
        if(s.val == t.val && isSameTree(s, t)){
            return true;
        }

        //子树
        return isSubtree(s.left,t)||isSubtree(s.right,t);

    }


    //平衡二叉树：
    public boolean isBalanced (TreeNode root){
        if (root == null){
            return true;
        }
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        if (Math.abs(right - left) >1){
            return false;
        }
        return isBalanced(root.left)&& isBalanced(root.right);
    }

    //层序遍历
    public void levelOrder(){
        if (null == root){
            return;
        }
        Queue<TreeNode> q= new LinkedList<>();
        q.offer(root);
        while (! q.isEmpty()){
            TreeNode cur = q.poll();
            System.out.println(cur.val);

            if (cur.left !=null){
                q.offer(cur.left);
            }
            if (cur.right != null){
                q.offer(cur.right);
            }
        }
        System.out.println();

    }
    //根据前序和中序，还原二叉树
    //根据中序和后序，还原二叉树

    public static void main(String[] args) {
        TestDemo testDemo= new TestDemo();
        testDemo.preOrder();
        testDemo.inOrder();
        testDemo.postOrder();
  //      testDemo.getNodeCount();
        testDemo .getLeafCount();
        System.out.println(testDemo.getKNodeCount(3));
        System.out.println(testDemo.getHeight());

    }
}
