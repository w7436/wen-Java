package Nancy.util;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;

/**
 * @ClassName DemoSingleTest
 * @Description TODO
 * @Author DELL
 * @Data 2020/5/27 11:09
 * @Version 1.0
 **/
public class DemoSingleTest {
    //多线程环境下，DemoSingleTestget.DataSource()u也是线程安全的
    //JVM在类加载的时候，类只加载一次，并且是线程安全的
    public static DataSource getDataSource(){
        return Holder.getDataSource();
    }

    private static class Holder{
        private static final DataSource DATA_SOURCE= new MysqlDataSource();
        static {

        }
        public static DataSource getDataSource(){
            return DATA_SOURCE;
        }
    }
}
