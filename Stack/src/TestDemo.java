import java.util.Stack;
import java.lang.String;
/**
 * @ClassName TestDemo
 * @Description TODO
 * @Author DELL
 * @Data 2020/1/4 9:50
 * @Version 1.0
 **/

/*括号匹配*/
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        for (int i=0;i<s.length();i++){
            char left=s.charAt(i);  //拿到第一个字符
            if(left=='('||left=='['||left=='{'){ //如果是左括号则入栈
                stack.push(left);
            }
            else{ //如果是右括号则进行匹配
                if (stack.isEmpty()){ //如果栈为空，则说明右括号比左括号多
                    return false;
                }
                else{//栈不为空，则进行匹配
                    if (left==')'&&stack.peek()=='('
                            ||left==']'&&stack.peek()=='['
                            ||left=='}'&&stack.peek()=='{'){
                        stack.pop();
                    }
                    else{
                        return false;
                    }
                }
            }
        }
        if (stack.isEmpty()){
            return true;
        }else{
            return false;
        }

    }



//后缀表达式求值
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack=new Stack<>();
        for (String s:tokens) {
            if (s.equals("+")){
                stack.push(stack.pop()+stack.pop());
            }else if (s.equals("-")){
                stack.push(-stack.pop()+stack.pop());
            }else if (s.equals("*")){
                stack.push(stack.pop()*stack.pop());
            }else if(s.equals("/")){
                int num1=stack.pop();
                stack.push(num1/stack.pop());
            }
            else{
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }

}


public class TestDemo {
    public static void main(String[] args) {



    }
}
