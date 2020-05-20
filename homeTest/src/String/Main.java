package String;

import java.util.Scanner;

/**
 * @ClassName Main
 * @Description TODO
 * @Author DELL
 * @Data 2020/5/20 17:38
 * @Version 1.0
 **/
public class Main {

    /**
     * 给定一个字符串，能否添加一个字母将其变为回文
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String s = in.nextLine();
            int len = s.length();
            int i = 0;
            int j = len-1;
            String res = "YES";
            while(i <= j){
                //相等于在中间插入
                if(s.charAt(i) == s.charAt(j)){
                    i++;
                    j--;
                }else if(s.charAt(i) == s.charAt(j-1)){
                    j--;
                }else if(s.charAt(i+1) == s.charAt(j)){
                    i++;
                }else{
                    res = "NO";
                    break;
                }
            }
            System.out.println(res);
        }
    }
}
