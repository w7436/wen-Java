package nancy.dao;

import nancy.exception.SystemExcption;
import nancy.model.Book;
import nancy.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName BookDAO
 * @Description TODO
 * @Author DELL
 * @Data 2020/7/8 16:34
 * @Version 1.0
 **/
public class BookDAO {
    public static List<Book> queryAsDict() {
        List<Book> list = new ArrayList<>();
        Connection c = null;
        PreparedStatement p = null;
        ResultSet r = null;

        try{
            c = DBUtil.getConnection();
            String sql ="select id,book_name,author,price from book";
            p = c.prepareStatement(sql);
            r = p.executeQuery();
            while(r.next()){
                Book b = new Book();
                b.setDictionaryTagKey(String.valueOf(r.getInt("id")));
                b.setDictionaryTagValue(r.getString("book_name"));
                b.setAuthor(r.getString("author"));
                b.setPrice(r.getBigDecimal("price"));

                list.add(b);
            }

        }catch(Exception e){
            throw new SystemExcption("0002","查询班级信息出错",e);
        }finally {
            DBUtil.close(c,p, r);
        }
        return list;
    }
}
