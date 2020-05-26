package TreeNode;

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
public class Main {

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
