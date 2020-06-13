package Nancy.test;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @ClassName HelloServLet
 * @Description TODO
 * @Author DELL
 * @Data 2020/5/10 19:33
 * @Version 1.0
 **/
/*
手动实现servlet程序：
1、编写一个类去实现Servlet接口
2、实现service方法，处理请求，并且响应数据
3、到web.xml文件中去配置servlet程序的访问地址
 */
public class HelloServLet implements Servlet {
    //第一次调用的时候访问

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
//        a)可以获取Servlet程序的别名servlet-name的值
        System.out.println("HelloServLet的别名是："+servletConfig.getServletName());
//        b)获取初始化参数init-param
        System.out.println("初始化参数username的参数值："+servletConfig.getInitParameter("username"));
        System.out.println("初始化参数url的参数值："+servletConfig.getInitParameter("url"));
//        c)获取ServletContext对象
        System.out.println(servletConfig.getServletContext());
        System.out.println("1.初始化");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * 专门用来实现处理请求和响应的方法的
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */

    //每次访问都会调用
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Hello被访问了");
        HttpServletRequest httpServlet =(HttpServletRequest) servletRequest;//向下转型
        String menthod = httpServlet.getMethod();
        if("GET".equals(menthod)){
            System.out.println("get()");
        }
        else if("POST".equals(menthod)){
            System.out.println("post()");
        }

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    //工程销毁的时候调用方法
    @Override
    public void destroy() {
        System.out.println("3.销毁");

    }
}
