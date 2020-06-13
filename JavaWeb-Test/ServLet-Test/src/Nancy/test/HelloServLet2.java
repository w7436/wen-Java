package Nancy.test;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName HelloServLet2
 * @Description TODO
 * @Author DELL
 * @Data 2020/5/10 20:47
 * @Version 1.0
 **/

public class HelloServLet2 extends HttpServlet {

    
    //重写init方法必须super.init（）
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("重写初始化方法");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("hello2doGet()");
        ServletConfig servletConfig = getServletConfig();
        System.out.println(servletConfig);

        System.out.println("初始化参数username的参数值："+servletConfig.getInitParameter("username"));
        System.out.println("初始化参数url的参数值："+servletConfig.getInitParameter("url"));
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("hello2doPost()");
    }
}
