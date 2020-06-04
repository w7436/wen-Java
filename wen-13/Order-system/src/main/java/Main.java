import Dao.DaoTest;
import Menu.customer;
import Menu.menu;
import data.total;
import factory.foodFactory;
import factory.foodFactory1;

import java.io.IOException;
import java.util.Scanner;

/**
 * @ClassName Main
 * @Description TODO
 * @Author DELL
 * @Data 2020/6/2 12:52
 * @Version 1.0
 **/
public class Main {
    public static void main(String[] args) throws IOException {
        boolean flag = true;
        foodFactory fact = new foodFactory1();
        customer cust = new customer(fact);
        while(flag){
            new menu(fact,cust).Menu();
            double m = menu.SUM;
            total t = new total(m);
            t.setMoney(m);
            DaoTest.inserttotal(t);
            System.out.println("订餐选择y,完成订餐选择n");
            if("n".equals(new Scanner(System.in).next())){
                flag = false;
                System.out.println("正在为您处理订单食品，请稍后...");
            }
        }
    }
}
