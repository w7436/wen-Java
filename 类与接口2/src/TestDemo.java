import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName TestDemo
 * @Description TODO
 * @Author DELL
 * @Data 2019/12/24 22:49
 * @Version 1.0
 **/
/*
public class TestDemo {
    public static void main(String[] args) {
        List<Integer> L=new LinkedList<>();
        L.add(1);
        L.add(2);
        L.add(3);
        System.out.println(L);
        System.out.println(L.size());

        System.out.println(L.get(0));

        //任意位置的插入
        L.add(0,0);
        System.out.println(L);

        L.remove(1);
        System.out.println(L);

        if (L.contains(1)){
            System.out.println("remove:失败");
        }
        else{
            System.out.println("remove:成功");
        }

        L.add(0);
        System.out.println(L.indexOf(0));
        System.out.println(L.lastIndexOf(0));

        List<Integer> ret=L.subList(1,3);
        System.out.println(ret);
    }
    public static void main1(String[] args) {
        ArrayList<String> L1=new ArrayList<>();
        List<String> L2=new ArrayList<>();

        L1.add("1111");
        L1.add("2222");
        L1.add("2222");
        L1.add("2222");

        L2.add("1111");
        L2.add("1111");
        L2.add("1111");



    }

}
*/
class Card{
    private String suit;//代表牌的花色
    private int rank;//代表牌面值

    public Card(String suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public String toString() {
        String strNum=String.format("%d",rank);
        switch (rank){
            case 11:
                strNum="J";
                break;
            case 12:
                strNum="Q";
                break;
            case 13:
                strNum="K";
                break;
        }
        return suit+":"+strNum;
    }
}
class CardDeam{
    //构造一副扑克牌
    String Color[]={"♥","♦","♣","♠"};

    public List<Card> BuyDeck(){
        List<Card> cards=new ArrayList<>();
        for (int i = 0; i <4 ; i++) {
            for (int j = 1; j <14 ; j++) {
                Card c=new Card(Color[i],j);
                cards.add(c);
            }
        }
        return cards;
    }
}
public class TestDemo {
    public static void main(String[] args) {

    }
}