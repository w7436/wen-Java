package nancy.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName UserLoginServlet
 * @Description TODO
 * @Author DELL
 * @Data 2020/7/3 18:33
 * @Version 1.0
 **/

@WebServlet("/user/login")

public class UserLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");//设置请求的编码格式（针对请求体）
        resp.setCharacterEncoding("UTF-8");//针对响应体
        resp.setContentType("text/html");//设置响应的数据格式，响应头：Content-Type告诉浏览器怎么解析

        //前端抓包，存在k-v这样的数据（请求体，url）
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.printf("用户名：%s,密码：%s",username,password);

        PrintWriter pw = resp.getWriter();
        pw.println("登录成功");
        pw.flush();



    }
}
