package nancy.Dao;

import nancy.Util.DBUtil;
import nancy.exception.SystemException;
import nancy.model.student;
import nancy.model.teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName teacherDao
 * @Description TODO
 * @Author DELL
 * @Data 2020/7/1 14:54
 * @Version 1.0
 **/
public class teacherDao {
    public static  boolean login(Connection con,int id,String password)throws Exception{

        String sql="select * from teacher where Id =? and password=?";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setInt(1, id);
        pstmt.setString(2, password);
        ResultSet rs=pstmt.executeQuery();
        if(!rs.next()) {
            System.out.println("登录失败");
            return false;
        }else{
            System.out.println("登录成功");
            return true;
        }
    }
    public static teacher self(Connection c,int id)throws Exception{
        PreparedStatement p =null;
        ResultSet r = null;
        String sql ="select * from teacher where Id = ? ";
        teacher tea = new teacher();
        try {
            p = c.prepareStatement(sql);
            p.setInt(1,id);
            r = p.executeQuery();
            while(r.next()){
                tea.setId(id);
                tea.setName(r.getString("name"));
                tea.setSex(r.getString("sex"));
                tea.setPassword(r.getString("password"));
                tea.setTask(r.getString("task"));
                tea.setPhone(r.getString("phone"));
                tea.setEmail(r.getString("email"));
            }
            return tea;
        } catch (SQLException e) {
            throw new SystemException("查询出错");
        } finally {
            DBUtil.close(c,p,r);
        }
    }


    //学生信息查询
    public static List<teacher> queryList(Connection c){
        PreparedStatement p =null;
        ResultSet r = null;
        String sql ="select * from teacher ";
        List<teacher> list = new ArrayList<teacher>();
        try {
            p = c.prepareStatement(sql);
            r = p.executeQuery();
            while(r.next()){
                teacher tea = new teacher();
                tea.setId(r.getInt("Id"));
                tea.setName(r.getString("name"));
                tea.setSex(r.getString("sex"));
                tea.setTask(r.getString("task"));
                tea.setPhone(r.getString("phone"));
                tea.setPassword(r.getString("password"));
                tea.setEmail(r.getString("email"));
                list.add(tea);
            }
            return list;
        } catch (SQLException e) {
            throw new SystemException("查询出错");
        } finally {
            DBUtil.close(c,p,r);
        }
    }
    //学生添加
    public static int studentAdd(Connection con,teacher tea)throws Exception{
        String sql="insert into teacher values(null,?,?,?,?,?,?)";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setString(1, tea.getName());
        pstmt.setString(2, tea.getSex());
        pstmt.setString(3,tea.getTask());
        pstmt.setString(4,tea.getPhone());
        pstmt.setString(5,tea.getPassword());
        pstmt.setString(6,tea.getEmail());
        return pstmt.executeUpdate();
    }

    //更改学生密码
    public static int teacherUpdate(Connection con,int id,String password)throws Exception{
        String sql="update teacher set password=? where Id=?";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setString(1, password);
        pstmt.setInt(2, id);
        return pstmt.executeUpdate();

    }

    /**
     * 学生删除
     * @param con
     * @param id
     * @return
     * @throws Exception
     */
    public static int studentDelete(Connection con,int id)throws Exception{
        String sql="delete from teacher where Id=?";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setInt(1, id);
        return pstmt.executeUpdate();
    }

    //查询自己所带学生
    public static List<student> querystudent (Connection c,int id){
        PreparedStatement p =null;
        ResultSet r = null;
        String sql="select student.Id,student.name,student.sex,student.bithday,student.depart,student.phone,student.depart,student.email " +
                "from student,course,teacher,teaching,selecting " +
                "where selecting.s_Id = student.Id and selecting.c_Id = course.Id " +
                " and teaching.c_Id = course.Id and teaching.t_Id =?";
        List<student> list = new ArrayList<student>();
        try {
            p = c.prepareStatement(sql);
            p.setInt(1,id);
            r = p.executeQuery();
            while(r.next()){
                student stu = new student();
                stu.setId(r.getInt("Id"));
                stu.setName(r.getString("name"));
                stu.setSex(r.getString("sex"));
                stu.setBirthday(r.getDate("bithday"));
                stu.setDepart(r.getString("depart"));
                stu.setPhone(r.getString("phone"));
                stu.setEmail(r.getString("email"));
                list.add(stu);
            }
            return list;
        } catch (SQLException e) {
            throw new SystemException("查询出错");
        } finally {
            DBUtil.close(c,p,r);
        }
    }

}
