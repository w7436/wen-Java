/**
 * @ClassName BSTree
 * @Description TODO
 * @Author DELL
 * @Data 2020/4/21 19:45
 * @Version 1.0
 **/
public class BSTree {
    public static class BSTNode {
        BSTNode left = null;
        BSTNode right = null;
        int val;

        public BSTNode(int val) {
            this.val = val;
        }
    }

    private BSTNode root = null;

    //检测val是否在二叉搜索树中
    boolean contains(int val) {
        BSTNode cur = root;
        while (cur != null) {
            if (cur.val == val) return true;
            else if (val < cur.val) cur = cur.left;
            else cur = cur.right;
        }
        return false;
    }

    //插入,保存其双亲(待插入结点的双亲)
    public boolean put(int val) {
        BSTNode cur = root;
        BSTNode parent = null;
        if (cur == null) {
            root = new BSTNode(val);
            return true;
        }
        while (cur != null) {
            parent = cur;//待插入结点的双亲
            if (val == cur.val) return false;
            else if (val < cur.val) cur = cur.left;
            else cur = cur.right;
        }

        cur = new BSTNode(val);
        if(val < parent.val) parent.left = cur;
        else parent.right = cur;
        return true;

    }
    public void inOrder(){
        inOrder(root);
    }
    private void inOrder(BSTNode root){
        if(null != root){
            inOrder(root.left);
            System.out.print(root.val + " ");
            inOrder(root.right);
        }
    }
    public int leftMost(){
        if(root == null );
        BSTNode cur = root;
        while(cur.left != null){
            cur = cur.left;
        }
        return cur.val;
    }

    public int RightMost(){
        if(root == null );
        BSTNode cur = root;
        while(cur.right != null){
            cur = cur.right;
        }
        return cur.val;
    }

    boolean remove(int val){
        if(root == null ) return false;
        BSTNode cur = root;
        BSTNode parent = null;
        while (cur != null){
            if (val == cur.val) break;
            else if (val < cur.val) {
                parent = cur;
                cur = cur.left;
            }
            else {
                parent = cur;
                cur = cur.right;
            }
        }
        //没找到
        if(cur == null) return false;
        //1、只有左孩子
        //2、右孩子
        //3、没有孩子
        //4、都有
        if(cur.left == null){
            if(parent == null){
                //cur根结点
                root = cur.right;
            }else{
                //双亲存在
                if(cur == parent.left){
                    parent.left = cur.right;
                }
                else{
                    parent.right = cur.right;
                }
            }
        }else if(cur.right == null){
            if(parent == null){
                root = cur.left;
            }
            else{
                if(cur == parent.left){
                    parent.left = cur.left;
                }
                else{
                    parent.right = cur.left;
                }
            }
        } else{
            //不能直接时删除，在cur子树中找一个替代结点删除
            //在cur中找一个替代结点删除
            //1、
            BSTNode del = cur.right;
            parent = cur;
            //寻找替代结点
            while(del.left != null){
                parent =del;
                del = del.left;
            }
            cur.val = del.val;

            if(del == parent.left){
                parent.left = del.right;
            }else{
                parent.right = del.right;
            }

        }
        return true;

    }
    public static void main(String[] args) {
        int[] array = {1,4,3,2,6,5,8,7,0,9};
        BSTree t = new BSTree();
        for(int e : array) {
            t.put(e);
        }
        t.remove(3);
        t.inOrder();
        System.out.println();
        System.out.println(t.leftMost());
        System.out.println(t.RightMost());

    }
}
