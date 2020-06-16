package nancy.config;

import nancy.model.Response;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @ClassName Responseadvicer
 * @Description TODO
 * @Author DELL
 * @Data 2020/6/16 19:42
 * @Version 1.0
 **/
@ControllerAdvice
public class Responseadvicer implements ResponseBodyAdvice {

    //返回true，表示响应数据时，先执行beforeBodyWrite，否则不执行

    //获取请求方法对象，判断Controller方法上是否还有@ResponseBody
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return returnType.getMethod().getAnnotation(ResponseBody.class) != null;
    }

    //body为请求方法执行完，返回的对象
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        Response resp = new Response();
        resp.setSuccess(true);
        resp.setData(body);
        return resp;
    }
}
