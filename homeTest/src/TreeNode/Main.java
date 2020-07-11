package TreeNode;


import javax.print.attribute.standard.Sides;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName Main
 * @Description TODO
 * @Author DELL
 * @Data 2020/5/19 21:11
 * @Version 1.0
 **/
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}
public class Main {
    /**
     * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径,将符合的路径打印出来
     *
     */
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> cur = new ArrayList<>();
    private void dfs1(TreeNode root,int sum){
        if(root == null) return;
        cur.add(root.val);
        if(root.left == null && root.right == null) {
            if(sum == root.val) {
                List<Integer> l = new ArrayList<>(cur);
                res.add(l);
            }
        }
        dfs(root.left,sum - root.val);
        dfs(root.right,sum - root.val);
        cur.remove(cur.size()-1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root,sum);
        return res;
    }

    /**
     * 路径总和：给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，
     * 这条路径上所有节点值相加等于目标和
     *
     * 思想一：利用递归的思想，先序遍历
     * 思想二：；利用队列的思想
     */
    boolean flg = false;
    private void dfs(TreeNode root,int sum){
        if(root == null) return;
        //判断是否为叶子结点，只有在叶子结点才能进行判断
        if(root.left == null && root.right == null) {
            if(sum == root.val) flg = true;
        }
        dfs(root.left,sum - root.val);
        dfs(root.right,sum - root.val);
    }
    public boolean hasPathSum1(TreeNode root, int sum) {
        if(root == null) return false;
        dfs(root,sum);
        return flg;
    }
    public boolean hasPathSum2(TreeNode root, int sum) {
        if(root == null ) return false;
        Queue<TreeNode> q1 = new LinkedList<TreeNode>();
        Queue<Integer> q2 = new LinkedList<>();
        q1.add(root);
        q2.add(root.val);
        while(!q1.isEmpty()) {
            TreeNode node = q1.poll();
            int val = q2.poll();
            if(node.left == null && node.right == null) {
                if(val == sum) return true;
            }
            if(root.left != null){
                q1.add(root.left);
                q2.add(val+root.left.val);
            }
            if(root.right != null) {
                q1.add(root.right);
                q2.add(val+root.right.val);
            }
        }
        return false;
    }

    /**
     * 层序遍历
     * [
     *   [3],
     *   [9,20],
     *   [15,7]
     * ]
     * 利用队列先进先出的特点
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        if(root == null) return list;
        q.add(root);
        while(!q.isEmpty()){

            int size = q.size();
            List<Integer> l = new LinkedList<>();
            for(int i = 0; i < size;i++) {
                TreeNode node = q.poll();
                l.add(node.val);
                if (node.left != null) {
                    q.add(node);
                }
                if (node.right != null) {
                    q.add(node);
                }
            }
            list.add(l);
        }
        return list;


    }
    /**
     *给你一棵以 root 为根的二叉树和一个 head 为第一个节点的链表。
     * 如果在二叉树中，存在一条一直向下的路径，且每个点的数值恰好一一对应以 head 为首的链表中每个节点的值，
     * 那么请你返回 True ，否则返回 False 。
     * 一直向下的路径的意思是：从树中某个节点开始，一直连续向下的路径
     *输入：head = [4,2,8], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]
     * 输出：true
     * 利用深度优先搜索
     * 1、链表是当前树的子结构
     * 2、链表是当前树左子树的子结构
     * 3、链表是当前树右子树的子结构
     */
    public boolean isSubPath(ListNode head, TreeNode root) {
        if(root == null) return true;
        if(head == null) return false;
        //找到链表头结点和根节点相同的结点
        if(head.val == root.val){
            //进行判断，往下递归
            return isHeadPath(head.next,root.left)||isHeadPath(head.next,root.right)
                    ||isSubPath(head,root.left)||isSubPath(head,root.right);//继续左子树，右子树进行判断
        }else{
            return isSubPath(head,root.right)||isSubPath(head,root.left);
        }
    }
    //进行路径的判断
    private boolean isHeadPath(ListNode next, TreeNode node) {
        if (next == null) return true;
        if (node == null) return false;
        if(next.val != node.val){
            return false;
        }else{
            return isHeadPath(next.next,node.left)||isHeadPath(next.next,node.right);
        }
    }


    /**
     *     节点与其祖先之间的最大差值
     * 输入：[8,3,10,1,6,null,14,null,null,4,7,13]
     * 输出：7
     * 解释：
     * 我们有大量的节点与其祖先的差值，其中一些如下：
     * |8 - 3| = 5
     * |3 - 7| = 4
     * |8 - 1| = 7
     * |10 - 13| = 3
     * 在所有可能的差值中，最大值 7 由 |8 - 1| = 7 得出。
     * 深度优先搜索dfs
     */
    int res = Integer.MIN_VALUE;

    public int maxAncestorDiff(TreeNode root) {
        if (root == null) return 0;
        //如果当前节点没有子节点，则直接返回
        helper(root, root.val, root.val);
        return res;
    }

    /**
     * 每条从根节点到叶子节点的路径中的最大值和最小值，并求出差值更新全局变量
     */
    private void helper(TreeNode node, int max, int min) {
        if (node == null) return;
        max = Math.max(node.val, max);
        min = Math.min(node.val, min);
        //到达叶子节点，求最大差值
        if (node.left == null && node.right == null) {
            res = Math.max(res, Math.abs(max - min));
        }
        helper(node.left, max, min);
        helper(node.right, max, min);
    }


    /**
     *删除二叉搜索树中的结点
     * root = [5,3,6,2,4,null,7]
     * key = 3
     */
    public int rightMin(TreeNode root) {//1.找到以某个结点为根节点的右子树最小值。
        root = root.right;
        while (root.left != null) root = root.left;
        return root.val;
    }

    public int leftMax(TreeNode root) {//2.找到以某个结点为根节点的左子树最大值。
        root = root.left;
        while (root.right != null) root = root.right;
        return root.val;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {//3.递归终止条件
            return null;
        }
        if (key > root.val) {//4.如果查找的结点比根节点大，继续在右子树查找删除该结点
            root.right = deleteNode(root.right, key);
        } else if (key < root.val) {//5.如果查找的结点比根节点小，继续在左子树查找删除该结点
            root.left = deleteNode(root.left, key);
        } else {//6.如果找到了该结点，删除它
            if (root.left == null && root.right == null) {//7.以叶子节点为根节点的二叉搜索树只有一个元素，可以直接删除。
                root = null;
            } else if (root.right != null) {//8.如果有右子树，只要找到该右子树的最小值来替换，之后将它删除即可。
                root.val = rightMin(root);
                root.right = deleteNode(root.right, root.val);//9.将这个右子树的最小值替换根节点，此时存在两个相同节点，将这个节点删除即可。
            } else {//10.如果有左子树，只要找到该左子树的最大值来替换，之后将它删除即可。
                root.val = leftMax(root);
                root.left = deleteNode(root.left, root.val);//9.将这个左子树的最大值替换根节点，此时存在两个相同节点，将这个节点删除即可。
            }
        }
        return root;
    }
}
