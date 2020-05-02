
import java.util.*;

/**
 * @ClassName TestDemo
 * @Description TODO
 * @Author DELL
 * @Data 2020/2/7 12:18
 * @Version 1.0
 **/

/**
 * 队列的最大值
 * 利用双端队列
 */
class MaxQueue {

    Queue<Integer> q;
    Deque<Integer> d;
    public MaxQueue() {
        q= new LinkedList<>();
        d = new LinkedList<>();
    }

    public int max_value() {
        return d.size()>0?d.peek():-1;
    }

    public void push_back(int value) {
        q.add(value);
        while(d.size()> 0 && d.peekLast() < value ){
            d.pollLast();
        }
        d.add(value);
    }

    public int pop_front() {
        int m= q.size()==0 ? -1: q.poll();
        if(d.size() > 0 && d.peek() == m){
            d.poll();
        }
        return m;
    }
}

/**
 * 两个栈实现队列
 */
class CQueue {

    Stack<Integer> s1 ;
    Stack<Integer> s2;
    int size;
    public CQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
        size = 0;
    }

    public void appendTail(int value) {
        s1.push(value);
        size++;
    }

    public int deleteHead() {
        if(size == 0){
            return -1;
        }
        if(s2.empty()){
            while(!s1.empty()){
                s2.push(s1.pop());
            }

        }
        size--;
        return s2.pop();
    }
}

class Student{
    String name;
    int score;
    public Student(String name,int score){
        this.name = name;
        this.score = score;
    }
}

// class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;
//     TreeNode(int x) {
//         val = x;
//     }
// }
public class TestDemo {


    /**
     * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
     * 一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法
     * 输入: 12258
     * 输出: 5
     * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
     *
     *
     * 利用动态规划
     * dp[i] = dp[i-1]+dp[i-2]
     * dp[i] = dp[i-1]
     */
    public int translateNum(int num) {
        String s = String.valueOf(num);
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2;i <= s.length();i++){
            int a = Integer.parseInt(s.substring(i-2,i));
            if(a >= 10 && a <= 25){
                dp[i] = dp[i-1]+dp[i-2];
            }else{
                dp[i] = dp[i-1];
            }
        }
        return dp[s.length()];


        // String s = String.valueOf(num);
        // int a = 1, b = 1;
        // for(int i = 2; i <= s.length(); i++) {
        //     String tmp = s.substring(i - 2, i);
        //     int c = tmp.compareTo("10") >= 0 && tmp.compareTo("25") <= 0 ? a + b : a;
        //     b = a;
        //     a = c;
        // }
        // return a;

    }

    /**
     * 统计一个数字在排序数组中出现的次数。
     * 输入: nums = [5,7,7,8,8,10], target = 8
     * 输出: 2
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int left = 0,right = nums.length-1;
        while(left <= right){
            int mid=(left+right)>>1;
            if(nums[mid] <= target) left = mid+1;
            else right = mid-1;
        }
        int end = left;
        left=0;
        right = nums.length-1;
        while(left<=right){
            int m = (left+right)>>1;
            if(nums[m] <target) left=m+1;
            else right = m-1;
        }
        int start = right;
        return end - start - 1;
    }

    /**
     * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
     * @param s
     * @return
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     */
    public int lengthOfLongestSubstring(String s) {
        
        //滑动窗口
        Set<Character> set = new HashSet<>();
        int left =0,right = 0,max = 0;
        while(right < s.length()){
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            right++;
            max = Math.max(right-left,max);//寻找最大滑动窗口
        }
        return max;
    }


    /**
     * 快乐数「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，
     * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。如果 可以变为  1，那么这个数就是快乐数
     输入：19
     输出：true
     解释：
     12 + 92 = 82
     82 + 22 = 68
     62 + 82 = 100
     12 + 02 + 02 = 1
     * @param n
     * @return
     */
    private int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }
    public boolean isHappy(int n) {
        //利用链表找环
        int slow = n, fast = getNext(n);
        while (fast != 1 && slow != fast){
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        };
        return fast == 1;

        // Set<Integer> seen = new HashSet<>();
        // while (n != 1 && !seen.contains(n)) {
        //     seen.add(n);
        //     n = getNext(n);
        // }
        // return n == 1;
    }



    //圆圈中最后剩下的数字，约瑟夫环问题
    public int lastRemaining(int n, int m) {
        List<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int idx = 0;
        while (n > 1) {
            idx = (idx + m - 1) % n;
            list.remove(idx);
            n--;
        }
        return list.get(0);
    }

    /**
     * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
     * @param prices
     * @return输入: [7, 1, 5, 3, 6, 4]
     * 输出: 5
     * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格
     */
    public int maxProfit(int[] prices) {
        int cost = Integer.MAX_VALUE, profit = 0;
        for(int price : prices) {
            cost = Math.min(cost, price);
            profit = Math.max(profit, price - cost);
        }
        return profit;

        // if(prices.length == 0) return 0;
        // int[] dp = new int[prices.length];
        // int min = prices[0];//保存最小的值
        // dp[0]=0;
        // for(int i = 1;i < prices.length;i++){
        //     min = Math.min(min,prices[i]);
        //     dp[i] =Math.max(dp[i-1],prices[i] - min);
        // }
        // return dp[prices.length-1];

    }

    /**
     * 我们把只包含因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
     * @param n
     * @return
     * 输入: n = 10
     * 输出: 12
     * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
     */
    public static int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int i = 1;
        int a = 0,b = 0, c = 0;
        while(i < n){
            int n2 = dp[a]*2;
            int n3 = dp[b]*3;
            int n5 = dp[c]*5;
            dp[i] = Math.min(Math.min(n2,n3),n5);
            if(dp[i] == n2) a++;
            if(dp[i] == n3) b++;
            if(dp[i] == n5) c++;
            i++;
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(10));
    }


    /**输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
     * 假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈的压栈序列，
     * 序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列
     *输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
     * 输出：true
     *
      * @param pushed
     * @param popped
     * @return
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        //创建一个栈来模拟
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for(int num:pushed){
            stack.push(num);
            while(!stack.isEmpty() && stack.peek()==popped[i]){
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }



    /**373
     * 给定两个以升序排列的整形数组 nums1 和 nums2, 以及一个整数 k。
     *
     * 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2。
     *
     * 找到和最小的 k 对数字 (u1,v1), (u2,v2) ... (uk,vk)。
     输入: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
     输出: [1,2],[1,4],[1,6]
     解释: 返回序列中的前 3 对数：
     [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
     * @param nums2
     * @param k
     * @return
     */
//    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
//        // 大顶堆，比较器使用lambda表达式，更简洁
//        PriorityQueue<List<Integer>> queue = new PriorityQueue<>(k, (o1, o2)->{
//            return (o2.get(0) + o2.get(1)) - (o1.get(0) + o1.get(1));
//        });
//
//        // 遍历所有可能的集合
//        for(int i = 0; i < Math.min(nums1.length, k); i++){
//            for(int j = 0; j < Math.min(nums2.length, k); j++){
//                // 剪枝，如果当前的两个数之和超过了堆顶元素，由于数组已经排序，后面的元素只会更大，因此无需继续遍历
//                if(queue.size() == k && nums1[i]+nums2[j] > queue.peek().get(0) + queue.peek().get(1)){
//                    break;
//                }
//
//                // 若比堆顶小，则弹出堆顶元素，把当前数对加入
//                if(queue.size() == k){
//                    queue.poll();
//                }
//                List<Integer> pair = new ArrayList<>();
//                pair.add(nums1[i]);
//                pair.add(nums2[j]);
//                queue.add(pair);
//            }
//        }
//
//        // 最后将元素弹出，倒序插入数组即可
//        List<List<Integer>> res = new LinkedList<>();
//        for(int i =0; i < k && !queue.isEmpty(); i++){
//            res.add(0, queue.poll());
//        }
//        return res;


//    public TreeNode mirrorTree(TreeNode root) {
//        if(root == null) return root;
//        TreeNode tmp = root.left;
//        root.left = mirrorTree(root.right);
//        root.right = mirrorTree(tmp);
//        return root;

        //辅助栈法
//        Stack<TreeNode> stack = new Stack<>();
//        stack.push(root);
//        while(!stack.isEmpty()){
//            TreeNode node = stack.pop();
//            if(node.left != null) stack.push(node.left);
//            if(node.right != null) stack.push(node.right);
//            TreeNode tmp1 = node.left;
//            node.left = node.right;
//            node.right = tmp1;
//        }
//        return root;
//
//    }


//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//
//        while (in.hasNext()) {
//            int num = in.nextInt();
//            int style = in.nextInt();
//            List<Student> l = new ArrayList<>();
//            for (int i = 0; i < num; i++) {
//                String name = in.next();
//                int score = in.nextInt();
//                l.add(new Student(name, score));
//            }
//            //升序
//            if (style == 0) {
//                Collections.sort(l, new Comparator<Student>() {
//                    public int compare(Student o1, Student o2) {
//                        return o2.score - o1.score;
//                    }
//                });
//            }
//            //降序
//            if (style == 1) {
//                Collections.sort(l, new Comparator<Student>() {
//                    public int compare(Student o1, Student o2) {
//                        return o1.score - o2.score;
//                    }
//                });
//            }
//            for (int i = 0; i < l.size(); i++) {
//                System.out.println(l.get(i).name + " " + l.get(i).score);
//            }
//        }
//    }



//    private static List<String> res = new LinkedList<>();
//    private static char[] c;
//    protected static String[] permutation(String s) {
//        c = s.toCharArray();
//        dfs(0);
//        return res.toArray(new String[res.size()]);
//    }
//
//    private static void dfs(int x) {
//        if(x == c.length - 1) {
//            res.add(String.valueOf(c)); // 添加排列方案
//            return;
//        }
//        HashSet<Character> set = new HashSet<>();
//        for(int i = x; i < c.length; i++) {
//            if(set.contains(c[i])) continue; // 重复，因此剪枝
//            set.add(c[i]);
//            swap(i, x); // 交换，将 c[i] 固定在第 x 位
//            dfs(x + 1); // 开启固定第 x + 1 位字符
//            swap(i, x); // 恢复交换
//        }
//    }
//    private static void swap(int a, int b) {
//        char tmp = c[a];
//        c[a] = c[b];
//        c[b] = tmp;
//    }

//    public static void  main(String[] args) {
//        String s ="abc";
//        String[] arr = permutation( s);
//    }



    /**
     *数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
     输入：n = 11
     输出：0
     * @param n
     * @return
     * 1.确定目标数是几位数
     * 2.确定目标数的数值
     * 3.确定返回目标数中的第几位
     */
    public int findNthDigit(int n) {
        if(n < 10){
            return n ;
        }
        n--;
        int num = 1;//位数
        long first  = 1;
        //寻找当前范围的第n位数
        while(n > 9*first*num){
            n -= 9*first*num;
            num++;
            first*=10;
        }
        return String.valueOf(first+n/num).charAt(n%num)-'0';
    }




    /**
     *
     * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。
     * 如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
     * @param postorder
     * @return
     */
    public boolean verifyPostorder(int[] postorder) {
        Stack<Integer> s = new Stack<>();
        int root = Integer.MAX_VALUE;
        //从数组最后面进行访问
        for(int i = postorder.length-1; i>=0; i--){
            if(postorder[i] > root){
                return false;
            }
            while(!s.isEmpty() && s.peek() > postorder[i] ){
                root = s.pop();
            }
            s.push(postorder[i]);
        }
        return true;
    }



    /**
     * 数值的整数次方
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if(x == 0) return 0;
        long b = n;//int 变量会因为负数而产生错误，因而转换为long类型
        double result = 1.0;
        if(b < 0){
            x = 1/x;
            b = -b;
        }
        while(b > 0){
            //利用二进制进行计算
            if((b & 1) == 1) result*= x;
            x*=x;
            b >>= 1;
        }
        return result;
    }



    /**
     *
     * @param s
     * @param numRows
     * @return
     * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行Z字形排列。
     *
     * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
     *
     * L   C   I   R
     * E T O E S I I G
     * E   D   H   N
     * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
     */
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        List<StringBuffer> rows = new ArrayList<>();
        //新建numRows个StringBuffer()对象
        for(int i = 0;i < numRows;i++){
            rows.add(new StringBuffer());
        }
        int i = 0,flg = -1;
        for(char c : s.toCharArray()){
            rows.get(i).append(c);
            if(i == 0 || i == numRows-1){
                flg = -flg;
            }
            i+=flg;
        }
        StringBuffer res = new StringBuffer();
        for(StringBuffer str : rows){
            res.append(str);
        }
        return res.toString();
    }


    /**
     *
     * @param target
     * @return
     * 算法：按照n+ n+1 + n+2 = targer
     * 最开始按照两个数字的数组进行考虑，依次滴加
     */
    public int[][] findContinuousSequence(int target) {
        List<int[]> list = new ArrayList<>();
        int i = 1;
        while(target > 0 ){

            //第一次就是两个数
            target-=i;
            i++;
            if(target > 0 && target % i==0){
                int[] arr = new int[i];
                for(int star=target/i,q=0;star<target/i+i;star++,q++) {
                    arr[q]=star;
                }
                list.add(arr);
            }
        }
        Collections.reverse(list);
        return list.toArray(new int[0][]);

    }


    /**
     * 罗马数字转化为十进制数字
     */
    private static final int[] mapping = new int[256];
    static {
        mapping['I'] = 1;
        mapping['V'] = 5;
        mapping['X'] = 10;
        mapping['L'] = 50;
        mapping['C'] = 100;
        mapping['D'] = 500;
        mapping['M'] = 1000;
    }
    public static int romanInt(String s){
        int n = s.length();
        int result = mapping[s.charAt(n-1)];

        for (int i = n-2; i >= 0; --i) {
            int cur = mapping[s.charAt(i)];
            int right = mapping[s.charAt(i+1)];
            if (cur < right) result -= cur;
            else result += cur;
        }
        return result;
    }





    /**
     * 二维矩阵的旋转
     *
     *
     *
     *
     *
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 ||
                matrix[0] == null || matrix[0].length == 0)
            return;
        int n = matrix.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i; j < n; ++j) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n/2; ++j) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = tmp;
            }
        }

    }



    /**
     * 字母异位词分组
     * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
     * 输出:
     * [
     *   ["ate","eat","tea"],
     *   ["nat","tan"],
     *   ["bat"]
     * ]
     * @param s
     * @return
     */
    private static String getKeyBySort(String s){
        char[] c = s.toCharArray();
        Arrays.sort(c);
        return new String(c);
    }
    private static String getKeyCount(String s){
        char[] c = new char[26];
        for(int i = 0;i < s.length();i++){
            c[s.charAt(i) - 'a'] ++;
        }
        return new String(c);
    }
    public static List<List<String>> groupAnagrams(String[] strs){
        if(strs == null || strs.length ==0){
            return new ArrayList<>();
        }
        Map<String,List<String>> map = new HashMap<>();
        for(String s:strs){
            String key = getKeyBySort(s);
            //如果指定的键尚未与某个值相关联（或映射到 null ），则将其与给定值相关联并返回 null ，否则返回当前值
            map.putIfAbsent(key,new ArrayList<>());
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }





    /**
     * 跳跃游戏
     * @param nums
     * @return
     * max代表最大位置的下标，不断更新max的值
     */
    public boolean canJumpToLast(int[] nums){
        if(nums.length == 0 || nums == null){
            return false;
        }
        int max  = 0;//代表可以跳到的最大位置的下标
        for(int i = 0;i < nums.length;i++){
            if(max >= nums.length-1) return true;
            if(max < i) return false;
            //更新max位置
            max = Math.max(max,i+nums[i]);
        }
        return false;
    }




    /**
     *在显示着数字的坏计算器上，我们可以执行以下两种操作：
     *
     * 双倍（Double）：将显示屏上的数字乘 2；
     * 递减（Decrement）：将显示屏上的数字减 1 。
     * 最初，计算器显示数字 X。
     *
     * 返回显示数字 Y 所需的最小操作数
     输入：X = 2, Y = 3
     输出：2
     解释：先进行双倍运算，然后再进行递减运算 {2 -> 4 -> 3}.
     * @param Y
     * @return
     * 方法：逆向思维
     * 思路
     *
     * 除了对 X 执行乘 2 或 减 1 操作之外，我们也可以对 Y 执行除 2（当 Y 是偶数时）或者加 1 操作。
     *
     * 这样做的动机是我们可以总是贪心地执行除 2 操作：
     *
     * 当 Y 是偶数，如果先执行 2 次加法操作，再执行 1 次除法操作，我们可以通过先执行 1 次除法操作，
     * 再执行 1 次加法操作以使用更少的操作次数得到相同的结果 [(Y+2) / 2 vs Y/2 + 1]。
     *
     * 当 Y 是奇数，如果先执行 3 次加法操作，再执行 1 次除法操作，
     * 我们可以将其替代为顺次执行加法、除法、加法操作以使用更少的操作次数得到相同的结果 [(Y+3) / 2 vs (Y+1) / 2 + 1]。
     *
     * 算法
     *
     * 当 Y 大于 X 时，如果它是奇数，我们执行加法操作，否则执行除法操作。之后，我们需要执行 X - Y 次加法操作以得到 X
     */

    public int brokenCalc(int X, int Y) {
        int ans = 0;
        while (Y > X) {
            ans++;
            if (Y % 2 == 1)
                Y++;
            else
                Y /= 2;
        }
        return ans + X - Y;
    }




    /**
     * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
     * @param nums
     * @return
     * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
     * 输出: 2
     */

    public int majorityElement(int[] nums) {
//        int x = 0, votes = 0;
//        for(int num : nums){
//            if(votes == 0) x = num;
//            votes += num == x ? 1 : -1;
//        }
//        return x;

         Map<Integer,Integer> map = new HashMap<>();
         int count = 0;
         int i=0 ;
         for(int x:nums){
             if(map.containsKey(x)){
                 map.put(x,map.getOrDefault(x,0)+1);
             }else{
                 map.put(x,1);
             }
             count++;
         }
         for(;i < count;i++){
             if(map.get(nums[i]) > (count>>1)){
                 break;
             }
         }
         return nums[i];
    }



    /**
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词
     * @param s
     * @param t
     * @return
     * 输入: s = "anagram", t = "nagaram"
     * 输出: true
     *
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        Map<Character, Integer> charMap1 = new HashMap<>((int) (s.length() / 0.75F + 1.0F));
        Map<Character, Integer> charMap2 = new HashMap<>((int) (s.length() / 0.75F + 1.0F));
        for (char c : s.toCharArray())
            charMap1.put(c, charMap1.getOrDefault(c, 0) + 1);
        for (char c : t.toCharArray())
            charMap2.put(c, charMap2.getOrDefault(c, 0) + 1);
        if (charMap1.size() != charMap2.size())
            return false;
        for (char c : s.toCharArray()) {
            if (!charMap1.get(c).equals(charMap2.getOrDefault(c, 0))) {
                return false;
            }
        }
        return true;


        // if(s.length()==t.length()){

        //     int[] counter = new int[26];
        //     for(int i = 0;i < s.length();i++){
        //         counter[s.charAt(i)-'a']++;
        //         counter[t.charAt(i)-'a']--;
        //     }
        //     for(int num:counter){
        //         if(num != 0){
        //             return false;
        //         }
        //     }
        //     return true;
        // }
        // return false;

        //    if(s.length()!=t.length())
        //         return false;
        //     else{
        //         char[] s1=s.toCharArray();
        //         char[] s2=t.toCharArray();
        //         Arrays.sort(s1);
        //         Arrays.sort(s2);
        //         return Arrays.equals(s1,s2);
        //     }
    }



    /**
     * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
     * 输入: [10,2]
     * 输出: "102"
     *
     * 输入: [3,30,34,5,9]
     * 输出: "3033459"
     * @param nums
     * @return
     */
    public String minNumber(int[] nums) {
        String[] str = new String[nums.length];
        for(int i = 0;i < nums.length;i++){
            str[i] = nums[i]+"";
        }
        Arrays.sort(str,(s1,s2)->(s1+s2).compareTo(s2+s1));
        String ret = "";
        for(String s : str){
            ret+=s;
        }
        return ret;


    }





    /**
     * 给一非空的单词列表，返回前 k 个出现次数最多的单词。
     * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
     *
     * @param words 字符串数组
     * @param k
     * @return
     *
     * 输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
     * 输出: ["i", "love"]
     * 解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
     *     注意，按字母顺序 "i" 在 "love" 之前。
     */
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> m = new HashMap<>();
        for(String s:words){
            m.put(s,m.getOrDefault(s,0)+1);
        }
        PriorityQueue<String> p = new PriorityQueue<>(new Comparator<String>(){
            public int compare(String a,String b){
                if(m.get(a) == m.get(b)){
                    return a.compareTo(b);
                }
                return m.get(b) - m.get(a);
            }
        });
        //将字符串入队列
        for(String s : m.keySet()){
            p.add(s);
        }
        List<String> l = new ArrayList<>();
        for(int i = 0;i < k;i++){
            l.add(p.poll());
        }
        return l;
    }

    /**
     * 最小的数
     */
    public static void minNum() {
        Scanner in = new Scanner(System.in);
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = in.nextInt();
        }
        if (arr[0] != 0) {
            for (int i = 1; i < 10; i++) {
                if (arr[i] != 0) {
                    System.out.print(i);
                    arr[i]--;
                    break;
                }
            }
        }
        for (int j = 0; j < 10; j++) {
            if (arr[j] != 0) {
                for (int k = 0; k < arr[j]; k++) {
                    System.out.print(j);
                }
            }
        }
        System.out.println();
    }

//    public static void main(String[] args) {
//        minNum();
//    }


    /**
     * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
     * 输入：nums = [3,4,3,3]
     * 输出：4
     *
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        Map<Integer,Boolean> h = new HashMap<>();
        for( int n : nums){
            //如果不包含映射，则添加映射
            if(!h.containsKey(n)){
                h.put(n,!h.containsKey(n));
            }
            else{
                h.put(n,!h.containsKey(n));
            }
        }
        for(int n : nums){
            if(h.get(n) == true){
                return n;
            }
        }
        return -1;
    }


    /**
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，
     * 输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。 
     */
    public int minArray(int[] numbers) {
        int i = 0;
        int j = numbers.length-1;
        while(i < j){
            int m = (i + j)>>1;
            //从右边序列找
            if(numbers[m] > numbers[j]){
                i=m+1;
            }
            else if(numbers[m] < numbers[j]){
                j=m;
            }
            else{
                j-=1;
            }
        }
        return numbers[i];
    }


    /**
     *
     * @param nums 数组
     * @return 数组中任意个重复的数字
     */

    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        int repeat = -1;
        for (int num : nums) {
            if (!set.add(num)) {
                repeat = num;
                break;
            }
        }
        return repeat;
    }


    /**
     *
     * @param
     * @param  数组中含的数字个数
     * @return 各个数组中的最大值
     *采用双队列，存储下标，最左侧代表的是最大值的下标
     * /

    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return new int[0];
        }
        int[] arr = new int[nums.length - k + 1];
        Deque<Integer> queue = new ArrayDeque<>();
        for(int i = 0, j = 0; i < nums.length; i++) {
            if(!queue.isEmpty() && i - queue.peek() >= k) {
                queue.poll();
            }
            while(!queue.isEmpty() && nums[i] > nums[queue.peekLast()]) {
                queue.pollLast();
            }
            queue.offer(i);
            if(i >= k - 1) {
                arr[j++] = nums[queue.peek()];
            }
        }
        return arr;

    }




    /**
     *
     * @param grid,二维数组中放置礼物
     * @return 礼物的最大值
     * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
     */
    public int maxValue(int[][] grid) {
        int m = grid.length;//行
        int n = grid[0].length;//列
        for(int i = 0 ;i < m;i++){
            for(int j = 0;j < n;j++){
                if(i == 0 && j ==0){
                    continue;
                }
                else if(i==0) {
                    grid[i][j] += grid[i][j-1];
                }
                else if(j==0){
                    grid[i][j] += grid[i-1][j];
                }else{
                    grid[i][j] += Math.max(grid[i-1][j],grid[i][j-1]);
                }
            }
        }
        return grid[m-1][n-1];
    }
    //剪绳子
    public static int cuttingRope(int n) {
        if (n < 2) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(Math.max(j * dp[i - j], j * (i - j)), dp[i]);
            }
        }
        return dp[n];
    }
//    public static void main(String[] args) {
//        int n=8;
//        System.out.println(cuttingRope(n));
//
//    }

}




////    //返回相同位置上相同的数字的个数
////   public static int cmp(int x, int y){
////        int res = 0;
////        for(int i = 0;i < 4; i++){
////            if( x % 10 == y % 10)  res++;
////            x /= 10;
////            y /= 10;
////        }
////        return res;
////    }
////    //返回两个数相同的数字的个数
////   public static int  cmp1(int x, int y){
////        int num=0;
////        int[] a=new int[4];
////        int[] b=new int[4];
////        for (int i = 0; i < 4 ; i++) {
////            a[i] = x % 10;
////            x /= 10;
////        }
////        for (int j = 0; j < 4 ; j++) {
////            b[j] = y % 10;
////            y /= 10;
////        }
////        for (int i = 0; i < 4; i++) {
////            for (int j = 0; j < 4 ; j++) {
////                if(a[i] == b[j]){
////                    b[j] = -1;
////                    num++;
////                    break;
////                }
////            }
////        }
////        return num;
////   }
////
////   public static void main(String[] args) {
////        Scanner sc = new Scanner(System.in);
////        int n = sc.nextInt();
////        int[] book = new int[10000];
////        while (n > 0){
////            for (int i = 0; i < n ; i++) {
////                Scanner sc1 = new Scanner(System.in);
////                int num = sc1.nextInt();
////                int p = sc1.nextInt();//猜对了几个数字
////                int q = sc1.nextInt();//几个数字在正确的位置上
////                for (int j = 1000; j < 10000 ; j++) {
////
////                    if (cmp(j ,num) != q ) book[j]=1;
////                    if (cmp1(j,num) != p) book[j]=1;
////                }
////            }
////
////            int a=0,res=0;
////            for (int i = 1000; i < 10000 ; i++) {
////                if(book[i] != 1){
////                    a++;
////                    res = i;
////                }
////                if (a >= 2){
////                    break;
////                }
////            }
////            if (a != 1){
////                System.out.println("Not sure");
////            }
////            else{
////                System.out.println(res);
////            }
////        }
////   }
////}
//
//////    static int f(int n) {
//////        //1 1 1 2 3 4 6 9 13  19 28  41 60  就是这样  多理解找规律。
//////
//////        if (n <= 4) {        //当年份小于4时，即 1、2、3年，牛都是一头
//////            return n;
//////        } else {
//////           return f(n - 1) + f(n - 3);
//////        }
//////    }
////
////    public static void main(String[] args) {
////
////        int count = 5;
////        for (int i = 0;i < count; i++){
////            count ++;
////        }
////    }
////}
//
////class Teacher{
//////    private  static int count = 0;
//////
//////    public Teacher() {
//////        count++;
//////    }
//////    public  int getCount() {
//////        return count;
//////    }
//////}
//////public class TestDemo {
//////    public static void main(String[] args) {
//////        Teacher t1 = new Teacher();
//////        Teacher t2 = new Teacher();
//////        System.out.println(t2.getCount());
//////    }
//////}
//public class TestDemo{
//
//    public int mid(String s ,int left,int right){
//        int size = s.length();
//        while(left>=0 && right < size && s.charAt(left)==s.charAt(right)){
//            left--;//向左
//            right++;//向右进行扩散
//        }
//        return right - left - 1;
//    }
//    public String longestPalindrome(String s) {
//        if(s == null||s.length() < 1)
//            return "";
//        int left = 0,right = 0;
//        for(int i = 0;i < s.length();i++){
//            int len1 = mid(s,i,i);
//            int len2 = mid(s,i,i+1);
//            int len = Math.max(len1,len2);
//            if(len > right - left){
//                left = i - (len - 1)/2;
//                right = i + len/2;
//            }
//        }
//        return s.substring(left,right+1);
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String str =  sc.nextLine();
//
//    }


    /**
     *
     * @param num(判断是否h是完全平凡数)
     * @return
     */

//    public boolean isPerfectSquare(int num) {
//        // double i = 1;
//        // while(i * i < num) {
//        //     i++;
//        // }
//        // return i * i == num;
//
//        //数学公式
//        // int i = 1;
//        // while(num > 0){
//        //     num -= i;
//        //     i += 2;
//        // }
//        // return num==0;
//
//
//        //利用二分法
//        if(num ==1){
//            return true;
//        }
//        long left = 2, right = num >>1, x, guessSquared;
//        while (left <= right) {
//            x = left + ((right - left) >>1);
//            guessSquared = x * x;
//            if (guessSquared == num) {
//                return true;
//            }
//            if (guessSquared > num) {
//                right = x - 1;
//            } else {
//                left = x + 1;
//            }
//        }
//        return false;
//    }

    /**
     * 只出现一次的数据
     * @param nums
     * @return
     */
//    public int singleNumber(int[] nums) {
//
//    HashMap<Integer, Integer> hashmap = new HashMap<>();
//    for (int num : nums)
//        hashmap.put(num, hashmap.getOrDefault(num, 0) + 1);
//
//    for (int k : hashmap.keySet())
//        if (hashmap.get(k) == 1) return k;
//    return -1;
//
//}

    /**
     *
     * @param haystack
     * @param needle
     * 给定一个 haystack 字符串和一个 needle 字符串，
     * 在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
     *
     */
//
//    public int strStr(String haystack, String needle) {
//        if (needle == null) {
//            return 0;
//        }
//        // int hsize = haystack.length();
//        // int nsize = needle.length();
//
//        // for(int i = 0; i <= hsize-nsize;i++){
//        //     int j =0;
//        //     for(;j < nsize;j++){
//        //         if(haystack.charAt(i+j)!=needle.charAt(j)){
//        //             break;
//        //         }
//        //     }
//        //     if(j==nsize){
//        //         return i;
//        //     }
//        // }
//        // return -1;
//        return haystack.indexOf(needle);
//
//    }
//}




//    /**
//     *数组中数字出现的次数
//     * 输入：nums = [4,1,4,6]
//     * 输出：[1,6] 或 [6,1]
//     */
//    public int[] singleNumbers(int[] nums) {
//        Set<Integer> set = new HashSet<>(nums.length);
//        int[] arr = new int[nums.length];
//        int index = 0;
//        for (int x: nums) {
//            if (set.contains(x)){
//                set.remove(x);
//            }
//            else{
//                set.add(x);
//            }
//        }
//        return set.stream().mapToInt(Integer::intValue).toArray();
//
//    /**
//     * 统计回文数的个数
//     */
////    public static boolean isHuiwen(String s){
////        int i = 0;
////        int j = s.length()-1;
////        while(i<j){
////            if(s.charAt(i)!=s.charAt(j)){
////                return false;
////            }
////            i++;
////            j--;
////        }
////        return true;
////    }
////    public static void main(String[] args) {
////        Scanner sc = new Scanner(System.in);
////        String str1 = sc.nextLine();
////        String str2 = sc.nextLine();
////        int count = 0;
////        for(int i = 0; i <= str1.length();i++){
////            StringBuilder sb = new StringBuilder(str1);
////            sb.insert(i, str2);
////            if(isHuiwen(sb.toString())){
////                count++;
////            }
////        }
////        System.out.println(count);
////    }
//
//
//    //丑数
//    public boolean isUgly(int num) {
//        if(num <= 0){
//            return false;
//        }
//        while(num%2==0||num%3==0||num%5==0){
//            if(num%2==0){
//                num/=2;
//            }
//            if(num%3==0){
//                num/=3;
//            }
//            if(num%5==0){
//                num/=5;
//            }
//        }
//        return num==1;
//    }
//
//
//
//
//
//
//
//    /**
//     * 输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
//     * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
//     * 输出: 6
//     * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
//     */
//
//
//    class Solution {
//        public int maxSubArray(int[] nums) {
//
//            int res = nums[0];
//            for(int i = 1; i < nums.length; i++) {
//                nums[i] += Math.max(nums[i - 1], 0);
//                res = Math.max(res, nums[i]);
//            }
//            return res;
//        }
//    }

    /**
     * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
     * 输入: n = 12
     * 输出: 3
     * 解释: 12 = 4 + 4 + 4.
     *
     * 利用动态规划：
     * d(12) =min(d(11)+1 ,d(8)+1,d(3)+1)
     */


//    class Solution {
//        public int numSquares(int n) {
//            int[] d = new int[n+1];
//            d[0] = 0;
//            for(int i = 0;i < d.length;i++){
//                d[i] = i;
//                for(int j = 0;j * j <= i;j++){
//                    d[i] = Math.min(d[i], d[i - j*j] + 1);
//                }
//            }
//            return d[n];
//        }
//    }

    /**
     *给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
     * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
     * 输入："23"
     * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
     */
//    class Solution {
//        private final String[] mapping = new String[]{
//                "abc", "def", "ghi", "jkl",
//                "mno", "pqrs", "tuv", "wxyz"
//        };
//        public List<String> letterCombinations(String digits) {
//            LinkedList<String> l = new LinkedList<>();
//            if(digits == null||digits.length()==0){
//                return l;
//            }
//            l.add("");
//            for(int i = 0;i < digits.length();i++){
//                String chars = mapping[digits.charAt(i) - '2'];
//                int size = l.size();
//                for(int j = 0;j <size;j++){
//                    String str = l.poll();//取出队头元素
//                    for (int k = 0; k < chars.length(); ++k) {
//                        l.add(str + chars.charAt(k));
//                    }
//
//                }
//            }
//            return l;
//        }
//    }
//
//    class Solution {
//        private void combSum(int[] nums, int target, int start,
//                             List<Integer> elem, List<List<Integer>> result) {
//            if (target == 0) {
//                result.add(new ArrayList<>(elem));
//                return;
//            }
//            if (target < 0) return;
//            for (int i = start; i < nums.length; ++i) {
//                elem.add(nums[i]);
//                combSum(nums, target-nums[i], i, elem, result);
//                elem.remove(elem.size()-1); // T: O(1)
//            }
//        }
//        public List<List<Integer>> combinationSum(int[] candidates, int target) {
//            List<List<Integer>> result = new ArrayList<>();
//            List<Integer> elem = new ArrayList<>();
//            combSum(candidates, target, 0, elem, result);
//            return result;
//        }
//    }
//
////    public static void main(String[] args) {
//
//        //读入一个字符串str，输出字符串str中的连续最长的数字串
//
//        /**
//         * 设置三个变量，max(表示最大数字字符的个树),count（计数）,last（记录数字字符的位置）
//         * 如果遇到数字字符，count++
//         * 否则设置count为0
//         */
////            Scanner scanner = new Scanner(System.in);
////            int count=0,last = 0,max = 0;
////            String str = scanner.nextLine();
////            for(int i = 0;i < str.length();i++){
////                if(str.charAt(i) >='0'&&str.charAt(i)<='9'){
////                    count++;
////                }
////                else{
////                    count =0;
////                }
////                if(max < count){
////                    max = count;
////                    last = i;
////                }
////            }
////            System.out.println(str.substring(last-max+1,last+1));
//
//
////    }
//}
