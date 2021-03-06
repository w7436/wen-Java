
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
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
public class TestDemo {


    /**
     * 汉诺塔
     *  输入：A = [2, 1, 0], B = [], C = []
     *  输出：C = [2, 1, 0]
     */
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        move(A.size(),A, B, C);
    }
    public void move(int n, List<Integer> A, List<Integer> B, List<Integer> C){
        if(n == 1){
            C.add(A.remove(A.size() - 1));
            //注意：题目给的盘子是从大到小给的，所以这里remove的是【A.size() - 1】
            return;
        }
        move(n-1,A,C,B);
        C.add(A.remove(A.size() - 1));
        move(n - 1, B, A, C);
    }
    /**
     * LRU缓存机制
     */
    public int capacity;
    LinkedHashMap<Integer,Integer> cache;
    public void LRUCache(int capacity) {
        this.capacity = capacity;
        //accessOrder - 订购模式 - true的访问顺序， false的插入顺序
        cache = new LinkedHashMap<Integer,Integer> (capacity,0.75f,true){
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest){
                return cache.size() > capacity;
            }
        };
    }
    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }

    /**
     * 求和：
     * 两个整数，m,n
     * 从数列1,2,3，，n中取出几个数数字，使得之和为m，将所有的可能列举出来
     *
     * 思想：深度优先搜索
     */
    public static List<ArrayList<Integer>> res = new ArrayList<>();
    public static ArrayList<Integer> l = new ArrayList<>();
    public static void back(int start,int sum,int target,int n){
        if(sum >= target){
            if(sum == target) res.add(new ArrayList<>(l));
            return;
        }
        for(int i = start ;i  <= n; i++){
            if(i > target) continue;
            l.add(i);
            back(i+1,sum+i,target,n);
            l.remove(l.size()-1);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        back(1,0,m,n);
        for(ArrayList<Integer> l:res){
            for(int i = 0;i < l.size();i++){
                System.out.print(l.get(i));
                if(i != l.size()-1){
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    /**
     * 最后一块石头的重量
     * 每一回合，从中选出两块 最重的 石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
     *
     * 如果 x == y，那么两块石头都会被完全粉碎；
     * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x
     * 输入：[2,7,4,1,8,1]
     * 输出：1
     * 解释：
     * 先选出 7 和 8，得到 1，所以数组转换为 [2,4,1,1,1]，
     * 再选出 2 和 4，得到 2，所以数组转换为 [2,1,1,1]，
     * 接着是 2 和 1，得到 1，所以数组转换为 [1,1,1]，
     * 最后选出 1 和 1，得到 0，最终数组转换为 [1]，这就是最后剩下那块石头的重量
     *
     * 思想：利用队列，将其进行排序，每次取其中最大的两个，进行相减操作，直到长度为0
     */
    public int lastStoneWeight(int[] stones) {

        Queue<Integer> q = new PriorityQueue<Integer>(stones.length,  Collections.reverseOrder());//自然排序的相反

        for (int i = 0; i < stones.length; i ++){
            q.add(stones[i]);
        }

        while (q.size() > 0){
            if (q.size() == 1){
                return q.poll();
            }
            int x = q.poll(), y = q.poll();
            if (x != y){
                q.add(x - y);
            }
        }

        return 0;
    }

    /**
     * 分割等和子集
     * 输入: [1, 5, 11, 5]
     * 输出: true
     * 解释: 数组可以分割成 [1, 5, 5] 和 [11]
     *
     * 背包问题
     * dp[i]表示的是当前存储的最大价值的数
     */

    private boolean knapSack(int[] nums,int sum){
        int size = nums.length;
        boolean[] dp = new boolean[sum + 1];
        //也就是从上到下，从右往左
        //只有第一个nums[0]这个价值的数，如果这个价值和dp[i]中的i相等，则将ture存储在dp[i]中
        for (int i = 0;i <= sum;i ++){
            dp[i] = i == nums[0];
        }
        for (int i = 1;i < size;i++){
            for (int j = sum;j >= nums[i];j--){
                dp[j] = dp[j] || dp[j-nums[i]];
            }
        }
        return dp[sum];
    }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int item : nums){
            sum += item;
        }
        //如果数组元素和不是2的倍数，直接返回false
        if (sum % 2 != 0)
            return false;
        return knapSack(nums,sum/2);
    }

    /**
     * 验证回文字符串
     *
     * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串
     * 输入: "abca"
     * 输出: True
     * 解释: 你可以删除c字符
     */
    public boolean validPalindrome(String s) {
        for(int i = 0, j = s.length()-1; i < j ; i++, j--){
            if(s.charAt(i) != s.charAt(j)){
                //分两种情况，一是右边减一，二是左边加一
                return isPalindrome(s,i,j-1) || isPalindrome(s, i+1, j);
            }
        }
        return true;
    }
    //判断是否为回文字符串
    public boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }


    /**打家劫舍
     * 这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。
     * 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警
     *
     * 这个问题我们区分的就是 偷第一家 和 不偷第一家
     */
    public int rob2(int[] nums) {
        //我们分别考虑偷第一个房子和不偷第一个房子
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0],nums[1]);
        int[] dp1 = new int[nums.length];//偷第一个房子
        int[] dp2 = new int[nums.length];//不偷第一个房子
        dp1[0] = nums[0];
        dp2[1] = nums[1];
        dp1[1] = Math.max(nums[0],nums[1]);
        dp2[2] = Math.max(nums[1],nums[2]);
        for(int i = 2;i < nums.length-1;i++){
            dp1[i] = Math.max(dp1[i-2]+nums[i],dp1[i-1]);
        }
        for(int i = 3;i < nums.length;i++){
            dp2[i] = Math.max(dp2[i-2]+nums[i],dp2[i-1]);
        }
        return Math.max(dp1[nums.length-2],dp2[nums.length-1]);
    }

    /**
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）
     */
    public int maxProfit1(int[] prices) {
        //遍历整个股票交易日价格列表 price，策略是所有上涨交易日都买卖（赚到所有利润）
        // 所有下降交易日都不买卖（永不亏钱）
        int profit = 0;//利润
        for (int i = 1; i < prices.length; i++) {
            int tmp = prices[i] - prices[i - 1];
            if (tmp > 0) profit += tmp;
        }
        return profit;
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
            cost = Math.min(cost, price);//最低价格
            profit = Math.max(profit, price - cost);//最大利润
        }
        return profit;

//         if(prices.length == 0) return 0;
//         int[] dp = new int[prices.length];
//         int min = prices[0];//保存最小的值
//         dp[0]=0;
//         for(int i = 1;i < prices.length;i++){
//             min = Math.min(min,prices[i]);
//             dp[i] =Math.max(dp[i-1],prices[i] - min);
//         }
//         return dp[prices.length-1];

    }

    /**打家劫舍
     * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警（也就是说不能偷相邻的两家）
     * 输入: [1,2,3,1]
     * 输出: 4
     * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
     *      偷窃到的最高金额 = 1 + 3 = 4 。
     *
     * 利用动态规划的思想，dp[i]表示当前位置最大的金额
     * dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1])
     */

    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0],nums[1]);
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i = 2;i < nums.length;i++){
            dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
        return dp[nums.length - 1];
    }


    /**
     * 乘积最大子数组,连续的子数组
     * 动态规划的思想，不过这里我们要考虑当前位置是正数还是负数的
     * [-3,4,-3]
     */
    public int maxProduct(int[] nums) {
        int[] dpMax = new int[nums.length];
        int[] dpMin = new int[nums.length];
        dpMax[0] = nums[0];
        dpMin[0] = nums[0];
        int result = dpMax[0];
        for(int i = 0;i < nums.length;i++){
            if(nums[i] >= 0){
                dpMax[i] = Math.max(nums[i],dpMax[i-1]*nums[i]);
                dpMin[i] = Math.min(nums[i],dpMax[i-1]*nums[i]);
            }else{
                dpMax[i] = Math.max(nums[i],dpMin[i-1]*nums[i]);
                dpMin[i] = Math.min(nums[i],dpMax[i-1]*nums[i]);
            }
            result = result > dpMax[i] ? result : dpMax[i];
        }
        return result;
    }

    /**
     *     最大子序和53
     */
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        for(int i = 1;i <len;i++){
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0;i < dp.length;i++){
            if(max < dp[i]){
                max = dp[i];
            }
        }
        return max;
    }









    /**
     * 单词拆分
     * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
     * 输出: true
     * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
     *      注意你可以重复使用字典中的单词。
     * <p>
     * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
     * 输出: false
     * <p>
     * 利用动态规划的思想，dp[i]表可以拆分为true
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int i = 1;i <= s.length();i++ ){
            for(int j = 0;j < i;j++){
                if(dp[j]==true && set.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }


    /**
     * 视频拼接
     *
     * 输入：clips = [[0,2],[4,6],[8,10],[1,9],[1,5],[5,9]], T = 10
     * 输出：3
     * 解释：
     * 我们选中 [0,2], [8,10], [1,9] 这三个片段。
     * 然后，按下面的方案重制比赛片段：
     * 将 [1,9] 再剪辑为 [1,2] + [2,8] + [8,9] 。
     * 现在我们手上有 [0,2] + [2,8] + [8,10]，而这些涵盖了整场比赛 [0, 10]。
     *
     * 思想：贪心算法
     */
    public int videoStitching(int[][] clips, int T) {
        int count = 0;//代表个数
        int minleft = T;
        while(minleft!= 0){
            //寻找最小的minleft
            for(int i=0;i < clips.length;i++){
                int[] arr = clips[i];
                if(arr[0] < minleft && arr[1] >= T){
                    minleft = arr[0];
                }
            }
            if(minleft == T) return  -1;
            if(minleft < T){
                count++;
                T = minleft;
            }
        }
        return count;

    }


    /**
     * 最长等差数列
     * 输入：[3,6,9,12]
     * 输出：4
     * 解释：
     * 整个数组是公差为 3 的等差数列。
     */
    public int longestArithSeqLength(int[] A) {
        Map<Integer,Integer>[] dp = new HashMap[A.length];
        for(int i = 0;i < A.length;i++){
            dp[i] = new HashMap<>();
        }
        int max = 0;
        //key代表差值，value代表长度
        for(int i = 1;i < A.length;i++){
            for(int j = 0;j < i;j++) {
                int diff = A[i] - A[j];//差值
                if (!dp[j].containsKey(diff)) {
                    dp[i].put(diff, 2);
                } else {
                    dp[i].put(diff, dp[j].get(diff) + 1);
                }
                max = Math.max(max, dp[i].get(diff));
            }
        }
        return max;
    }



    /**
     * 一个机器人位于一个 m x n 网格的左上角
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的最右下
     * 问总共有多少条不同的路径？
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        //将第一行置为1
        for (int i = 0; i < n; i++) dp[0][i] = 1;
        //将第一列置为1
        for (int i = 0; i < m; i++) dp[i][0] = 1;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     * 给定一个包含非负数的数组和一个目标整数 k，编写一个函数来判断该数组是否含有连续的子数组，
     * 其大小至少为 2，总和为 k 的倍数，即总和为 n*k，其中 n 也是一个整数
     * 输入: [23,2,4,6,7], k = 6
     * 输出: True
     * 解释: [2,4] 是一个大小为 2 的子数组，并且和为 6
     *
     * 思想一：
     * 暴力解法，我们可以将问题转换为数组中是否存在大于2的子数组，
     *其中的所有数可以被k整除
     *
     * 思想二：
     * 在思想一中，我们要判断的是 (sum[j]−sum[i])%k 是否等于 0
     * 根据性质我们可以判断sum[j]%k == sum[i]%k
     * 但是我们要控制数组的长度大于二，因而每次计算出来的余数值不应该直接加入set中
     */
    public boolean checkSubarraySum(int[] nums, int k) {
        //暴力解法
//         int len = nums.length;
//         int[] sum = new int[len+1];
//         //当前位置前面所有数的和（包括当前位置）
//         for(int i = 0;i < len;i++){
//             sum[i+1] = sum[i]+nums[i];
//         }
//
//         for(int i = 0;i < len;i++){
//             for(int j = i+2;j <= len;j++ ){
//                 int res = sum[j] - sum[i];//差值
//                 if(k == 0) {
//                     if(res == 0) return true;
//                 }else{
//                     if(res%k == 0) return true;
//                 }
//             }
//         }
//         return false;

        int N = nums.length, cache = 0;
        int[] sum = new int[N+1];
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            sum[i+1] = sum[i] + nums[i];
            int res = k == 0 ? sum[i+1] : sum[i+1] % k;
            if (set.contains(res)) return true;
            set.add(cache);
            cache = res;
        }
        return false;
    }

    /**
     *求x的平方根
     * 利用二分法进行查找
     */
    public int mySqrt(int x) {
        int left = 0,right = x,res = -1;
        while(left <= right){
            int mid = left+(right - left)>>1;
            if((long) mid*mid <= x ) {
                res = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return res;
    }

    /**
     * 连续的子数组求和

     * 动态规划的思想
     */
    public int massage(int[] nums) {



        int n = nums.length;
        if(n == 0) return 0;
        if(n == 1) return nums[0];
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i = 2;i < n;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[n-1];
    }
    /**
     *
     * 确定不会抽自己名字的概率是多少
     * @param num
     * @return
     */
    //错排
    public static float count(int num){
        if(num ==0) return 0;
        if(num == 1) return 0;
        if(num == 2) return 1;
        return (num-1)*(count(num-1)+count(num-2));
    }
    public static float fun(int num){
        if(num == 0) return 1;
        return num*fun(num-1);
    }
    public static void main1(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int num = in.nextInt();
            float re = (count(num)/fun(num))*100;
            System.out.println(String.format("%.2f",re)+"%");
        }
    }


    /**
     * 利用中序和前序重建二叉树
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        int length = preorder.length;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        int inorderIndex = 0;
        for (int i = 1; i < length; i++) {
            int preorderVal = preorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[inorderIndex]) {
                node.left = new TreeNode(preorderVal);
                stack.push(node.left);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex++;
                }
                node.right = new TreeNode(preorderVal);
                stack.push(node.right);
            }
        }
        return root;

    }



    /**
     * 将数字字符串转化位数字
     * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−2^31,  2^31 − 1]。
     * 如果数值超过这个范围，请返回  INT_MAX  或 INT_MIN

     */
    public int strToInt(String str) {
        char[] chars = str.trim().toCharArray();
        int flag = 1;
        long res = 0;
        int j = 1;
        if(chars[0] == '-') flag = -1;
        else if(chars[0] != '-') j=0;
        for(int i = j;i < chars.length;i++){
            if(chars[i] > '9' || chars[i] <'0') break;
            res = res*10 + (chars[i]-'0');
            if(res > Integer.MAX_VALUE){
                return flag == 1 ? Integer.MAX_VALUE:Integer.MIN_VALUE;
            }
        }
        return flag*(int) res;
    }





    /**
     * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
     * 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次
     */
    public int countDigitOne(int n){
        //将其化为字符串
        String str = new String();
        str+=n;
        int high = n;
        int count = 0;
        for(int i = 0;i < str.length();i++){
            int digit = (int)Math.pow(10,i);
            int tmp = high % 10;
            high/=10;
            if(tmp == 0) count += high*digit;
            else if(tmp == 1) count+=high*digit+n%digit+1;
            else if(tmp > 1) count+=(high+1)*digit;

        }
        return count;
    }



    /**
     * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，
     * A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
     */
    public boolean isStraight(int[] nums) {
//        TreeSet<Integer> s = new TreeSet<>();
//        for(int num:nums){
//            if(num == 0) continue;
//            if(s.contains(num)) return false;
//            s.add(num);
//        }
//        return s.last()-s.first() < 5;


        int joker = 0;
        Arrays.sort(nums);
        for(int i = 0;i < 5;i++){
            if(nums[i] == 0) joker++;
            else if(nums[i] == nums[i+1]) return false;
        }
        return nums[4] - nums[joker] < 5;


    }



    /**
     * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1）
     * ，每段绳子的长度记为 k[0],k[1]...k[m] 。请问 k[0]*k[1]*...*k[m] 可能的最大乘积是多少？
     * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
     *答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
     * 输入: 10
     * 输出: 36
     * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
     */
    public int cuttingRope1(int n){
        if(n<=3) return n-1;
        int res = 1;
        while( n > 4){
            res = res * 3 % 1000000007;
            n -= 3;
        }
        return (int)(res*n%1000000007);
    }


    /**
     * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。
     * 从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
     */

    LinkedList<List<Integer>> list = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum){
        recur(root,sum);
        return list;
    }
    void recur(TreeNode root, int tar){
        if(root == null) return;
        path.add(root.val);
        tar -= root.val;
        if(tar == 0 && root.left == null && root.right == null){
            list.add(new LinkedList(path));
        }
        recur(root.left,tar);
        recur(root.right,tar);
        path.pollLast();
    }


    /**
     * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
     */
    Node prev,head;
    public void BSTree(Node root){
        if(root == null) return;
        BSTree(root.left);
        if(prev!= null) prev.right = root;
        else head = root;
        //每次找到结点先改变左指针域
        root.left = prev;
        prev = root;
        BSTree(root.right);
    }
    public Node treeToDoublyList(Node root) {
        if(root == null) return null;
        BSTree(root);
        head.left = prev;
        prev.right = head;
        return head;
    }

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

    public static void main2(String[] args) {
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
