package Nancy.test;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ContextServlet extends HttpServlet {

    /**
     * 一个web工程，只有一个ServletContext对象实例
     *  ServletContext是在web工程部署启动的时候创建，在web停止的时候销毁
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //  a)获取web.xml中配置的上下文参数context-param
        ServletContext context = getServletConfig().getServletContext();
        String username = context.getInitParameter("username");
        String password = context.getInitParameter("password");
        System.out.println(username);
        System.out.println(password);

//        b)获取当前的工程路径
        System.out.println(context.getContextPath());///ServLet
//        c)获取工程部署后在服务器硬盘上的绝对路径
        //D:\bit\github\wen-Java\JavaWeb-Test\out\artifacts\ServLet_Test_war_exploded\
        System.out.println("工程部署路径："+context.getRealPath("/"));
    }
}
