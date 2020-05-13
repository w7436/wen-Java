import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName loginSelvet
 * @Description TODO
 * @Author DELL
 * @Data 2020/4/26 21:04
 * @Version 1.0
 **/
@WebServlet("/login")

public class loginselevt extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求编码及响应编码,响应的数据类型
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("servletpath:"+req.getServletPath()+"contextpath:"+req.getContextPath());
        System.out.printf("username = %s , password=%s ",username,password);

        PrintWriter pw = resp.getWriter();
        if("abc".equalsIgnoreCase(username) && "123".equalsIgnoreCase(password)){
//            pw.println("<p>登录成功</p>");
            //requst.getSession(boolean create)从请求对象获取一个session对象如果获取不到，根据create决定是否进行创建
            //create=true，创建一个对象，=false ，不创建，返回null

            HttpSession session = req.getSession();//无  参数的构造方法，相当于传入一个true
            session.setAttribute("user","username"+username);
            resp.sendRedirect(req.getContextPath()+"/main.html");

            //登录成功，重定向首页
//           resp.sendRedirect("http://www.baidu.com");
//
        }else{
            //pw.println("<p>用户名密码错误，登录不成功</p>");
            //转发到错误页面
            req.getRequestDispatcher("/error.html").forward(req,resp);
        }
        pw.flush();
    }
}