package nancy.util;

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
    public void testRead(){
        InputStream in = getClass().getClassLoader().getResourceAsStream("response.json");
        responseResult r = JsonUtil.read(in,responseResult.class);
        System.out.println(r);
        Assert.assertNotNull(r);

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
