package Array;

import javax.swing.text.Position;
import java.util.*;

/**
 * @ClassName Main
 * @Description TODO
 * @Author DELL
 * @Data 2020/5/20 17:35
 * @Version 1.0
 **/
public class Main {
    /**
     * 编写一段程序来查找第 n 个超级丑数。
     * 超级丑数是指其所有质因数都是长度为 k 的质数列表 primes 中的正整数。
     */
    public int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<Long>queue=new PriorityQueue<>();
        long res=1;
        for(int i=1;i<n;i++){
            for(int prime:primes){
                queue.add(prime*res);
            }
            res=queue.poll();
            while(!queue.isEmpty()&&res==queue.peek()) queue.poll();
        }
        return (int)res;
    }
    /**
     * 编写一个程序，找出第n个丑数，丑数就是只包括2,3,5的正整数
     * 1、利用优先级队列，也就是小顶堆
     * 2、动态规划
     */
    public int nthUglyNumber(int n) {
        //利用最小堆来解决
//        PriorityQueue<Double> q = new PriorityQueue<>();
//        double res = 1;
//        for(int i = 1;i < n;i++) {
//            q.add(res * 2);
//            q.add(res * 3);
//            q.add(res * 5);
//            res = q.poll();
//            //去重
//            while (!q.isEmpty() && res == q.peek()) {
//                q.poll();
//            }
//        }
//        return (int)res;
        //利用动态规划
        int[] dp = new int[n];
        dp[0] = 1;
        int m = 0,j = 0,k = 0;
        for(int i = 1;i < n; i++){
            int min = Math.min(dp[m]*2,Math.min(dp[j]*3,dp[k]*5));
            if(min == dp[m]*2) m++;
            if(min == dp[j]*3) j++;
            if(min == dp[k]*5) k++;
            dp[i] = min;
        }
        return dp[n-1];
    }
    /**
     * 编写一个函数，计算两个数组的交集
     * 1、利用集合
     * 2、利用Map映射
     * 3、利用排序
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        // List<Integer> l = new ArrayList<>();
        // for(int i = 0;i < nums1.length;i++) {
        //     l.add(nums1[i]);
        // }
        // List<Integer> l2 = new ArrayList<>();
        // for(int i = 0;i < nums2.length;i++){
        //     if(l.contains(nums2[i])) {
        //         l2.add(nums2[i]);
        //         l.remove(Integer.valueOf(nums2[i]));
        //     }

        // }
        // int[] arr = new int[l2.size()];
        // int i = 0;
        // for(int num:l2) {
        //     arr[i++] = num;
        // }
        // return arr;

        // Map<Integer,Integer> map = new HashMap<>();
        // for(int num : nums1) {
        //     Integer count = map.get(num);
        //     if(count == null){
        //         map.put(num,1);
        //     }else {
        //         map.put(num,++count);
        //     }
        // }
        // List<Integer> l = new ArrayList<>();
        // for(int num : nums2){
        //     Integer count = map.get(num);
        //     if(count != null && count != 0){
        //         l.add(num);
        //         map.put(num,--count);
        //     }
        // }
        // int[] arr = new int[l.size()];
        // int i = 0;
        // for(int num : l){
        //     arr[i++] = num;
        // }
        // return arr;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> l = new ArrayList<>();
        for(int i = 0,j = 0;i < nums1.length && j < nums2.length;){
            if(nums1[i] == nums2[j]) {
                l.add(nums1[i]);
                i++;
                j++;
            } else if(nums1[i] > nums2[j]) {
                j++;
            }else {
                i++;
            }
        }
        int[] arr = new int[l.size()];
        int i = 0;
        for(int num : l){
            arr[i++] = num;
        }
        return arr;
    }
    //深度优先搜索
    /**
     给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
     找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。

     X X X X
     X O O X
     X X O X
     X O X X

     X X X X
     X X X X
     X X X X
     X O X X
     1、从每一个边开始寻找o，如果没有就表示所有的o都被包围
     2、对于边上的每一个o进行边缘扩散，先将每一个o用字符进行标示，
     3、把他和相邻的o替换为特殊字符，每一个位置都进行操作
     4、扩散那之后，将特殊字符标记为o，剩下的都为x
     */
    public int[][] position2 ={{1,0},{0,1},{-1,0},{0,-1}};
    private void dfs2(char[][] board, int row, int col, int i, int j) {
        //对当前位置进行标记
        board[i][j] = '*';
        //对每一个位置进行判断
        for(int k = 0;k < 4;k++){
            int nx = i + position2[k][0];
            int ny = j + position2[k][1];
            //越界问题
            if(nx >= row || nx < 0 || ny >=col || ny < 0){
                continue;
            }
            //对符合条件的再次进行深搜
            if(board[nx][ny] != '*' && board[nx][ny] != 'O' ){
                dfs2(board,row,col,nx,ny);
            }
        }
    }
    public void solve(char[][] board) {
        if(board.length == 0) return;
        int row = board.length;
        int col = board[0].length;
        //对第一行和最后一行的o进行深度优先搜索
        for(int i = 0;i < col;i++){
            if(board[0][i] == 'O'){
                dfs2(board,row,col,0,i);
            }
            if(board[row-1][i] == '0'){
                dfs2(board,row,col,row-1,i);
            }
        }
        //对第一列和最后一列进行深度搜索
        for(int j = 0;j < row;j++){
            if(board[j][0] == 'O'){
                dfs2(board,row,col,j,0);
            }
            if(board[j][col-1] == 'O'){
                dfs2(board,row,col,j,0);
            }
        }
        //深度搜索完成之后，将所有*换为o
        for(int i = 0;i < row;i++ ){
            for(int j = 0;j < col;j++){
                if(board[i][j] == '*'){
                    board[i][j] = 'O';
                }else if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }

    /**
     * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
     * 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成
     *
     * 11000
     * 11000
     * 00100
     * 00011
     *
     * 输出: 3
     */

    public int[][] position1 ={{1,0},{0,1},{-1,0},{0,-1}};
    private void dfs1(char[][] grid, int row, int col, int[][] book, int i, int j) {
        //处理当前位置的数,对其进行标记
        book[i][j] = 1;
        //对每一个位置进行判断
        for(int k = 0;k < 4;k++){
            int nx = i + grid[k][0];
            int ny = j + grid[k][1];
            //对每一个位置进行越界判断
            if(nx >= row || nx < 0 || ny >= col || ny < 0){
                continue;
            }
            //对符合条件的在进行标记渲染
            if(grid[nx][ny] == '1' && book[nx][ny] == 0){
                dfs1(grid,row,col,book,nx,ny);
            }
        }
    }
    public int numIslands(char[][] grid) {
        if(grid.length == 0) return 0;
        int count = 0;
        int row = grid.length;
        int col = grid[0].length;
        int[][] book = new int[row][col];//标记函数
        //对每一个点进行遍历
        for(int i = 0;i < row;i++){
            for(int j = 0;j < col;j++){
                //对符合条件的进行加一操作
                if(grid[i][j] == '1' && book[i][j] == 0){
                    count++;
                    dfs1(grid,row,col,book,i,j);
                }

            }
        }
        return count;
    }



    /**
     * 有一幅以二维整数数组表示的图画，每一个整数表示该图画的像素值大小，
     * 数值在 0 到 65535 之间。
     * 给你一个坐标 (sr, sc) 表示图像渲染开始的像素值（行 ，列）和一个新的颜色值 newColor，让你重新上色这幅图像
     *
     * 进行搜索我们需要注意位置是否越界。对其进行判断
     */
    int[][] position = {{0,1},{1,0},{-1,0},{0,-1}};//四个方向
    public void dfs(int[][] image,int row,int col,int[][] book,int sr,int sc,int oldColor,int newColor){
        //对当前位置进行上色，并且标记
        image[sr][sc] = newColor;
        book[sr][sc] = 1;
        //对每一个方向进行检索
        for(int i = 0;i < 4;i++){
            int newSr = sr+position[i][0];
            int newSc = sc+position[i][1];

            //对其新位置进行判断是否越界
            if(newSr >= row || newSr < 0 || newSc >= col || newSc < 0){
                continue;
            }
            //对新位置进行染色，并且确保没有标记过,继续渲染
            if(image[newSr][newSc] == oldColor && book[newSr][newSc] == 0){
                dfs(image,row, col, book,newSr,newSc,oldColor,newColor);
            }
        }
    }
//------------------------------------------------------------------------------------------------------------------
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int row = image.length;
        int col = image[0].length;
        int oldColor = image[sr][sc];
        int[][] book = new int[row][col];//标记
        dfs(image,row,col,book,sr,sc,oldColor,newColor);
        return image;
    }



    /**
     * 机器人运动范围
     * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
     * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
     * 也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，
     * 机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。
     * 请问该机器人能够到达多少个格子？
     * 利用深度优先搜索
     *
     * 数位和增量
     * x的数位和为Sx，x+1的数位和为S（x+1）
     * (x+1)%10 == 0  S(x+1)=Sx - 8 例如19,20的数位和为10,2
     * (x+1)%10!=0 S(x+1)=Sx+1 ,例如1,2的数位和为1,2
     *
     */
    int m, n, k;
    boolean[][] visited;
    public int movingCount(int m, int n, int k) {
        this.m = m;
        this.n = n;
        this.k = k;
        this.visited = new boolean[m][n];
        return dfs(0, 0, 0, 0);
    }
    public int dfs(int i, int j, int si, int sj) {
        if(i >= m || j >= n || k < si + sj || visited[i][j])
            return 0;
        visited[i][j] = true;//将已经遍历过的置为true
        return 1 + dfs(i + 1, j, (i + 1) % 10 != 0 ? si + 1 : si - 8, sj) + dfs(i, j + 1, si, (j + 1) % 10 != 0 ? sj + 1 : sj - 8);
    }
    /**
     * 是否所有1都至少相隔k个元素
     * 输入：nums = [1,0,0,0,1,0,0,1], k = 2
     * 输出：true
     * 解释：每个 1 都至少相隔 2 个元素。
     */
    public boolean kLengthApart(int[] nums, int k) {
        int count = k;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==1){
                if(count<k)
                    return false;
                count = 0;
            }
            else{
                count++;
            }
        }
        return true;
    }
    /**
     *给定两个单词word1和word2，请计算将word1转换为word2至少需要多少步操作。
     * 你可以对一个单词执行以下3种操作：
     * a）在单词中插入一个字符
     * b）删除单词中的一个字符
     * c）替换单词中的一个字符
     *
     * 动态规划:F(i,j):word1的前i个字符于word2的前j个字符的编辑距离
     * F(i,j) = min { F(i-1,j）+1, F(i,j-1) +1, F(i-1,j-1) +(w1[i]==w2[j]?0:1) }
     * 分别代表删除，插入，替换，这些删除是对于当前的字符串而言的
     */
    public int minDistance(String word1, String word2) {
        // word与空串之间的编辑距离为word的长度
        if(word1.isEmpty() || word2.isEmpty())
            return Math.max(word1.length(), word2.length());
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1][len2];
        //初始化操作
        for(int i = 0;i <= len1;i++){
            dp[i][0] = i;
        }
        for(int i = 0;i <= len2;i++){
            dp[0][i] = i;
        }
        for(int i = 0;i <= len1;i++){
            for(int j = 0;j <= len2;j++){
                dp[i][j] = Math.min(
                        Math.min(dp[i][j-1]+1,dp[i-1][j]+1)//插入，删除
                        ,dp[i-1][j-1]+(word1.charAt(i-1)==word2.charAt(j-1)?0:1));//替换
            }
        }
        return dp[len1][len2];
    }


    /**
     * 给定一个字符串S和一个字符串T，计算S中的T的不同子序列的个数(S中有几个子串与T相同)
     * 字符串的子序列是由原来的字符串删除一些字符（也可以不删除）在不改变相对位置的情况下的剩余字符
     * （例如，"ACE"is a subsequence of"ABCDE"但是"AEC"不是）
     * 例如：
     * S ="rabbbit", T ="rabbit"
     *
     * 动态规划：
     * S[1:m]中的子串与T[1:n]相同的个数
     * 由S的前m个字符组成的子串与T的前n个字符相同的个数
     * F(i,j): S[1:i]中的子串与T[1:j]相同的个数
     *
     * 状态的递推：F(i,j)我们需要考虑的是S[i-1]是否等于T(j-1)这两种情况
     * if(S[i-1] == T[j-1])
     *     S[i-1]匹配T[i-1] 不匹配两种情况
     * else{
     *     退化为F(i,j) = F(i-1,j)
     * }
     */
    public int numDistinct(String S, String T) {
        int len1 = S.length();
        int len2 = T.length();
        int[][] dp = new int[len1+1][len2+1];
        dp[0][0] = 1;//空串和空串相等
        //初始化行
        for(int i = 1;i <= len2;i++){
            dp[0][i] = 0;
        }
        for(int i = 1;i <= len1;i++){
            dp[i][0] = 1;//S的子串（存在空串）与空串也相等
        }
        for(int i = 1;i <= len1;i++){
            for(int j = 1;j <= len2;j++){
                //S的第i个字符和T的第j个字符相等
                if(S.charAt(i-1) == T.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];//退化为之前
                }
            }
        }
        return dp[len1][len2];
    }


    /**
     * 有n物品和大小的背包m。给定的数组A表示每个项目的大小，数组V表示每个项目的值。
     * 思想：0-1背包问题
     * F（i，j）代表前i个商品放入大小为j个背包中所获得的最大值
     * 1）放不下，F（i-1,j）
     * 2)放的下，Math.max(F(i-1,j),F(i-1,j-A[i])+v[i])
     * 我们记得初始化
     *
     * 优化算法，我们可以看到计算本行的一个数据，只用到上一行的数据，我们可以将二维数组简化为一维数组
     * f[m] =Math.max(f[m],f[m-A[i]]+V[i])
     * */
    public int backPackII(int m, int[] A, int[] V) {
        int len = A.length; //物品的种类个数
        int dp[][] = new int[len+1][m+1];
        //初始化操作
        for(int i = 0;i <= len;i++){
            dp[i][0] = 0;
        }
        for(int j = 1;j <= m;j++){
            dp[0][j] = 0;
        }
        for(int i = 1;i <= len;i++){
            for(int j = 1;j <= m;j++){
                //表示不能装下
               if(j < A[i]){
                   dp[i][j] = dp[i-1][j];
               }else{
                   int value = dp[i-1][j-A[i]]+V[i];
                   dp[i][j] = Math.max(dp[i-1][j],value);
               }
            }
        }
        return dp[len][m];
    }
    public int backPackII2(int m, int[] A, int[] V) {
        int num = A.length;
        if(m == 0 || num == 0) return 0;
        //多加一列用于设置初始化条件
        int[] dp = new int[m+1];
        for(int i = 0;i <= m;i++){
            dp[i] = 0;
        }
        for(int i = 1;i <= num;i++){
            //从后往前进行计算，当前i的状态只是和i-1个状态的值相关，我们的一维数组仅仅是保留上一个状态的值，
            //如果我们按顺序进行计算，上一个状态的值会被我们更改，这样就会产生问题
            for(int j = m;j>=0;j--){
                if(A[i-1] <= j)
                    dp[i] = Math.max(dp[i],dp[i-A[i-1]]+V[i-1]);
            }
        }
        return dp[m];
    }

    /**
     * 硬币：
     * 硬币。给定数量不限的硬币，币值为25分、10分、5分和1分，
     * 编写代码计算n分有几种表示法。(结果可能会很大，你需要将结果模上1000000007)
     *
     *  输入: n = 5
     *  输出：2
     *  解释: 有两种方式可以凑成总金额:
     * 5=5
     * 5=1+1+1+1+1
     * 思想：完全背包问题
     * 约束条件：每种物品的数量为无限多个你可以选择任意数量的物品
     * dp[k]:表示组成k面额的硬币情况
     *
     */
    public int waysToChange(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;//刚好用一个硬币
        int[] coins = {1,5,10,25};
        //dp[i] += dp[i-coin]
        for(int coin:coins){
            for(int i = coin;i <= n;i++){
                dp[i] = (dp[i]+dp[i-coin])%1000000007;
            }
        }
        return dp[n];
    }
    /**
     * 和为k的子数组
     * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
     *
     * 输入:nums = [1,1,1], k = 2
     * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
     */
    public int subarraySum(int[] nums, int k) {
        int count = 0, pre = 0;
        HashMap< Integer, Integer > mp = new HashMap < > ();
        mp.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (mp.containsKey(pre - k))
                count += mp.get(pre - k);
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
    /**
     *回文串的分割
     * 思想：利用动态规划
     * f[i]：到第i个字符需要分割的最小次数
     *依次类推
     * f[i]=min(f(i),f(j)+1) when j<i && j+1，i是回文串
     
     * */
    //判断是否为回文串
    public boolean isPal(String s, int start, int end) {
        while(start < end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }else{
                start++;
                end--;
            }
        }
        return true;
    }
    public int minCut(String s) {
        int len = s.length();
        if(len == 0){
            return 0;
        }
        int[] dp = new int[len+1];
        //dp[i]初始化，2个字符最大分割1次，3个字符最大分割2次，依次类推
        for(int i = 0;i <= len;i++){
            dp[i] = i - 1;
        }
        for(int i = 1;i <= len;i++){
            for(int j = 0;j < i;j++){
                if(isPal(s,j,i-1)){
                    dp[i] = Math.min(dp[i],dp[j]+1);
                }
            }
        }
        return dp[len];
    }
    /**
     * 统计优美子数组
     *
     *给你一个整数数组 nums 和一个整数 k。
     *如果某个 连续 子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。
     *请返回这个数组中「优美子数组」的数目
     * 输入：nums = [1,1,2,1,1], k = 3
     * 输出：2
     * 解释：包含 3 个奇数的子数组是 [1,1,2,1] 和 [1,2,1,1]
     *
     */
    public int numberOfSubarrays(int[] nums, int k) {
        // 数组 prefixCnt 的下标是前缀和（即当前奇数的个数），值是前缀和的个数。
        int[] prefixCnt = new int[nums.length + 1];
        prefixCnt[0] = 1;
        // 遍历原数组，计算当前的前缀和，统计到 prefixCnt 数组中，
        // 并且在 res 中累加上与当前前缀和差值为 k 的前缀和的个数。
        int res = 0, sum = 0;
        for (int num: nums) {
            sum += num & 1;
            prefixCnt[sum]++;
            if (sum >= k) {
                res += prefixCnt[sum - k];
            }
        }
        return res;
    }
    /**
     * 划分数组为连续数字的集合
     * 输入：nums = [1,2,3,3,4,4,5,6], k = 4
     * 输出：true
     * 解释：数组可以分成 [1,2,3,4] 和 [3,4,5,6]
     *
     * 输入：nums = [1,2,3,4], k = 3
     * 输出：false
     * 解释：数组不能分成几个大小为 3 的子数组
     */
    public boolean isPossibleDivide(int[] nums, int k) {
        if (nums.length % k != 0) return false;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        while (!map.isEmpty()) {
            int firstKey = map.firstKey();//key
            for (int i = firstKey; i < firstKey + k; i++) {
                int v = map.getOrDefault(i, 0);
                if (v == 0) return false;
                if (v - 1 == 0) map.remove(i);
                else map.put(i, v - 1);
            }
        }
        return true;
    }
    /**
     * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，
     * 每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。
     * 例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）
     * [["a","b","c","e"],
     * ["s","f","c","s"],
     * ["a","d","e","e"]]
     *
     * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
     *
     * 思想：深度优先算法
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(dfs(board, words, i, j, 0)) return true;
            }
        }
        return false;
    }
    boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        if(i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k]) return false;
        if(k == word.length - 1) return true;
        char tmp = board[i][j];
        board[i][j] = '/';
        boolean res = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1) ||
                dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i , j - 1, k + 1);
        board[i][j] = tmp;
        return res;
    }


    /**
     * 输入：nums = [[1,2,3],[4,5,6],[7,8,9]]
     * 输出：[1,4,2,7,5,3,8,6,9]
     *
     * 思想：按照主对角线进行打印
     * @param nums
     * @return
     */
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int len = 0;
        Map<Integer,List<Integer>> map = new TreeMap<>();
        for(int i = 0;i < nums.size();i++) {
            len += nums.get(i).size(); // 获取最后要返回的数组的长度，即元素个数
            for(int j = 0;j < nums.get(i).size();j++) {
                if(map.containsKey(i + j)) {
                    map.get(i + j).add(nums.get(i).get(j));
                }
                else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums.get(i).get(j));
                    map.put(i + j, list);
                }
            }
        }
        int[] ans = new int[len];
        int index = 0;
        for(int key : map.keySet()) { // 遍历map
            List<Integer> list = map.get(key);
            for(int j = list.size() - 1;j >= 0;j--) { // 根据题目的输出要求确定生成数组中元素的顺序
                ans[index] = list.get(j);
                index++;
            }
        }
        return ans;
    }
    /**
     * [1,2,3,4]
     * [5,6,7,8]
     * [9,10,11,12]
     * [13,14,15,16]
     *
     * 打印结果[4,3,8,2,7,12,1,6,11,16]
     * 从右上角到左下角按照主对角线进行打印
     */
    public int[] arrayPrint(int[][] arr, int n) {
        // write code here
        List<Integer> l = new ArrayList<>();
        int[] a = new int[n*n];
        int x = 0;
        //右上角
        for(int y = n-1;y >= 0;y--){
            int i = x;
            int j = y;
            if(i !=0 && j != 0){
                l.add(arr[i][j]);
            }
            if(i != 0){
                j--;
            }
            while(i < n &&(j >=0 && j<n)){
                l.add(arr[i][j]);
                i++;
                j++;
            }
        }
        //左下角
        int y = 0;
        for(x = 1;x < n;x++){
            int i1 = x;
            int j1 = y;
            l.add(arr[i1][j1]);
            i1++;
            j1++;
            while(i1 < n &&(j1 >=0 && j1<n)){
                l.add(arr[i1][j1]);
                i1++;
                j1++;
            }
        }
        for(int i = 0;i < l.size();i++){
            a[i] = l.get(i);
        }
        return a;
    }
}
