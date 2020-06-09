package bank;

import java.util.Date;
import java.util.Scanner;

/**
 * @ClassName Main
 * @Description TODO
 * @Author DELL
 * @Data 2020/6/9 15:00
 * @Version 1.0
 **/
public class Main {
    public static void menu(Account account){
        System.out.println("1、账户信息");
        System.out.println("2、存款");
        System.out.println("3、取款");
        System.out.println("4、退出菜单");
        System.out.print("请选择您需要的服务：");
        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();
        switch (choice){
            case 1:
                System.out.println("账户信息如下：");
                System.out.println(account.toString());

                break;
            case 2:
                System.out.println("存款操作如下");
                account.indoor(100);
                System.out.println(account.toString());
                break;
            case 3:
                System.out.println("取款信息如下：");
                account.outdoor(100);
                System.out.println(account.toString());
                break;
            case 4:
                System.out.println("退出菜单");
                break;
        }
    }
    public static void main(String[] args) {
        Account[] account = new Account[10];
        //初始化自定义类型，不然会报空指针异常
        for(int i = 0;i < 10;i++){
            account[i] = new Account();
        }
        //初始化ID和余额
        for(int i = 0;i < 10;i++){
            account[i].setId(i);
            account[i].setBalance(100);
            account[i].setAnnualIntegerRate(0.025);
            account[i].setDateCreated(new Date());
        }
        menu(account[0]);
//        Account account = new Account(1,1000,0.025,new Date());
//        CheckingAccount checkingAccount= new CheckingAccount(2,1000,0.025,new Date());
//        SavingAccount savingAccount = new SavingAccount(3,1000,0.025,new Date());
//        System.out.println(account.toString());
//        System.out.println(checkingAccount.toString());
//        System.out.println(savingAccount.toString());
    }
}