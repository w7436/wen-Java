package Nancy.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName JSONUtil
 * @Description TODO
 * @Author DELL
 * @Data 2020/5/10 15:45
 * @Version 1.0
 **/
public class JSONUtil {
    private static volatile ObjectMapper mapper;

    public static ObjectMapper get(){
        if(mapper == null){
            synchronized (JSONUtil.class){
                if(mapper == null){
                    mapper = new ObjectMapper();
                }
            }
        }
        return mapper;
    }

    /**
     * java对象序列化为json字符串
     * @param o java对象
     * @return字符串
     */
    public static String serialize(Object o){
        try {
            return get().writeValueAsString(o);
        } catch (JsonProcessingException e) {//编译时异常转化为运行时
            throw new RuntimeException("JSON序列化失败，对象为"+o,e);
        }
    }

    /**
     * json字符串反序列为java对象
     * @param json
     * @param cla
     * @param <T> 泛型
     * @return
     */
    public static<T> T deserialize(String json,Class<T> cla){
        try {
            return get().readValue(json,cla);
        } catch (IOException e) {
            throw new RuntimeException("JSON反序列化失败，字符串为"+json,e);
        }
    }

    public static<T> T deserialize(InputStream is, Class<T> cla){
        try {
            return get().readValue(is,cla);
        } catch (IOException e) {
            throw new RuntimeException("JSON反序列化失败",e);
        }
    }
}
