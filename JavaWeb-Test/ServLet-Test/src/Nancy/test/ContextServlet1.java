package Nancy.test;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ContextServlet1 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取servletContext对象
        ServletContext context = getServletContext();
        System.out.println("Context1中获取域数据key1的值是："+context.getAttribute("key1"));

        context.setAttribute("key1", "value1");
        System.out.println("Context1中获取域数据key1的值是："+context.getAttribute("key1"));

    }


}
