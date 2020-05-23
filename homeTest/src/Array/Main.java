package Array;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @ClassName Main
 * @Description TODO
 * @Author DELL
 * @Data 2020/5/20 17:35
 * @Version 1.0
 **/
public class Main {
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
