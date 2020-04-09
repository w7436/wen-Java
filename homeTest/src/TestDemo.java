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

public class TestDemo {
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

    public boolean isPerfectSquare(int num) {
        // double i = 1;
        // while(i * i < num) {
        //     i++;
        // }
        // return i * i == num;

        //数学公式
        // int i = 1;
        // while(num > 0){
        //     num -= i;
        //     i += 2;
        // }
        // return num==0;


        //利用二分法
        if(num ==1){
            return true;
        }
        long left = 2, right = num >>1, x, guessSquared;
        while (left <= right) {
            x = left + ((right - left) >>1);
            guessSquared = x * x;
            if (guessSquared == num) {
                return true;
            }
            if (guessSquared > num) {
                right = x - 1;
            } else {
                left = x + 1;
            }
        }
        return false;
    }

    /**
     * 只出现一次的数据
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {

    HashMap<Integer, Integer> hashmap = new HashMap<>();
    for (int num : nums)
        hashmap.put(num, hashmap.getOrDefault(num, 0) + 1);

    for (int k : hashmap.keySet())
        if (hashmap.get(k) == 1) return k;
    return -1;

}

    /**
     *
     * @param haystack
     * @param needle
     * 给定一个 haystack 字符串和一个 needle 字符串，
     * 在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
     *
     */

    public int strStr(String haystack, String needle) {
        if (needle == null) {
            return 0;
        }
        // int hsize = haystack.length();
        // int nsize = needle.length();

        // for(int i = 0; i <= hsize-nsize;i++){
        //     int j =0;
        //     for(;j < nsize;j++){
        //         if(haystack.charAt(i+j)!=needle.charAt(j)){
        //             break;
        //         }
        //     }
        //     if(j==nsize){
        //         return i;
        //     }
        // }
        // return -1;
        return haystack.indexOf(needle);

    }
}




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