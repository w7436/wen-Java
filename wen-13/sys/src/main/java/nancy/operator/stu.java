package nancy.operator;

import nancy.servlet.studentServlet;

import java.util.Scanner;

/**
 * @ClassName stu
 * @Description TODO
 * @Author DELL
 * @Data 2020/7/1 18:50
 * @Version 1.0
 **/
public class stu {
    public static void menu(){

        System.out.println("1、查看个人信息");
        System.out.println("2、修改密码");
        System.out.println("3、选课");
        System.out.println("4、查看课程");
        System.out.println("5、查看课程时间");
        System.out.println("0、退出登录");
    }
    public static void select() throws Exception {
        Scanner sc = new Scanner(System.in);
            //进行登录操作进行身份验证
        boolean flag = true;
        while(flag){
            System.out.print("请输入你的学号：");
            int id = sc.nextInt();
            System.out.print("请输入密码：");
            String password = sc.next();
            if(studentServlet.login(id,password)){
                boolean running = true;
                while(running){
                    menu();
                    System.out.println("请输入需要的业务：");
                    int num = sc.nextInt();
                    switch(num){
                        case 1:
                            studentServlet.qureySelf(id);
                            break;
                        case 2:
                            studentServlet.update(id);
                            break;
                        case 3:
                            studentServlet.select(id);
                            break;
                        case 4:
                            studentServlet.courseList();
                            break;
                        case 5:
                            studentServlet.teachList();
                            break;
                        case 0:
                            running = false;
                            break;
                        default:
                            return;
                    }
                }
                flag = false;
            }else {
                flag = true;
            }



        }
    }
}
