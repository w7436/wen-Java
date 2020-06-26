package Menu;

/**
 * @ClassName customer
 * @Description TODO
 * @Author DELL
 * @Data 2020/6/2 15:25
 * @Version 1.0
 **/

import factory.foodFactory;
import food.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * @ClassName customer
 * @Description TODO
 * @Author DELL
 * @Data 2020/6/2 11:47
 * @Version 1.0
 **/
public class customer {
    private foodFactory f;

    public customer(foodFactory f) {
        this.f = f;
    }
    private ArrayList<String> billList = new ArrayList<String>();

    public static ArrayList<Double> moneys  = new ArrayList<Double>();



    //打印小票文件
    public void showBill() throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("D://text.txt", true));
        bw.write("*****************************************************\r\n");
        bw.write("             **欢迎光临**             \r\n");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        bw.write("订餐时间："+df.format(new Date())+"\r\n");// new Date()为获取当前系统时间
        bw.write("名称 \t\t单价\t数量\t价格\r\n");
        for(String str:billList){
            bw.write(str);
            bw.newLine();//一行分割符
            bw.flush();//刷新流
        }
    }
    //显示订单
    public void outBill(){
        for(String str:billList){
            System.out.println(str);
        }
    }

    //获得汉堡
    public double getHamburg(int choose,int num){
        Hamburgers hamburg;
        hamburg = f.createHamburgers(choose,num);
        System.out.print(hamburg.print());
        billList.add(hamburg.print());

        return hamburg.totalPrice();
    }


    //获得饮料
    public double getDrink(int choose,int num){
        Drinkings beverage;
        beverage = f.createDrinkings(choose,num);
        System.out.print(beverage.print());
        billList.add(beverage.print());

        return beverage.totalPrice();
    }

    //获得炸鸡
    public double getChicken(int choose,int num){
        Chicken chicken;
        chicken = f.createChickens(choose,num);
        System.out.print(chicken.print());
        billList.add(chicken.print());

        return chicken.totalPrice();
    }
    //薯条
    public double getFires(int choose,int num){
        FrenchFries fires;
        fires = f.createFrenchFries(choose,num);
        System.out.print(fires.print());
        billList.add(fires.print());

        return fires.totalPrice();
    }
    //米饭
    public double getRices(int choose,int num){
        Rices rices;
        rices = f.createRices(choose,num);
        System.out.print(rices.print());
        billList.add(rices.print());

        return rices.totalPrice();
    }


    //获得套餐
    public double getSetMeal(int choose,int num) {
        Hamburgers hamburg;
        Chicken chicken;
        Drinkings drink;
        Rices rice;
        FrenchFries frenchFries;
        double money;
        if (1 == choose) {
            hamburg = f.createHamburgers(2, 1);
            drink = f.createDrinkings(2, 1);
            chicken = f.createChickens(1, 1);
            billList.add(hamburg.print());
            billList.add(drink.print());
            billList.add(chicken.print());
            money = Math.round(0.9 * (hamburg.totalPrice() + drink.totalPrice() + chicken.totalPrice()) * num);

            return money;
        } else if (2 == choose) {
            hamburg = f.createHamburgers(2, 1);
            drink = f.createDrinkings(2, 1);
            chicken = f.createChickens(1, 1);
            Rices rices = f.createRices(1,2);
            billList.add(hamburg.print());
            billList.add(drink.print());
            billList.add(chicken.print());
            billList.add(rices.print());
            money = Math.round(0.9 * (hamburg.totalPrice() + drink.totalPrice() + chicken.totalPrice() + rices.totalPrice()) * num);

            return money;
        } else {
            System.out.println("没有该套餐！！！");
            return 0;
        }
    }


}

