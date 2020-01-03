import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 * @ClassName CardDemo
 * @Description TODO
 * @Author DELL
 * @Data 2020/1/3 16:55
 * @Version 1.0
 **/
class Card{
    public Card(String suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }
    private String suit;//花色
    private int rank;// 拍面值
    @Override
    public String toString() {
        String strNUm=String.format("%d",rank);
           switch (rank){
               case 11:
                   strNUm="J";
                   break;
               case 12:
                   strNUm="Q";
                   break;
               case 13:
                   strNUm="K";
                   break;
           }
        return suit+":"+strNUm;
    }
}
class CardDeam{

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

    //洗牌
    public void shuffleCard(List<Card> cards){
        for (int i=cards.size()-1;i>0;i--){
            //从[0,i)区间随机取一张牌
            //常见设置种子方式：获取当前系统的时间
            Random r=new Random(201912);
            int j=r.nextInt(i);
            swap(cards,i,j);
        }
    }

    private void swap(List<Card> cards, int i, int j) {
        Card temp=cards.get(i);
        cards.set(i,cards.get(j));
        cards.set(j,temp);
    }
}

public class CardDemo {
    public static void main(String[] args) {
        CardDeam cd=new CardDeam();
        List<Card> L=cd.BuyDeck();
        System.out.println(L);
        cd.shuffleCard(L);
        System.out.println(L);

        //3个人 每个人模5张牌
        List<List<Card>> hands=new ArrayList<>();
        for (int i=0;i<3;i++){
            hands.add(new ArrayList<>());
        }
        for (int i = 0; i <5 ; i++) {
            for (int j = 0; j <3 ; j++) {
                Card card=L.remove(0);
                hands.get(j).add(card);
            }
        }
        //打印
        for (int i = 0; i <hands.size(); i++) {
            System.out.println(hands.get(i));
        }
        System.out.println(L.size());
        System.out.println(L);
    }
}
