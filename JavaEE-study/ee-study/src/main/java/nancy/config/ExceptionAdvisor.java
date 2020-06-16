package nancy.config;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName ExceptionAdvisor
 * @Description TODO
 * @Author DELL
 * @Data 2020/6/10 21:05
 * @Version 1.0
 **/

@ControllerAdvice// Controller中，所有的客户端请求的方法，抛异常处理逻辑
public class ExceptionAdvisor {
//    @ExceptionHandler(Exception.class)
//    @ResponseBody
//    public Object handle(Exception e){   //抛出的异常会注入到我们的请求参数中
//        Map<String,String> map = new HashMap<>();
//        map.put("error",e.getMessage());
//        StringWriter stringWriter = new StringWriter();
//        PrintWriter printWriter = new PrintWriter(stringWriter);
//        e.printStackTrace(printWriter);
//        map.put("stackTrace",stringWriter.toString());
//        return map;
//    }
    @ExceptionHandler(Exception.class)
    public String handle(HttpServletResponse resp){   //抛出的异常会注入到我们的请求参数中
        try {
            resp.sendRedirect("/error.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
