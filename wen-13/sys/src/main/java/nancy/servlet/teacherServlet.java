package nancy.servlet;

import nancy.Dao.teacherDao;
import nancy.Util.DBUtil;
import nancy.model.student;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName teeacherServlet
 * @Description TODO
 * @Author DELL
 * @Data 2020/7/1 15:46
 * @Version 1.0
 **/
public class teacherServlet {
    public static Scanner sc = new Scanner(System.in);
    public  static boolean login(int id,String password) throws Exception {
        Connection c = DBUtil.getConnection();
        if(teacherDao.login(c,id,password)){
            return true;
        }else{
            return false;
        }
    }
    //查看个人信息
    public static void qureySelf(int id) throws Exception {
        Connection c = DBUtil.getConnection();
        System.out.println(teacherDao.self(c,id));
    }
    //修改密码
    public static void update(int id) throws Exception {
        Connection c = DBUtil.getConnection();
        System.out.print("请输入修改后的密码:");
        String password = sc.nextLine();
        if(teacherDao.teacherUpdate(c,id,password) > 0){
            System.out.println("修改密码成功!");
        }else{
            System.out.println("修改密码失败!");
        }

    }
    //查看自己所带课程的学生信息
    public static void infosudent(int id){
        Connection c = DBUtil.getConnection();
        List<student> l = teacherDao.querystudent(c,id);
        for(int i = 0;i < l.size();i++){
            System.out.println(l.get(i));
        }

    }


}
