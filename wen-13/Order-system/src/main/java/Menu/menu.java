package Menu;

import factory.foodFactory;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * @ClassName menu
 * @Description TODO
 * @Author DELL
 * @Data 2020/6/2 12:03
 * @Version 1.0
 **/
public class menu {
    Scanner input = new Scanner(System.in);
    private foodFactory factory;
    private customer cust;
    private double hamburgMoney;
    private double ChickenMoney;
    private double DrinkMoney;
    private double FrenchFiresMoney;
    private double RicesMoneny;
    private double setMealMoney;
    private double sumMoney;
    public static double SUM = 0;


    public menu(foodFactory factory, customer cust) {
        this.factory = factory;
        this.cust=cust;
    }



    //欢迎界面
    public  void Menu() throws IOException {
        System.out.println("  ***  1.开始点餐   *** ");
        System.out.println("    ** 2.退出系统  **   ");
        System.out.print("请选择>");
        int choose = input.nextInt();
        switch (choose){
            case 1:
                productionMenu();
                int pay = payMoney(cust,getMoney());
                printBill(cust,getMoney(),pay);
                break;
            case 2:
                System.out.println("您已成功退出点餐系统...");
            default:
                System.out.println("选择错误....");
        }
    }

    //食物产品界面
    public void productionMenu() throws IOException {
        boolean flag = true;
        while(flag == true){
            System.out.println("当前商品如下：");
            System.out.println("==================");
            System.out.println("1.汉堡");
            System.out.println("==================");
            System.out.println("2.薯条");
            System.out.println("==================");
            System.out.println("3.饮料");
            System.out.println("==================");
            System.out.println("4.烤鸡");
            System.out.println("==================");
            System.out.println("5.米饭");
            System.out.println("==================");
            System.out.println("6.套餐");
            System.out.println("==================");
            System.out.println("7.结束订餐，查看订单");
            System.out.println("==================");
            System.out.print("请选择>");
            int choose = input.nextInt();
            switch (choose){
                case 1:
                    hamburgMenu();
                    break;
                case 2:
                    FiresCreamMenu();
                    break;
                case 3:
                    DrinkMenu();
                    break;
                case 4:
                    ChickenMenu();
                    break;
                case 5:
                    RiceMenu();
                    break;
                case 6:
                    setMeal();
                    break;
                case 7:
                    double money = getMoney();
                    showBills(cust,money);
                    break;
                default:
                    System.out.println("选择错误...");
            }
            if(choose == 7){
                flag = false;
            }
        }


    }
    //汉堡菜单界面
    public void hamburgMenu(){
        System.out.println("1.香辣鸡腿堡-----------25元");
        System.out.println("2.鸡腿堡--------15元");
        System.out.print("请选择>");
        int choose = input.nextInt();
        System.out.print("请输入数量>");
        int num = input.nextInt();
        hamburgMoney = cust.getHamburg(choose,num);
    }
    //薯条
    public void FiresCreamMenu(){
        System.out.println("1.薯条-----------5元");
        System.out.print("请选择>");
        int choose = input.nextInt();
        System.out.print("请输入数量>");
        int num = input.nextInt();
        FrenchFiresMoney = cust.getFires(choose,num);
    }
    public void  DrinkMenu(){
        System.out.println("1.可乐-----------2元");
        System.out.println("2.红茶-----------5元");
        System.out.print("请选择>");
        int choose = input.nextInt();
        System.out.print("请输入数量>");
        int num = input.nextInt();
        DrinkMoney = cust.getDrink(choose,num);
    }
    public void  ChickenMenu(){
        System.out.println("1.吮指原味鸡-----------15元");
        System.out.println("2.香辣鸡翅-------------10元");
        System.out.print("请选择>");
        int choose = input.nextInt();
        System.out.print("请输入数量>");
        int num = input.nextInt();
        ChickenMoney = cust.getChicken(choose,num);
    }
    public void RiceMenu(){
        System.out.println("1.海苔盐烧大鸡腿饭-----------20元");
        System.out.println("2.川辣泡椒鸡块饭-------------25元");
        System.out.print("请选择>");
        int choose = input.nextInt();
        System.out.print("请输入数量>");
        int num = input.nextInt();
        RicesMoneny = cust.getRices(choose,num);
    }
    public void setMeal(){
        System.out.println("1.儿童套餐------32元");
        System.out.println("2.情侣套餐------68元");
        System.out.print("请选择>");
        int choose = input.nextInt();
        System.out.print("请输入数量>");
        int num = input.nextInt();
        setMealMoney = cust.getSetMeal(choose,num);
    }


    //获得总金额
    public double getMoney(){
        sumMoney = hamburgMoney+RicesMoneny+DrinkMoney+FrenchFiresMoney+ChickenMoney+setMealMoney;
        SUM = sumMoney;
        return sumMoney;
    }





    //打印账单
    public static void printBill(customer cust, double sumMoney, int pay) throws IOException {
        cust.showBill();
        BufferedWriter bw=new BufferedWriter(new FileWriter("D://text.txt",true));
        bw.write("总计: "+sumMoney);
        bw.newLine();
        bw.write("付款："+pay);
        bw.newLine();
        double y=pay-sumMoney;
        bw.write("找零："+y);
        bw.newLine();
        bw.write("当前收银员：小绿\r\n");
        bw.write("                         欢迎下次光临！^_^                        \r\n");
        bw.write("******************************************************\r\n");
        bw.flush();
        bw.close();
    }

    //显示订单
    public static void  showBills(customer cust,double sumMoney) throws IOException {
        cust.outBill();
        System.out.println("总计："+sumMoney);

    }


    //付款界面
    public int payMoney(customer cust, double sumMoney){
        while(true){
            System.out.print("请输入付款金额:");
            int pay=input.nextInt();
            if(pay-sumMoney >= 0){
                if(pay >= 100){
                    System.out.println("您要使用优惠卷结账吗？（y/n）");
                    System.out.println("优惠卷：满100减20，满200减30！！！");
                    if(input.next().equals("y")){
                        if(pay >= 200){
                            System.out.println("找零:"+(pay-sumMoney+30));
                        }else {
                            System.out.println("找零:"+(pay-sumMoney+20));
                        }
                    }else{
                        System.out.println("找零:"+(pay-sumMoney));
                    }
                }else{
                    System.out.println("找零:"+(pay-sumMoney));
                }
            }else{
                System.out.println("不够哦!!!");
            }
            return pay;
        }
    }

}

