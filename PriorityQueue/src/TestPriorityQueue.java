import javax.smartcardio.Card;
import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

/**
 * @ClassName TestPriorityQueue
 * @Description TODO
 * @Author DELL
 * @Data 2020/3/25 16:50
 * @Version 1.0
 **/
class Card1 implements Comparable<Card1>{
    public int rank;
    public String suit;

    public Card1(int rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public int compareTo(Card1 o) {
        return rank - o.rank;
    }

    @Override
    public boolean equals(Object o) {
       if (this == o){
           return true;
       }
       if (o == null||!(o instanceof Card1)){
           return false;
       }
       Card1 card1 = (Card1) o;
       return rank == card1.rank&&suit.equals(card1.suit);
    }

}
//基于比较器
class CardComp implements Comparator<Card1>{
    @Override
    public int compare(Card1 o1, Card1 o2) {
        if (o1==o2){
            return 0;
        }
       if (o1 == null){
            return -1;
       }
       if (o2 == null){
            return 1;
       }
       return o2.rank - o1.rank;
    }
}
public class TestPriorityQueue {
    public static void TestPriorityQueue() {
        PriorityQueue<Card1> p =new PriorityQueue<Card1>();
        p.offer(new Card1(5,"♠"));
        p.offer(new Card1(6,"♠"));
        p.offer(new Card1(4,"♠"));

    }

    public static void TestPriorityQueue1() {
        int a = 10;
        int b = 20;
        System.out.println(a > b);
        System.out.println(a < b);
        System.out.println(a == b);

        char c1 = 'A';
        char c2 = 'B';
        System.out.println(c1 > c2);
        System.out.println(c1 < c2);
        System.out.println(c1 == c2);

        boolean b1 = true;
        boolean b2 = false;
        System.out.println(b1 == b2);
        System.out.println(b1 != b2);
    }

    public static void TestCompare(){
        Card1 c1 = new Card1(1,"♠");
        Card1 c2 = new Card1(2,"♠");
        Card1 c3 = c1;
        Card1 c4 = new Card1(1,"♠");
        if (c1.equals(c4)){
            System.out.println("c1==c4");
        }
        else{
            System.out.println("c1!=c4");
        }

        System.out.println(c1.compareTo(c2));
        System.out.println(c1 == c3);

    //    System.out.println(c1 == c4);

    }
    public static void Testcompare3(){
        Card1 c1 = new Card1(1,"♠");
        Card1 c2 = new Card1(2,"♠");
        Card1 c3 = c1;
        Card1 c4 = new Card1(1,"♠");
        CardComp comp = new CardComp();
        if (comp.compare(c1,c2) >0){
            System.out.println("c1>c2");
        }
        else if (comp.compare(c1,c2)==0){
            System.out.println("c1==c2");
        }
        else{
            System.out.println("c1<c2");
        }
    }
    public static void TestCompare4(){
        Card1 c1 = new Card1(1,"♠");
        Card1 c2 = new Card1(2,"♠");
        Card1 c3 = new Card1(5,"♠");
        Card1 c4 = new Card1(3,"♠");

        PriorityQueue <Card1>  p= new PriorityQueue<>(4);
        p.offer(c1);
        p.offer(c2);

        p.offer(c3);
        p.offer(c4);

        //大对
        PriorityQueue <Card1> p2 = new PriorityQueue<>(4);
        p2.offer(c1);
        p2.offer(c2);
        p2.offer(c3);
        p2.offer(c4);




    }
    public static void main(String[] args) {
//        TestPriorityQueue1();
        TestCompare4();

    }
}
