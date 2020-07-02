package nancy.servlet;

import nancy.Dao.ManagerDao;
import nancy.Dao.courseDao;
import nancy.Dao.studentDao;
import nancy.Util.DBUtil;
import nancy.model.course;
import nancy.model.student;

import java.sql.Connection;
import java.util.List;

/**
 * @ClassName ManagerServlet
 * @Description TODO
 * @Author DELL
 * @Data 2020/7/1 15:46
 * @Version 1.0
 **/
public class ManagerServlet {

    public  static boolean login(int id,String password) throws Exception {
        Connection c = DBUtil.getConnection();
        if(ManagerDao.login(c,id,password)){
            return true;
        }else{
            return false;
        }
    }

    //查看所有学生信息
    public static void studnetsInfo(){
        Connection c = DBUtil.getConnection();
        List<student> l = studentDao.queryList(c);
        for(int i = 0;i < l.size();i++){
            System.out.println(l.get(0));
        }
    }
    //查看所有课程信息
    public static void courseInfo(){
        Connection c = DBUtil.getConnection();
        List<course> l = courseDao.query_course(c);
        for(int i = 0;i < l.size();i++){
            System.out.println(l.get(0));
        }
    }
}
