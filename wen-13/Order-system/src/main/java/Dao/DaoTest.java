package Dao;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import data.total;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @ClassName DaoTest
 * @Description TODO
 * @Author DELL
 * @Data 2020/6/2 15:06
 * @Version 1.0
 **/
public class DaoTest {

    private static String URL="jdbc:mysql://localhost/orderdemo";
    private static String USER="root";
    private static String PASSWORD="123456";
    public static DataSource getDatasource(){
        MysqlDataSource dataSource=new MysqlDataSource();
        dataSource.setURL(URL);
        dataSource.setUser(USER);
        dataSource.setPassword(PASSWORD);
        return dataSource;
    }

    public static void inserttotal(total t){
        //获取数据源
        Connection connection=null;
        PreparedStatement preparedStatement=null;

        try {
            connection =getDatasource().getConnection();
            String sql="insert into total values(?)";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setDouble(1,t.getMoney());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement!=null){
                    preparedStatement.close();
                }
                if (connection!=null){
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

}
