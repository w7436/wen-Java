package nancy;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName Main
 * @Description TODO
 * @Author DELL
 * @Data 2020/9/10 17:25
 * @Version 1.0
 **/
public class Main {

    public static SqlSessionFactory sqlSessionFactory;
    public static InputStream inputStream;
    public static void main(String[] args) {
        System.out.println("n");
        try {
            String resource = "mybatis-config.xml";
            System.out.println("1");
             inputStream = Resources.getResourceAsStream(resource);
            System.out.println("2");

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("3");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        System.out.println(sqlSession);






    }
}
