package Nancy.dao;

import Nancy.exception.SystemExcption;
import Nancy.modol.Article;
import Nancy.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName ArticleDAO
 * @Description TODO
 * @Author DELL
 * @Data 2020/5/16 12:10
 * @Version 1.0
 **/

//JDBC数据库sql操作
public class ArticleDAO {
    //显示文字列表
    public static List<Article> list(){
        Connection c = DBUtil.getConnection();
        PreparedStatement  p =null;
        ResultSet r = null;
        String sql ="select id,title,content,user_id,create_time from article" ;
        try {
            List<Article> articles = new ArrayList<>();
            p=c.prepareStatement(sql);
            r = p.executeQuery();//数据库查询操作
            while(r.next()){
                Article article = new Article();
                article.setId(r.getInt("id"));
                article.setTitle(r.getString("title"));
                article.setContent(r.getString("content"));
                article.setUserId(r.getInt("user_id"));
                article.setCreateTime(new Date(r.getTimestamp("create_time").getTime()));
                articles.add(article);
            }
            return articles;
        } catch (SQLException e) {
            throw new SystemExcption("001",e,"查询文章列表出错");
        } finally {
            DBUtil.close(c,p,r);
        }
    }

    public static int insert(Article article) {
        Connection c = DBUtil.getConnection();
        PreparedStatement ps = null;
        String sql ="insert into article (user_id,title,content,create_time) " +
                "select id,?,?,?" +
                " from user where name = ?";
        try {
            ps = c.prepareStatement(sql);
            ps.setString(1,article.getTitle());
            ps.setString(2,article.getContent());
            ps.setTimestamp(3,new Timestamp(new Date().getTime()));
            ps.setString(4,article.getUserAccout());
            return ps.executeUpdate();
        } catch (SQLException e) {
            throw new SystemExcption("002",e,"新增文章出错");
        }finally {
            DBUtil.close(c,ps);
        }
    }


    public static Article query(Integer articleId) {
        Connection c = DBUtil.getConnection();
        PreparedStatement  p =null;
        ResultSet r = null;
        String sql ="select id,title,content,user_id,create_time" +
                " from article where id = ?" ;
        Article article = null;
        try {
            p = c.prepareStatement(sql);
            p.setInt(1,articleId);
            r = p.executeQuery();
            while(r.next()){
                article = new Article();
                //文章设置属性
                article.setId(articleId);
                article.setTitle(r.getString("title"));
                article.setContent(r.getString("content"));
                article.setUserId(r.getInt("user_id"));
                article.setCreateTime(new Date(r.getTimestamp("create_time").getTime()));

            }
            return article;
        } catch (SQLException e) {
            throw new SystemExcption("003",e,"查询文章详情出错");
        } finally {
            DBUtil.close(c,p,r);
        }

    }

    public static int update(Article article) {
        Connection c = DBUtil.getConnection();
        PreparedStatement ps = null;
        String sql ="update article set title = ?,content = ? where id = ?";
        try {
            ps = c.prepareStatement(sql);
            ps.setString(1,article.getTitle());
            ps.setString(2,article.getContent());
            ps.setInt(3,article.getId());
            return  ps.executeUpdate();
        } catch (SQLException e) {
            throw new SystemExcption("004",e,"修改文章出错");
        } finally {
            DBUtil.close(c,ps);
        }
    }

    public static int delete(int[] ids) {
        Connection c = DBUtil.getConnection();
        PreparedStatement ps = null;
        StringBuilder sql =new StringBuilder("delete from article where id in (");
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
            return  ps.executeUpdate();
        } catch (SQLException e) {
            throw new SystemExcption("005",e,"删除文章出错");
        } finally {
            DBUtil.close(c,ps);
        }
    }
}
