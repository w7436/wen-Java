package com.bit;

import com.bit.book.Booklist;
import com.bit.user.Admin;
import com.bit.user.NormalUser;
import com.bit.user.User;

import java.util.Scanner;

/**
 * @ClassName Main
 * @Description TODO
 * @Author DELL
 * @Data 2019/11/16 11:37
 * @Version 1.0
 **/
public class Main {
    //登录
    public static User login(){
        System.out.println("请输入你的名字：");
        Scanner scanner =new Scanner(System.in);
        String name=scanner.nextLine();
        System.out.println("请输入你的身份（1.管理员，2.用户）");
        int who=scanner.nextInt();
        if (who==1){
            return new Admin(name);
        }else{
            return new NormalUser(name);
        }

    }
    public static void main(String[] args) {
        Booklist booklist=new Booklist();
        User user=login();
        while(true){
            int ch= user.menu();
            user.doOperation(ch,booklist);
        }
    }
}
