package nancy;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet1 extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        System.out.println("查看参数"+username);
        request.setAttribute("key","柜台1章子");

        //请求转发必须以/开始，/表示的地址是http://localhost:8080/工程名/,映射到Idea的Web目录
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/servlet2");
        //走向柜台2
        requestDispatcher.forward(request,response);
    }
}
