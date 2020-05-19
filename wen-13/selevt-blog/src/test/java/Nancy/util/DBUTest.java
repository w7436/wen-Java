package Nancy.util;

import org.junit.Assert;
import org.junit.Test;

/**
 * @ClassName DBUTest
 * @Description TODO
 * @Author DELL
 * @Data 2020/5/16 12:04
 * @Version 1.0
 **/
public class DBUTest {
    @Test
    public void testConnection(){
        Assert.assertNotNull(DBUtil.getConnection());
    }
}
