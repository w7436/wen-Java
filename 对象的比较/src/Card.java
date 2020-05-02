/**
 * @ClassName Card
 * @Description TODO
 * @Author DELL
 * @Data 2020/5/2 7:58
 * @Version 1.0
 **/

//public class Card implements Comparable<Card>{
//    public int rank; // 数值
//    public String suit; // 花色
//    public Card(int rank, String suit) {
//        this.rank = rank;
//        this.suit = suit;
//    }
//
//
////    @Override
////    public boolean equals(Object o) {
////        if (this == o) return true;
////        if (o == null || getClass() != o.getClass()) return false;
////        Card card = (Card) o;
////        return rank == card.rank &&
////                Objects.equals(suit, card.suit);
////    }
//
//    @Override
//    public int compareTo(Card o) {
//        if (o == null) {
//            return 1;
//        }
//        return rank - o.rank;
//    }
//    public static void main(String[] args) {
//        Card p = new Card(1, "♠");
//        Card q = new Card(2, "♠");
//        Card o = new Card(1, "♠");
//
////        System.out.println(p.equals(q));
//        System.out.println(p.compareTo(q));//-1
//        System.out.println(p.compareTo(o));//0
//        System.out.println(q.compareTo(o));//1
//    }
//}


//    public class CardComparator implements Comparator<Card> {
//        // 根据数值比较，不管花色
//// 这里我们认为 null 是最小的
//        @Override
//        public int compare(T o1, T o2) {
//            if (o1 == o2) {
//                return 0;
//            }
//            if (o1 == null) {
//                return -1;
//            }
//            if (o2 == null) {
//                return 1;
//            }
//            return o1.rank - o2.rank;
//        }
//    }
//    public static void main(String[] args) {
//
//        Card p = new Card(1, "♠");
//        Card q = new Card(2, "♠");
//        Card o = new Card(1, "♠");
//        Comparator<Card> c = new Card();
//        System.out.println();
//    }
//
//
//}
