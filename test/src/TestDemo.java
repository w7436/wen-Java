import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @ClassName TestDemo
 * @Description TODO
 * @Author DELL
 * @Data 2020/1/12 22:59
 * @Version 1.0
 **/
class Solution {

    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int i = 0, j = 0;
        Set<Character> set = new HashSet<>();
        while (i < s.length() && j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i));
                i++;
            }
        }
        return ans;


    }
    // public boolean judge(String s ,int st ,int end){
    //     Set <Character> set= new HashSet();
    //     for(int i = st; i< end ;i++){
    //         char ch = s.charAt(i);
    //         if(set.contains(ch))
    //             return false;
    //         else
    //             set.add(ch);
    //     }
    //     return true;
    // }
    // public int lengthOfLongestSubstring(String s) {
    //     int tmp=0;
    //     for (int i = 0;i < s.length(); i++){
    //         for (int j = i+1;j <= s.length(); j++ ){
    //             if(judge(s ,i ,j)){
    //                 tmp=Math.max(tmp,j-i);
    //             }
    //         }
    //     }
    //     return tmp;
    // }


    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    //入队：将元素放入到stack1中
    public void push(int node) {
        stack1.push(node);
    }

    //出队
    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty())
                stack2.push(stack1.pop());
        }
        return stack2.pop();
    }

    //赎金信
    public boolean canConstruct(String ransomNote, String magazine) {
        int b[] = new int[26];
        for (char c : magazine.toCharArray()) {
            b[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            if (b[c - 'a'] == 0)
                return false;
            b[c - 'a']--;
        }
        return true;

    }

    //整数反转
    public long reverse(int x) {
        long sum = 0;
        while (x != 0) {
            sum *= 10;
            sum += x % 10;
            x /= 10;
        }

        if (sum < -2147483648 || sum > 2147483647)
            return 0;
        return sum;
    }

    //存在相同的元素
    public boolean containsDuplicate(int[] nums) {

        // Set<Integer> set = new HashSet<>(nums.length);
        // for (int x: nums) {
        //     if (set.contains(x)) return true;
        //     set.add(x);
        // }
        // return false;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; ++i) {
            if (nums[i] == nums[i + 1]) return true;
        }
        return false;
    }
    //最后一个单词的长度
    public int lengthOfLastWord(String s) {
        if(s == null || s.length() == 0) return 0;
        int count = 0;
        for(int i = s.length()-1; i >= 0; i--){
            if(s.charAt(i) == ' '){
                //末尾含有空格
                if(count == 0) continue;
                break;
            }
            count++;
        }
        return count;
    }
    //判断一个数字是否为回文数
    public boolean isPalindrome(int x) {
        //先将其转为字符串，再比较其是否相等
        // String reversedStr = (new StringBuilder(x + "")).reverse().toString();
        // return (x + "").equals(reversedStr);


        //反转一半的数字，例如：1331--> 13   1232-->12
        //首先判断负数，负数不可能为回文数
        if(x<0||( x % 10==0 && x!=0))
            return false;
        //反转一半的数字
        int reverseInt=0;
        while(x > reverseInt){
            reverseInt = reverseInt * 10 + x % 10;
            x/=10;
        }
        if(x == reverseInt || x == reverseInt / 10)
            return true;
        return false;
    }
}





public class TestDemo {
    public static void main(String[] args) {

    }
}
