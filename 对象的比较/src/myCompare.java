import java.util.Comparator;

/**
 * @ClassName myCompare
 * @Description TODO
 * @Author DELL
 * @Data 2020/5/2 7:57
 * @Version 1.0
 **/

class Card {
    public int rank; // 数值
    public String suit; // 花色

    public Card(int rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }
}
public class myCompare implements Comparator<Card> {
    // 根据数值比较，不管花色
// 这里我们认为 null 是最小的

    @Override
    public int compare(Card o1, Card o2) {
        if (o1 == o2) {
            return 0;
        }
        if (o1 == null) {
            return -1;
        }
        if (o2 == null) {
            return 1;
        }
        return o1.rank - o2.rank;
    }

    public static void main(String[] args) {
        Card p = new Card(1, "♠");
        Card q = new Card(2, "♠");
        Card o = new Card(1, "♠");

        Comparator<Card> m= new myCompare();
        System.out.println(m.compare(p,q));//-1
        System.out.println(m.compare(p,o));//0
        System.out.println(m.compare(q,o));//1
    }
}



