/**
 * @ClassName TestDemo1
 * @Description TODO
 * @Author DELL
 * @Data 2019/12/2 20:00
 * @Version 1.0
 **/
public class TestDemo1 {
    public static void main(String[] args) {
        StringBuilder sb=new StringBuilder("ab");

    }
    public static void main2(String[] args) {

        //String str="ab";
        StringBuilder sb=new StringBuilder("ab");
        for (int i = 0; i <1000 ; i++) {
           // str+=i;
            // str=str+i;
            sb.append(i);
            //sb.append(i).append(8);
        }
        System.out.println(sb);
//        String str="abcdef";
//        str=str+"gh";
//        System.out.println(str);
//        StringBuilder sb=new StringBuilder();
//        sb.append("abcdef");
//        sb.append("gh");
//        String str=sb.toString();
//        System.out.println(str);

    }
    /**
     * 字符串String的+ 拼接 底层被优化为StringBuilder
     * append();
     * toString();
     *
     * */
    public static void main1(String[] args) {
//        String str="abcdef";
//        str=str+"gh";
//        System.out.println(str);


//        StringBuilder sb=new StringBuilder("abc");
//        System.out.println(sb);
//        sb.append("222");
//        System.out.println(sb);
    }
}
