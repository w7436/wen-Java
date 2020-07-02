package nancy.servlet;

import nancy.Dao.courseDao;
import nancy.Dao.selectingDao;
import nancy.Dao.studentDao;
import nancy.Dao.teachingDao;
import nancy.Util.DBUtil;
import nancy.model.course;
import nancy.model.student;
import nancy.model.teaching;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName stuervlet
 * @Description TODO
 * @Author DELL
 * @Data 2020/7/1 15:45
 * @Version 1.0
 **/
public class studentServlet {

    public static Scanner sc = new Scanner(System.in);
    public  static boolean login(int id,String password) throws Exception {
        Connection c = DBUtil.getConnection();
        if(studentDao.login(c,id,password)){
            return true;
        }else{
            return false;
        }
    }

    //查看课程信息
    public  static void courseList(){
        Connection c = DBUtil.getConnection();
        List<course> l = courseDao.query_course(c);
        for(int i = 0;i < l.size();i++){
            System.out.println(l.get(i));
        }
    }
    //查看授课信息
    public static void teachList(){
        Connection c = DBUtil.getConnection();
        List<teaching> l = teachingDao.query(c);
        for(int i = 0;i < l.size();i++){
            System.out.println(l.get(i));
        }
    }
    //查看个人信息
    public static void qureySelf(int id) throws Exception {
        Connection c = DBUtil.getConnection();
        student stu = studentDao.qustudent(c,id);
        System.out.println(stu);
    }

    //修改密码
    public static void update(int id) throws Exception {
        Connection c = DBUtil.getConnection();
        System.out.print("请输入修改后的密码:");
        String password = sc.nextLine();
        if(studentDao.studentUpdate(c,id,password)){
            System.out.println("修改密码成功!");
        }else{
            System.out.println("修改密码失败!");
        }

    }
    //选课
    public static void select(int id) throws Exception {
        Connection c = DBUtil.getConnection();
        System.out.print("请输入选择的课程号：");
        int c_id = sc.nextInt();
        if(selectingDao.addStudentCourse(c,id,c_id)>0){
            System.out.println("选课成功");
        }else{
            System.out.println("选课失败");
        }
    }








}
