package Nancy.util;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;

/**
 * @ClassName URLDecoderTest
 * @Description TODO
 * @Author DELL
 * @Data 2020/5/17 17:14
 * @Version 1.0
 **/
public class URLDecoderTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
        //含中文或者空格编码，我们要进行解码
        URL url = URLDecoderTest.class.getClassLoader().getResource("Program Files/你好.txt");
        System.out.println(url.getPath());
        String path = URLDecoder.decode(url.getPath(),"UTF-8");
        System.out.println(path);
    }

}
