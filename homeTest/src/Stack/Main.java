package Stack;

import java.util.LinkedList;

/**
 * @ClassName Main
 * @Description TODO
 * @Author DELL
 * @Data 2020/5/28 11:30
 * @Version 1.0
 **/
public class Main {
    /**
     * 字符串解码
     *
     * s = "3[a]2[bc]", 返回 "aaabcbc".
     * s = "3[a2[c]]", 返回 "accaccacc".
     * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
     *
     * 利用辅助栈的思想
     * 遍历整个字符串
     */
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        int multi = 0;//将字符数组转化为数字
        LinkedList<Integer> stack_multi = new LinkedList<>();//记录字符数字
        LinkedList<String> stack_res = new LinkedList<>();//记录字符
        for(Character c : s.toCharArray()) {
            //将当前的字符和数字入栈
            if(c == '['){
                stack_multi.addLast(multi);
                stack_res.addLast(res.toString());
                multi=0;
                res = new StringBuilder();

            }
            //进行出栈
            else if(c == ']'){
                StringBuilder tmp = new StringBuilder();
                int num = stack_multi.pollLast();
                tmp.append(stack_res.pollLast());
                for(int i = 0;i < num;i++) {
                    tmp.append(res);
                }
                res = new StringBuilder(tmp);
            }else if(c > '0' && c < '9'){
                multi = multi*10+Integer.parseInt(c+"");//超过两位数的字符
            }else{
                res.append(c);
            }
        }
        return res.toString();
    }
}
