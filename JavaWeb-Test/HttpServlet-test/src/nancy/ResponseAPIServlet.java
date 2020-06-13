package nancy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName ResponseAPIServlet
 * @Description TODO
 * @Author DELL
 * @Data 2020/6/11 22:44
 * @Version 1.0
 **/
public class ResponseAPIServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //第一种方法
//         resp.setCharacterEncoding("UTF-8");//设置服务器的字符集
//        //设置响应头，是设置浏览器也是用UTF-8字集
//        resp.setHeader("Content-Type","text/html;charset=UTF-8");

        //第二种方法:会同时设置服务器和客户端都使用UTF-8子集
        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter pw = resp.getWriter();
        pw.write("你好");

    }
}
