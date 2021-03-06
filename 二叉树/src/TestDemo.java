
import javafx.util.Pair;

import java.util.*;
import java.util.function.BinaryOperator;

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
    private int index = 0;

    public TestDemo (int[] array,int invalid){
        root = createBinTree(array,invalid);
    }
    //按照前序遍历创造
    TreeNode createBinTree(int[] array,int invalid){
        TreeNode newRoot = null;
        if(index <array.length && array[index]!= invalid){
            //创建根节点
            newRoot = new TreeNode(array[index]);
            //创建左子树
            ++index;

            newRoot.left = createBinTree(array,invalid);
            ++index;

            newRoot.right = createBinTree(array,invalid);
        }
        return newRoot;
    }
//    public TestDemo() {
//        TreeNode n1 = new TreeNode(1);
//        TreeNode n2 = new TreeNode(2);
//        TreeNode n3 = new TreeNode(3);
//        TreeNode n4 = new TreeNode(4);
//        TreeNode n5 = new TreeNode(5);
//        TreeNode n6 = new TreeNode(6);
//
//        root = n1;
//        n1.left = n2;
//        n1.right = n4;
//        n2.left = n3;
//        n4.left = n5;
//        n4.right = n6;
//
//
//    }

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
    //前序非递归
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        List<Integer> l = new LinkedList<>();
        if(root == null){
            return l;
        }
        s.push(root);
        while(!s.empty()){
            TreeNode ret = s.pop();
            l.add(ret.val);
            if(ret.right != null){
                s.push(ret.right);
            }
            if(ret.left != null){
                s.push(ret.left);
            }
        }
        return l;
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


    public void postOrderNor(){

        TreeNode cur = root;
        TreeNode prev = null;
        Stack<TreeNode> s = new Stack<>();
        while (!s.empty()||null != cur){
            //1、找以cur为根的二叉树，最左侧的结点
            while (null != cur){
                s.push(cur);
                cur = cur.left;
            }
            //2、获取cur子树的跟
            TreeNode top = s.peek();
            //3、遍历top的右子树,如果为空，则打印top值，
            // 不为空，则重新开始
            if (top.right == null && prev != top){
                System.out.println(top.val+ " ");
                prev = top;
                s.pop();
            }
            else{
                cur = top .right;
            }
        }
        System.out.println();
    }
    //二叉树的最近公共祖祖先
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == null || q== null){
            return null;
        }
        if(root == p || root == q ){
            return root;
        }
        //检测p,q在root子树中的情况
        boolean isPleft = false;
        boolean isPright = false;
        boolean isQleft = false;
        boolean isQright = false;
        //检测p是否在左子树
        if(isNodeInTree(root.left,p)){
            isPleft = true;
            isPright = false;
        }
        else{
            isPleft = false;
            isPright = true;
        }
        //检测q在左子树
        if(isNodeInTree(root.left,q)){
            isQleft = true;
            isQright = false;
        }
        else{
            isQleft = false;
            isQright = true;
        }
        if(isPleft && isQright || isPright && isQleft){
            return root;
        }
        else if(isPleft && isQleft){
            return lowestCommonAncestor1(root.left, p ,q);
        }
        else{
            return lowestCommonAncestor1(root.right , p ,q);
        }
    }
    private boolean isNodeInTree(TreeNode root,TreeNode node){
        if(root == null){
            return false;
        }
        if(root == node ){
            return true;
        }
        if( isNodeInTree(root.left,node) ||  isNodeInTree(root.right,node)){
            return true;
        }
        return false;
    }

    //
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q)  return root;
        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        TreeNode right = lowestCommonAncestor2(root.right, p, q);
        if(left != null && right != null) return root;
        else if(left != null) return left;
        else return right;
    }

    //保存从根节点到目标结点之间的路径结点
    private boolean search (TreeNode root, TreeNode node, List<TreeNode> path){
        if (root == null) return false;
        path.add(root);
        if (root == node) return true;
        boolean ret =(search(root.left, node, path ) || search(root.right, node, path));
        if (ret ) return true;
        path.remove(path.size()-1);
        return false;
    }

    //利用保存路径 1 2 4     ，，，      1 2 5       那么最近的公共祖先就是 2
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> ppath = new ArrayList<>();
        List<TreeNode> qpath = new ArrayList<>();
        search(root, p, ppath);
        search(root, q, qpath);
        int i = 0,len = Math.min(ppath.size(),qpath.size());
        while(i < len && ppath.get(i) == qpath.get(i)) i++;
        return ppath.get(i-1);
    }

    //求二叉搜索树的的公共祖先
    public TreeNode QlowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < root.val && q.val < root.val){
            return QlowestCommonAncestor1(root.left, p, q);
        }
        else if (p.val > root.val && q.val > root.val){
            return QlowestCommonAncestor1(root.right,p, q);
        }
        else
            return root;
    }
    public TreeNode QlowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q){
        while(root != null){
            if (p.val < root.val && q.val < root.val){
                root = root.left;
            }
            else if(p.val > root.val && q.val > root.val){
                root = root.right;
            }
            else{
                return root;
            }
        }
        return null;
    }

    //完全二叉树
    boolean isCompleteTree(TreeNode root){
        if (root == null){
            return true;

        }
        //1、找第一个不饱和结点（层序）
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean isLeaf = false;
        while(!q.isEmpty()){
            TreeNode cur = q.poll();
            if (isLeaf){
                //从第一个不饱和结点之后，所有的结点不能有孩子
                if (cur.left!=null||cur.right!=null){
                    return false;
                }
            }
            else{
                if (cur.right!=null && cur.left!=null){
                    q.offer(cur.left);
                    q.offer(cur.right);
                }
                else if(cur.left!=null){
                    q.offer(cur.left);
                    isLeaf = true;

                }
                else if(cur.right != null){
                    return false;
                }
                else{
                    //叶子结点
                    isLeaf = true;
                }
            }

        }
        return true;

    }
    //根据一棵树的前序遍历与中序遍历构造二叉树
    class Solution {
        int index = 0;
        private TreeNode reBuildTree(int[] preorder,int[] inorder,int left,int right){
            if(left >= right || index >= preorder.length){
                return null;
            }

            //在中序遍历中找根的位置
            int inrootIdx  = left;
            while(inrootIdx < right){
                if(inorder[inrootIdx] == preorder[index]){
                    break;
                }
                inrootIdx++;
            }

            TreeNode root = new TreeNode(preorder[index]);
            index++;
            root.left = reBuildTree(preorder,inorder, left,inrootIdx);
            root.right = reBuildTree(preorder,inorder,inrootIdx+1,right);
            return root;

        }
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return  reBuildTree(preorder,inorder,0,preorder.length);
        }
    }
    //根据一棵树的中序遍历与后序遍历构造二叉树
//    class Solution {
//        int index = 0;
//        private TreeNode buildTree(int[] inorder,int left,int right,int[] postorder){
//            if(index < 0 || left >= right){
//                return null;
//            }
//            int rootIdx = left;
//            while(rootIdx < right){
//                if(inorder[rootIdx] == postorder[index]){
//                    break;
//                }
//                rootIdx++;
//            }
//
//            TreeNode root = new TreeNode(postorder[index]);
//            --index;
//            root.right = buildTree(inorder,rootIdx+1,right,postorder);
//            root.left = buildTree(inorder, left,rootIdx,postorder);
//            return root;
//
//        }
//        public TreeNode buildTree(int[] inorder, int[] postorder) {
//            index = postorder.length-1;
//            return buildTree(inorder,0,inorder.length,postorder);
//        }
//    }
    public static void main(String[] args) {
//        int [] array = {1,2,3,-1,-1,-1,4,5,-1,-1,6,-1,-1};
////
////        TestDemo t = new TestDemo(array,-1); Pair<Integer, String> pair = new MutablePair<>(3, "Three");

//        TestDemo testDemo= new TestDemo();
//        testDemo.preOrder();
//        testDemo.inOrder();
//        testDemo.postOrder();
//  //      testDemo.getNodeCount();
//        testDemo .getLeafCount();
//        System.out.println(testDemo.getKNodeCount(3));
//        System.out.println(testDemo.getHeight());


    }
}
