package Dao;

import data.total;
import exception.SystemException;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;


/**
 * @ClassName DaoTest
 * @Description TODO
 * @Author DELL
 * @Data 2020/6/2 15:06
 * @Version 1.0
 **/
public class DaoTest {
    //插入数据
    public static void insert(total t) {
        Connection c = DBUtil.getConnection();
        PreparedStatement ps = null;
        String sql ="insert into total(datetime,money) values (?,?)";

        Date date = new Date();//生成日期对象
        Timestamp timestamp = new Timestamp(date.getTime());
//        SimpleDateFormat fmat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期样式
//        String f1 = fmat.format(date);//格式化当前日期

        try {
            ps = c.prepareStatement(sql);
            ps.setTimestamp(1,timestamp);
            ps.setDouble(2,t.getMoney());

             ps.executeUpdate();

        } catch (SQLException e) {
            throw new SystemException(e,"插入商品信息出错");
        }finally {
            DBUtil.close(c,ps);
        }
    }


//
//    public static void inserttotal(total t){
//        //获取数据源
//        Connection connection=null;
//        PreparedStatement preparedStatement=null;
//
//        try {
//            connection =getDatasource().getConnection();
//            String sql="insert into total values(?)";
//            preparedStatement=connection.prepareStatement(sql);
//            preparedStatement.setDouble(1,t.getMoney());
//            preparedStatement.execute();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (preparedStatement!=null){
//                    preparedStatement.close();
//                }
//                if (connection!=null){
//                    connection.close();
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//
//    }

}
