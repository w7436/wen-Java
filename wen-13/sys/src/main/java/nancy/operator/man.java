package nancy.operator;

import nancy.servlet.ManagerServlet;

import java.util.Scanner;

/**
 * @ClassName man
 * @Description TODO
 * @Author DELL
 * @Data 2020/7/1 18:50
 * @Version 1.0
 **/
public class man {
    public static void menu() {
        System.out.println("1、查看所有学生信息");
        System.out.println("2、查看所有课程信息");
        System.out.println("0、退出登录");
    }

    public static void select() throws Exception {
        Scanner sc = new Scanner(System.in);
        //进行登录操作进行身份验证
        System.out.print("请输入ID号：");
        int id = sc.nextInt();
        System.out.print("请输入密码：");
        String password = sc.next();
        if (ManagerServlet.login(id, password)) {
            boolean running = true;
            while(running){
                menu();
                System.out.println("请输入需要的业务：");
                int num = sc.nextInt();
                switch (num) {
                    case 1:
                        ManagerServlet.studnetsInfo();
                        break;
                    case 2:
                        ManagerServlet.courseInfo();
                        break;
                    case 0:
                        running = false;
                        break;
                    default:
                        return;
                }
            }


        } else {
            return;
        }


    }
}
