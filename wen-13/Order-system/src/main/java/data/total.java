package data;

import Menu.customer;

/**
 * @ClassName money
 * @Description TODO
 * @Author DELL
 * @Data 2020/6/2 15:40
 * @Version 1.0
 **/

public class total {
    public double money;

    static public double other(){
        return customer.moneys.get(0);
    }


    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
