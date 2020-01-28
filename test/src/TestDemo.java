import java.util.*;

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
    //加一
    public int[] plusOne(int[] digits) {

        int len = digits.length;
        for(int i = len-1; i >= 0; i--) {
            digits[i]++;
            digits[i] %= 10;
            if(digits[i]!=0)
                return digits;
        }
        digits = new int[len + 1];
        digits[0] = 1;
        return digits;
    }
    //寻找数组的中间索引
    public int pivotIndex(int[] nums) {
        int sum = 0,leftsum = 0;
        for(int x : nums)
            sum+=x;

        for (int i = 0; i < nums.length ; i++  ){
            if(sum - nums[i] - leftsum == leftsum){
                return i;
            }
            leftsum += nums[i];

        }
        return -1;
    }
    //按照奇数偶数排序数组
    public int[] sortArrayByParity(int[] A) {
        // int[] ans = new int[A.length];
        // int t = 0;

        // for (int i = 0; i < A.length; ++i)
        //     if (A[i] % 2 == 0)
        //         ans[t++] = A[i];

        // for (int i = 0; i < A.length; ++i)
        //     if (A[i] % 2 == 1)
        //         ans[t++] = A[i];

        // return ans;
        int i = 0, j = A.length - 1;
        while (i < j) {
            if (A[i] % 2 > A[j] % 2) {
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }

            if (A[i] % 2 == 0) i++;
            if (A[j] % 2 == 1) j--;
        }

        return A;
    }
    //只是字母的反转
    public String reverseOnlyLetters(String S) {
        StringBuilder ans = new StringBuilder();
        int j = S.length() - 1;
        for (int i = 0; i < S.length(); ++i) {
            if (Character.isLetter(S.charAt(i))) {
                //确保j指向的始终是字符
                while (!Character.isLetter(S.charAt(j)))
                    j--;
                ans.append(S.charAt(j--));

            } else {
                ans.append(S.charAt(i));
            }
        }
        return ans.toString();

        //     //利用栈的思想
        //    Stack<Character> stack = new Stack();
        //     for (char c: S.toCharArray())
        //     //是字母就将其压入栈
        //         if (Character.isLetter(c))
        //             stack.push(c);

        //     StringBuilder ans = new StringBuilder();
        //     //从原先字符串拿到的只是符号
        //     for (char c: S.toCharArray()) {
        //         if (Character.isLetter(c))
        //             ans.append(stack.pop());
        //         else
        //             ans.append(c);
        //     }

        //     return ans.toString();

    }
    //字符串二级制求和
     public String addBinary(String a, String b) {
            StringBuilder ans = new StringBuilder();
            int ca = 0;
            for(int i = a.length() - 1, j = b.length() - 1;i >= 0 || j >= 0; i--, j--)          {
                int sum = ca;
                sum += i >= 0 ? a.charAt(i) - '0' : 0;
                sum += j >= 0 ? b.charAt(j) - '0' : 0;
                ans.append(sum % 2);
                ca = sum / 2;
            }
            ans.append(ca == 1 ? ca : "");
            return ans.reverse().toString();
        }
        //两数之和
    public int[] twoSum(int[] nums, int target) {
        // int[] arr=new int[2];
        // for(int i = 0;i < nums.length; i++){
        //     for(int j = i + 1;j <nums.length;j++){
        //         if(nums[i] + nums[j] == target){
        //             arr[0]=i;
        //             arr[1]=j;
        //             return arr;
        //         }
        //     }
        // }
        // return null;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
    //第三大的数
    public int thirdMax(int[] nums) {
        long first=Long.MIN_VALUE,second=Long.MIN_VALUE,third=Long.MIN_VALUE;
        for(long num:nums){
            if(num>first){
                third=second;
                second=first;
                first=num;
            }else if(num>second&&num<first){
                third=second;
                second=num;
            }else if(num>third&&num<second){
                third=num;
            }
        }
        return (third==Long.MIN_VALUE||third==second)?(int)first:(int)third;

    }
    //检测大写字母
    public boolean detectCapitalUse(String word) {

        char[] chars = word.toCharArray();
        int upper = 0;//大写字母个数
        int lower = 0;//小写字母个数
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] - 'a' < 0)
                upper++;
            else
                lower++;
        }

        if (upper == chars.length || lower == chars.length || (upper == 1 && chars[0] < 'a'))
            return true;
        else
            return false;

    }
}





public class TestDemo {
    public static void main(String[] args) {

    }
}
