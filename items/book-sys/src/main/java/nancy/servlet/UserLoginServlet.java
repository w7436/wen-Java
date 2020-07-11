package nancy.servlet;

import nancy.dao.UserDAO;
import nancy.exception.BusinessException;
import nancy.model.User;
import nancy.util.JsonUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @ClassName UserLoginServlet
 * @Description TODO
 * @Author DELL
 * @Data 2020/7/3 18:33
 * @Version 1.0
 **/

@WebServlet("/user/login")

public class UserLoginServlet extends AbstrctBaseServlet {
    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        User user  = JsonUtil.read(req.getInputStream(),User.class);//http请求解析的数据
        User query = UserDAO.query(user);//通过请求的用户名密码在数据库中查询
        if(query == null) {
            throw new BusinessException("0003","用户密码校验失败");
        }
        HttpSession session = req.getSession();
        session.setAttribute("user",query);
        return null;


    }

//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        doPost(req,resp);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setCharacterEncoding("UTF-8");//设置请求的编码格式（针对请求体）
//        resp.setCharacterEncoding("UTF-8");//针对响应体
//        resp.setContentType("text/html");//设置响应的数据格式，响应头：Content-Type告诉浏览器怎么解析
//
//        //前端抓包，存在k-v这样的数据（请求体，url）
//        String username = req.getParameter("username");
//        String password = req.getParameter("password");
//        System.out.printf("用户名：%s,密码：%s",username,password);
//
//        PrintWriter pw = resp.getWriter();
//        pw.println("登录成功");
//        pw.flush();


}
