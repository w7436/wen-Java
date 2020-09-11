import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName orederServelt
 * @Description TODO
 * @Author DELL
 * @Data 2020/4/27 19:52
 * @Version 1.0
 **/
@WebServlet("/order")
public class orederServelt extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //设置请求编码及响应编码,响应的数据类型
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        //用户身份校验:登录就有session对象，如果没有登录，就获取不到，create=false,返回空
        HttpSession session = req.getSession(false);
        if(session == null){//登录就不为null
            resp.sendRedirect(req.getContextPath()+"/index.html");
        }else{
            PrintWriter pw = resp.getWriter();
            pw.println("<h2>已经登录</h2>");
            pw.flush();
        }

    }
}















