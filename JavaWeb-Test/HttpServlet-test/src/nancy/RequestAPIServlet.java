package nancy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName nancy
 * @Description TODO
 * @Author DELL
 * @Data 2020/6/11 15:18
 * @Version 1.0
 **/

public class RequestAPIServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*
        URI==/HttpServlet/requestAPIServlet
        URL==http://localhost:8080/HttpServlet/requestAPIServlet
         */
        System.out.println("URI=="+req.getRequestURI());
        System.out.println("URL=="+req.getRequestURL());
        System.out.println("客户端IP地址："+req.getRemoteHost());//获取客户端IP地址
        System.out.println("请求头user-agent:"+req.getHeader("User-agent"));
        System.out.println("请求的方式："+req.getMethod());
    }


}
