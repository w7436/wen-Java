package nancy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Response1 extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("到此一游");


        //第一种方式：
        //设置状态码：302
        response.setStatus(302);
        //设置响应头，说明新的地址在哪
        response.setHeader("Location","http://localhost:8080/HttpServlet/response2");

        //第二种方式：
        response.sendRedirect("http://localhost:8080/HttpServlet/response2");

    }
}
