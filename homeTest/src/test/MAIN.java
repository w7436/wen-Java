package test;

/**
 * @ClassName MAIN
 * @Description TODO
 * @Author DELL
 * @Data 2020/8/5 21:49
 * @Version 1.0
 **/
public class MAIN {
    public static void main(String[] args) {
        Object c = new Object();
        Object c1 = c.

    }

    /**
     * 最长子序列的长度
     * @param nums
     * @return
     */
    public static int lengthOfLIS(int[] nums) {
        if(nums.length == 0) return 0;
        //利用动态规划的思想
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = Integer.MIN_VALUE;
        for(int i = 1;i < nums.length;i++) {
            //i代表以当前位置为结尾的最大子序列长度
            int len = 0;
            for(int j = 0;j < i;j++) {
                if(nums[j] < nums[i] ) {
                    len = Math.max(len,dp[j]);
                }
            }
            dp[i] = len+1;
            max = Math.max(max,dp[i]);
        }
        return max;
    }
    public static int lengthOfLIS1(int[] nums) {
        //利用动态规划和二分法，将时间复杂度降低到O(logN)
        int[] dp = new int[nums.length];
        int len = 0;//代表dp数组的实际长度
        for(int num : nums) {
            int i = 0,j = len;
            //左闭右开[i,j)
            while(i < j) {
                int mid = (i + j) / 2;
                if(dp[mid] < num ) i = mid + 1;
                else j = mid;
            }
            dp[i] = num;
            if(j == len) len++;//将数组的长度进行加一
        }
        return len;
    }
    public static void main1(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        int len = lengthOfLIS1(nums);
        System.out.println(len);
    }
}
