package food;

import modol.foodBaseInfo;
import modol.singlefood;

/**
 * @ClassName Drinkings
 * @Description TODO
 * @Author DELL
 * @Data 2020/6/2 11:35
 * @Version 1.0
 **/
public class Drinkings extends foodBaseInfo implements singlefood {
    public String print() {
        return(this.type+"\t"+this.price+"\t"+this.num+"\t");
    }
}
