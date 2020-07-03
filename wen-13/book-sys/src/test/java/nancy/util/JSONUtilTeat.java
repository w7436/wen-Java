package nancy.util;

import jdk.internal.util.xml.impl.Input;
import nancy.model.responseResult;
import org.junit.Assert;
import org.junit.Test;

import java.io.InputStream;

/**
 * @ClassName JSONUtilTeat
 * @Description TODO
 * @Author DELL
 * @Data 2020/7/3 21:01
 * @Version 1.0
 **/
public class JSONUtilTeat {
    @Test
    public void teatRead(){
        InputStream in = getClass().getResourceAsStream().getClass();
    }

    @Test
    public void testWrite(){
        responseResult r = new responseResult();
        r.setCode("koo");
        r.setMessage("niaho ");
        r.setStackTrace("lalalala");
        r.setSuccess(true);
        r.setTotal(1);
        r.setData(null);
        String m = JsonUtil.write(r);
        System.out.println(m);
        Assert.assertNotNull(m);
        Assert.assertTrue(m.trim().length()>0);
    }
}
