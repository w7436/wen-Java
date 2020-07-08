package nancy.dao;

import nancy.exception.SystemExcption;
import nancy.model.Student;
import nancy.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName StudentDAo
 * @Description TODO
 * @Author DELL
 * @Data 2020/7/8 17:12
 * @Version 1.0
 **/
public class StudentDAO {
    public static List<Student> query(Integer id) {
        List<Student> list = new ArrayList<>();
        Connection c = null;
        PreparedStatement p = null;
        ResultSet r = null;

        try{
            c = DBUtil.getConnection();
            String sql ="select id,student_name,id_card,student_no from student where classes_id = ? ";
            p = c.prepareStatement(sql);
            p.setInt(1,id);
            r = p.executeQuery();
            while(r.next()){
                Student student = new Student();
                student.setDictionaryTagKey(String.valueOf(r.getInt("id")));
                student.setDictionaryTagValue(r.getString("student_name"));
                student.setIdCard(r.getString("id_card"));
                student.setStudentNo(r.getString("student_no"));
                list.add(student);
            }

        }catch(Exception e){
            throw new SystemExcption("0002","查询班级信息出错",e);
        }finally {
            DBUtil.close(c,p, r);
        }
        return list;
    }
}
