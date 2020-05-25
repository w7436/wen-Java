package Array;

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
