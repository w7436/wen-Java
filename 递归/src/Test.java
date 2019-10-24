/**
 * @ClassName Test
 * @Description TODO
 * @Author DELL
 * @Data 2019/10/16 21:14
 * @Version 1.0
 **/

public class Test {
        /**
         * 调试：所有的方法都是在栈中调用的，都会占据栈的空间
         * @param
         */
        public static int fun(int n){
            if(n==1){
                return 1;
            }
            else {
                return n+fun(n-1);
            }
        }
        //获取数字的每一位
        public static void sin(int n){
            if (n>9){
                sin(n/10);
            }
            System.out.println(n%10);
        }
        //每一位数字的加和
        public static int sum(int num){
            if (num<10){
                return  num;
            }
            return num%10+sum(num/10);
        }
        //斐波那契(非递归)
        public static int fic(int n){
            int sum=0;
            int f1=1,f2=1,f3=1;
            int i=3;
            while(i<=n){
                f3=f1+f2;
                f1=f2;
                f2=f3;
                i++;
            }
            return f3;
        }
        //青蛙跳台阶
        public static int forgJump(int n){
            if(n==1){
                return 1;
            }
            if (n==2){
                return 2;
            }
            return forgJump(n-1)+forgJump(n-2);
        }
        public static void main(String[] args) {

            System.out.println(forgJump(4));

            //System.out.println(fic(3));

            //System.out.println(sum(123));

            // System.out.println(fun(100));/
            //sin(123);
        }
}

