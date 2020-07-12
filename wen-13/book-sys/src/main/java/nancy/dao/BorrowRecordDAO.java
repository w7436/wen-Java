package nancy.dao;

import nancy.exception.SystemExcption;
import nancy.model.Book;
import nancy.model.BorrowRecord;
import nancy.model.Classes;
import nancy.model.Student;
import nancy.util.DBUtil;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName BorrowRecordDAO
 * @Description TODO
 * @Author DELL
 * @Data 2020/7/6 19:06
 * @Version 1.0
 **/
public class BorrowRecordDAO {
    public static List<BorrowRecord> query() {
        List<BorrowRecord> list = new ArrayList<BorrowRecord>();
        Connection c = null;
        PreparedStatement p = null;
        ResultSet r = null;

        try{
            c = DBUtil.getConnection();
            String sql = "select br.id," +
                    "       br.book_id," +
                    "       br.student_id," +
                    "       br.start_time," +
                    "       br.end_time," +
                    "       br.create_time," +
                    "       b.book_name," +
                    "       b.author," +
                    "       b.price," +
                    "       s.student_name," +
                    "       s.student_no," +
                    "       s.id_card," +
                    "       s.student_email," +
                    "       c.id,"+
                    "       c.classes_name," +
                    "       c.classes_graduate_year," +
                    "       c.classes_major," +
                    "       c.classes_desc," +
                    "from borrow_record br" +
                    "         join book b on br.book_id = b.id" +
                    "         join student s on br.student_id = s.id" +
                    "         join classes c on s.classes_id = c.id";
            p = c.prepareStatement(sql);
            r = p.executeQuery();
            while(r.next()){
                BorrowRecord br = new BorrowRecord();
                br.setId(r.getInt("id"));
                br.setStartTime(new Date(r.getTimestamp("start_time").getTime()));
                br.setEndTime(new Date(r.getTimestamp("end_time").getTime()));
                br.setCreateTime(new Date(r.getTimestamp("create_time").getTime()));


                //图书信息
                Book book = new Book();
                book.setId(r.getInt("br.book_id"));
                book.setBookName(r.getString("b.book_name"));
                book.setAuthor(r.getString("b.author"));
                book.setPrice(r.getBigDecimal("b.price"));

                br.setBook(book);

                //班级信息
                Classes classes = new Classes();
                classes.setId(r.getInt("c.id"));
                classes.setClassesName(r.getString("c.classes_name"));
                classes.setClassesGraduateYear(r.getString("c.classes_graduate_year"));
                classes.setClassesMajor(r.getString(" c.classes_major"));
                classes.setClassesDesc(r.getString(" c.classes_desc"));

                br.setClasses(classes);

                //学生信息
                Student student = new Student();
                student.setId(r.getInt("br.student_id"));
                student.setStudentName(r.getString("s.student_name"));
                student.setStudentNo(r.getString("s.student_no"));
                student.setIdCard(r.getString(" s.id_card"));
                student.setStudentEmail(r.getString("s.student_email"));

                br.setStudent(student);

                list.add(br);
            }
        }catch(Exception e){
            throw new SystemExcption("0001","查询图书信息出错",e);
        }finally {
            DBUtil.close(c,p,r);
        }
        return list;
    }
}
