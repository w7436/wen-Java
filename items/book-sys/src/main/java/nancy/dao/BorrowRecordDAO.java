package nancy.dao;

import nancy.exception.SystemExcption;
import nancy.model.Book;
import nancy.model.BorrowRecord;
import nancy.model.Classes;
import nancy.model.Student;
import nancy.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
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
        List<BorrowRecord> list = new ArrayList<>();
        Connection c = null;
        PreparedStatement p = null;
        ResultSet r = null;

        try{
            c = DBUtil.getConnection();
            String sql ="select br.id," +
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
                    "       s.classes_id," +
                    "       c.classes_name," +
                    "       c.classes_graduate_year," +
                    "       c.classes_major," +
                    "       c.classes_desc" +
                    "  from borrow_record br" +
                    "         join book b on br.book_id = b.id" +
                    "         join student s on br.student_id = s.id" +
                    "         join classes c on s.classes_id = c.id";
            p = c.prepareStatement(sql);
            r = p.executeQuery();
            while(r.next()){
                BorrowRecord br = new BorrowRecord();
                br.setId(r.getInt("id"));
                br.setStartTime(new Date(r.getTimestamp("start_time").getTime()));
                br.setEndTime(new Date(r.getTimestamp("start_time").getTime()));
                br.setCreateTime(new Date(r.getTimestamp("start_time").getTime()));


                Book b = new Book();
                b.setId(r.getInt("book_id"));
                b.setAuthor(r.getString("author"));
                b.setPrice(r.getBigDecimal("price"));
                b.setBookName(r.getString("book_name"));

                br.setBook(b);

                Classes classes = new Classes();
                classes.setId(r.getInt("classes_id"));
                classes.setClassesName(r.getString("classes_name"));
                classes.setClassesMajor(r.getString("classes_major"));
                classes.setClassesGraduateYear(r.getString("classes_graduate_year"));
                classes.setClassesDesc(r.getString("classes_desc"));

                br.setClasses(classes);

                Student s = new Student();
                s.setId(r.getInt("student_id"));
                s.setIdCard(r.getString("id_card"));
                s.setStudentName(r.getString("student_name"));
                s.setStudentNo(r.getString("student_no"));
                s.setStudentEmail(r.getString("student_email"));

                br.setStudent(s);
                list.add(br);

            }

        }catch(Exception e){
            throw new SystemExcption("0001","查询图书借阅信息出错",e);
        }finally {
            DBUtil.close(c,p, r);
        }
        return list;

    }

    public static BorrowRecord queryById(int id) {

        BorrowRecord br = new BorrowRecord();
        Connection c = null;
        PreparedStatement p = null;
        ResultSet r = null;

        try{
            c = DBUtil.getConnection();
            String sql ="select br.id," +
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
                    "       s.classes_id," +
                    "       c.classes_name," +
                    "       c.classes_graduate_year," +
                    "       c.classes_major," +
                    "       c.classes_desc" +
                    "  from borrow_record br" +
                    "         join book b on br.book_id = b.id" +
                    "         join student s on br.student_id = s.id" +
                    "         join classes c on s.classes_id = c.id where br.id=? ";
            p = c.prepareStatement(sql);
            p.setInt(1,id);
            r = p.executeQuery();
            while(r.next()){

                br.setId(r.getInt("id"));
                br.setStartTime(new Date(r.getTimestamp("start_time").getTime()));
                br.setEndTime(new Date(r.getTimestamp("start_time").getTime()));
                br.setCreateTime(new Date(r.getTimestamp("start_time").getTime()));


                Book b = new Book();
                b.setId(r.getInt("book_id"));
                b.setAuthor(r.getString("author"));
                b.setPrice(r.getBigDecimal("price"));
                b.setBookName(r.getString("book_name"));

                br.setBook(b);

                Classes classes = new Classes();
                classes.setId(r.getInt("classes_id"));
                classes.setClassesName(r.getString("classes_name"));
                classes.setClassesMajor(r.getString("classes_major"));
                classes.setClassesGraduateYear(r.getString("classes_graduate_year"));
                classes.setClassesDesc(r.getString("classes_desc"));

                br.setClasses(classes);

                Student s = new Student();
                s.setId(r.getInt("student_id"));
                s.setIdCard(r.getString("id_card"));
                s.setStudentName(r.getString("student_name"));
                s.setStudentNo(r.getString("student_no"));
                s.setStudentEmail(r.getString("student_email"));

                br.setStudent(s);


            }

        }catch(Exception e){
            throw new SystemExcption("0006","查询图书借阅信息详情出错",e);
        }finally {
            DBUtil.close(c,p, r);
        }
        return br;

    }

    public static int insert(BorrowRecord br) {
        Connection c = null;
        PreparedStatement p = null;
        try {
            c = DBUtil.getConnection();
            String sql = "insert  borrow_record(book_id,student_id,start_time,end_time) values (?,?,?,?)";

            p = c.prepareStatement(sql);
            p.setInt(1,br.getBookId());
            p.setInt(2,br.getStudentId());
            p.setTimestamp(3,new Timestamp(br.getStartTime().getTime()));
            p.setTimestamp(4,new Timestamp(br.getEndTime().getTime()));
            return p.executeUpdate();
        } catch (SQLException e) {
            throw new SystemExcption("0008","插入图书借阅信息详情出错",e);
        } finally {
            DBUtil.close(c,p);
        }

    }

    public static int update(BorrowRecord br) {
        Connection c = null;
        PreparedStatement p = null;
        try {
            c = DBUtil.getConnection();
            String sql = "update borrow_record set book_id = ?,student_id = ?,start_time = ?,end_time = ? where id = ?";

            p = c.prepareStatement(sql);
            p.setInt(1,br.getBookId());
            p.setInt(2,br.getStudentId());
            p.setTimestamp(3,new Timestamp(br.getStartTime().getTime()));
            p.setTimestamp(4,new Timestamp(br.getEndTime().getTime()));
            p.setInt(5,br.getId());
            return p.executeUpdate();
        } catch (SQLException e) {
            throw new SystemExcption("0001","更改图书借阅信息详情出错",e);
        } finally {
            DBUtil.close(c,p);
        }
    }

    public static int delete(String[] ids) {
        Connection c = null;
        PreparedStatement p = null;
        try {
            c = DBUtil.getConnection();
            StringBuilder sql = new StringBuilder("delete from borrow_record where id in (");
                    for(int i = 0;i < ids.length;i++){
                        if(i != 0) {
                            sql.append(",");
                        }
                        sql.append("?");
                    }
            sql.append(")");
            p = c.prepareStatement(sql.toString());
            for(int i = 0;i < ids.length;i++){
                p.setInt(i+1,Integer.parseInt(ids[i]));
            }
            return p.executeUpdate();
        } catch (SQLException e) {
            throw new SystemExcption("0000","删除图书借阅信息详情出错",e);
        } finally {
            DBUtil.close(c,p);
        }
    }
}
