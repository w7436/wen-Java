package food;

import modol.foodBaseInfo;
import modol.singlefood;

/**
 * @ClassName Hamburgers
 * @Description TODO
 * @Author DELL
 * @Data 2020/6/2 10:29
 * @Version 1.0
 **/
public class Hamburgers extends foodBaseInfo implements singlefood {

    public String print() {
        return(this.type+"\t"+this.price+"\t"+this.num+"\t");
    }
}


