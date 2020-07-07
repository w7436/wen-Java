package nancy.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import nancy.exception.SystemExcption;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;

/**
 * @ClassName JsonUtil
 * @Description TODO
 * @Author DELL
 * @Data 2020/7/3 20:20
 * @Version 1.0
 **/
public class JsonUtil {
    private static ObjectMapper MAPPER;
    static {
        MAPPER = new ObjectMapper();
        MAPPER.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    }


    //读取输入流的json数据，反序列化为对象
    public static <T> T read(InputStream in,Class<T> clazz){
        try {
            return MAPPER.readValue(in,clazz);
        } catch (IOException e) {
            throw new SystemExcption("003","http请求，解析json数据出错",e);
        }
    }

    public static String write(Object o){
        try {
            return MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(o);
        } catch (JsonProcessingException e) {
            throw new SystemExcption("004","json序列化对象失败",e);
        }
    }
}
