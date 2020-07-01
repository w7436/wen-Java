package nancy.DAO;

import nancy.exception.SystemException;
import nancy.modol.Student;
import nancy.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName StuDao
 * @Description TODO
 * @Author DELL
 * @Data 2020/6/17 9:36
 * @Version 1.0
 **/
public class StuDao {

    //插入数据
    public static boolean insert(Student student) {
        Connection c = DBUtil.getConnection();
        PreparedStatement ps = null;
        String sql ="insert into stu(id,name,depart,score) values (?,?,?,?)";

        try {
            ps = c.prepareStatement(sql);
            ps.setInt(1,student.getId());
            ps.setString(2,student.getName());
            ps.setString(3,student.getDepartment());
            ps.setInt(4,student.getScore());
            int line = ps.executeUpdate();
            return line > 0 ? true : false;
        } catch (SQLException e) {
            throw new SystemException(e,"插入学生信息出错");
        }finally {
            DBUtil.close(c,ps);
        }
    }
    //根据ID号对学生的姓名和成绩进行更改
    public static boolean update(Student student) {
        Connection c = DBUtil.getConnection();
        PreparedStatement ps = null;
        String sql ="update stu set name = ?,score = ? where id = ?";

        try {
            ps = c.prepareStatement(sql);
            ps.setString(1,student.getName());
            ps.setInt(2,student.getScore());
            ps.setInt(3,student.getId());
            int line = ps.executeUpdate();
            return line > 0 ? true : false;
        } catch (SQLException e) {
            throw new SystemException(e,"修改学生信息出错");
        } finally {
            DBUtil.close(c,ps);
        }
    }

    //删除数据，根据id号进行删除，可以一次删除多组数据
    public static boolean delete(int[] ids) {
        Connection c = DBUtil.getConnection();
        PreparedStatement ps = null;
        StringBuilder sql =new StringBuilder("delete from stu where id in (");
        for(int i = 0;i <ids.length;i++){
            if(i >0){
                sql.append(",");
            }
            sql.append("?");
        }
        sql.append(")");
        try {
            ps = c.prepareStatement(sql.toString());
            for(int i = 0;i <ids.length;i++){
                ps.setInt(i+1,ids[i]);
            }
            int line = ps.executeUpdate();
            return line > 0 ? true : false;
        } catch (SQLException e) {
            throw new SystemException(e,"删除学生信息章出错");
        } finally {
            DBUtil.close(c,ps);
        }
    }


    //根据学生的Id号进行查询
    public static Student query(Integer stuId) {
        Connection c = DBUtil.getConnection();
        PreparedStatement  p =null;
        ResultSet r = null;
        String sql ="select id,name,depart,score" +
                " from stu where id = ?" ;
        Student student = null;
        try {
            p = c.prepareStatement(sql);
            p.setInt(1,stuId);
            r = p.executeQuery();
            while(r.next()){
                student = new Student();
                //文章设置属性
                student.setId(stuId);
                student.setName(r.getString("name"));
                student.setDepartment(r.getString("depart"));
                student.setScore(r.getInt("score"));


            }
            return student;
        } catch (SQLException e) {
            throw new SystemException("根据Id号查询学生详情出错");
        } finally {
            DBUtil.close(c,p,r);
        }

    }

    //查看学生信息
    public static List<Student> select() {
        Connection c = DBUtil.getConnection();
        PreparedStatement  p =null;
        ResultSet r = null;
        String sql ="select id,name,depart,score " +
                "from stu" ;
        List<Student> list = new ArrayList<Student>();
        try {
            p = c.prepareStatement(sql);
            r = p.executeQuery();
            while(r.next()){
                Student student = new Student();
                student.setId(r.getInt("id"));
                student.setName(r.getString("name"));
                student.setDepartment(r.getString("depart"));
                student.setScore(r.getInt("score"));
                list.add(student);
            }
            return list;
        } catch (SQLException e) {
            throw new SystemException("根据Id号查询学生详情出错");
        } finally {
            DBUtil.close(c,p,r);
        }

    }

    //根据学生姓名进行查询
    public static Student query(String stuName) {
        Connection c = DBUtil.getConnection();
        PreparedStatement  p =null;
        ResultSet r = null;
        String sql ="select id,name,depart,score" +
                " from stu where name = ?" ;
        Student student = null;
        try {
            p = c.prepareStatement(sql);
            p.setString(1,stuName);
            r = p.executeQuery();
            while(r.next()){
                student = new Student();
                //文章设置属性
                student.setId(r.getInt("id"));
                student.setName(stuName);
                student.setDepartment(r.getString("depart"));
                student.setScore(r.getInt("score"));

            }
            return student;
        } catch (SQLException e) {
            throw new SystemException("根据学生姓名查询学生详情出错");
        } finally {
            DBUtil.close(c,p,r);
        }

    }


    //根据学生的成绩区段号进行查询
    public static List<Student> query(int low,int high) {
        Connection c = DBUtil.getConnection();
        PreparedStatement  p =null;
        ResultSet r = null;//结果集合对象，封装数据库的查询结果
        String sql ="select id,name,depart,score from stu where score between ? and ?" ;
        List<Student> list = new ArrayList<Student>();
        try {
            p = c.prepareStatement(sql);
            p.setInt(1,low);
            p.setInt(2,high);
            r = p.executeQuery();//执行数据库查询语句，并且返回结果集
            while(r.next()){//让光标向下移动一次，并判断是否有值，有值则返回真，继续循环
                Student student = new Student();
                //文章设置属性
                student.setId(r.getInt("id"));
                student.setName(r.getString("name"));
                student.setDepartment(r.getString("depart"));
                student.setScore(r.getInt("score"));
                list.add(student);
            }
            return list;
        } catch (SQLException e) {
            throw new SystemException("根据成绩区段查询学生详情出错");
        } finally {
            DBUtil.close(c,p,r);
        }
    }

    //根据不同系的学生成绩排序
    public static List<Student> query1(String depart) {
        Connection c = DBUtil.getConnection();
        PreparedStatement  p =null;
        ResultSet r = null;//结果集合对象，封装数据库的查询结果
        String sql ="select id,name,depart,score from stu where depart = ? order by score desc" ;
        List<Student> list = new ArrayList<Student>();
        try {
            p = c.prepareStatement(sql);
            p.setString(1,depart);
            r = p.executeQuery();//执行数据库查询语句，并且返回结果集
            while(r.next()){//让光标向下移动一次，并判断是否有值，有值则返回真，继续循环
                Student student = new Student();
                //学生设置属性
                student.setId(r.getInt("id"));
                student.setName(r.getString("name"));
                student.setDepartment(r.getString("depart"));
                student.setScore(r.getInt("score"));
                list.add(student);
            }
            return list;
        } catch (SQLException e) {
            throw new SystemException("学生详情出错");
        } finally {
            DBUtil.close(c,p,r);
        }
    }

}
