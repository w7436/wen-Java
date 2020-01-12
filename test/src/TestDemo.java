import java.util.HashSet;
import java.util.Set;

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
public class TestDemo {
    public static void main(String[] args) {

    }
}
