package nancy.util;

import org.junit.Assert;
import org.junit.Test;

/**
 * @ClassName DBUtilTest
 * @Description TODO
 * @Author DELL
 * @Data 2020/7/3 20:59
 * @Version 1.0
 **/
public class DBUtilTest {
    @Test
    public void test(){
        Assert.assertNotNull(DBUtil.getConnection());
    }
}
