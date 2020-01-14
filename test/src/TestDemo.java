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
        int ans=0;
        int i=0,j=0;
        Set<Character> set = new HashSet<>();
        while( i<s.length() &&  j<s.length()){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                j++;
                ans=Math.max(ans,j-i);
            }
            else{
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
}

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    //入队：将元素放入到stack1中
    public void push(int node) {
        stack1.push(node);
    }
    //出队
    public int pop() {
        if(stack2.isEmpty()){
            while(!stack1.isEmpty())
                stack2.push(stack1.pop());
        }
        return stack2.pop();
    }
    //赎金信
    public boolean canConstruct(String ransomNote, String magazine) {
        int b[]=new int[26];
        for(char c:magazine.toCharArray()){
            b[c-'a']++;
        }
        for(char c:ransomNote.toCharArray()){
            if(b[c-'a']==0)
                return false;
            b[c-'a']--;
        }
        return true;

    }

public class TestDemo {
    public static void main(String[] args) {

    }
}
