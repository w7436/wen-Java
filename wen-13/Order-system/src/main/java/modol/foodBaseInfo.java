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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    //计算餐品总价
    public double totalPrice(){
        //return this.num * this.price;
        return num * price;
    }
}
