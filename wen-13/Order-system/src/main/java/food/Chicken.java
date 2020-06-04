package food;

import modol.foodBaseInfo;
import modol.singlefood;

/**
 * @ClassName Chicken
 * @Description TODO
 * @Author DELL
 * @Data 2020/6/2 11:23
 * @Version 1.0
 **/
public class Chicken extends foodBaseInfo implements singlefood {

    public String print() {
        return(this.type+"\t"+this.price+"\t"+this.num+"\t");
    }
}
