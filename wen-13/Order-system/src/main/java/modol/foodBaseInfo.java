package modol;

/**
 * @ClassName foodBaseInfo
 * @Description TODO
 * @Author DELL
 * @Data 2020/6/2 10:21
 * @Version 1.0
 **/
public abstract class foodBaseInfo {
    public String type;  //每个大种类下的具体种类
    public int num;      //数量
    public double price;  //价格

    //计算餐品总价
    public double totalPrice(){
        //return this.num * this.price;
        return num * price;
    }
}
