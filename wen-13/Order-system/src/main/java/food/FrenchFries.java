package food;

import modol.foodBaseInfo;
import modol.singlefood;

/**
 * @ClassName FrenchFries
 * @Description TODO
 * @Author DELL
 * @Data 2020/6/2 10:40
 * @Version 1.0
 **/
public class FrenchFries extends foodBaseInfo implements singlefood {

    public String print() {
        return(this.type+"\t"+this.price+"\t"+this.num+"\t");
    }
}