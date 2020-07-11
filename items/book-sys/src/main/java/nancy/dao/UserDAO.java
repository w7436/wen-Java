package nancy.dao;

import nancy.exception.SystemExcption;
import nancy.model.User;
import nancy.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @ClassName UserDAO
 * @Description TODO
 * @Author DELL
 * @Data 2020/7/11 9:39
 * @Version 1.0
 **/
public class UserDAO {
    public static User query(User user) {
        User query = null;
        Connection c = null;
        PreparedStatement p = null;
        ResultSet r = null;

        try{
            c = DBUtil.getConnection();
            String sql ="select id,username,password,nickname from user where username = ? and password = ?";
            p = c.prepareStatement(sql);
            p.setString(1,user.getUsername());
            p.setString(2,user.getPassword());
            r = p.executeQuery();
            while(r.next()){
                query = user;
                query.setId(r.getInt("id"));
                query.setNickname(r.getString("nickname"));
            }

        }catch(Exception e){
            throw new SystemExcption("0004","用户查询出错",e);
        }finally {
            DBUtil.close(c,p, r);
        }
        return query;
    }
}
