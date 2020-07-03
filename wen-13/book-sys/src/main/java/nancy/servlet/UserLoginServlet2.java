package nancy.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

/**
 * @ClassName UserLoginServlet
 * @Description TODO
 * @Author DELL
 * @Data 2020/7/3 18:33
 * @Version 1.0
 **/

@WebServlet("/user/login2")
public class UserLoginServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");//设置请求的编码格式（针对请求体）
        resp.setCharacterEncoding("UTF-8");//针对响应体
        resp.setContentType("application/json");//设置响应的数据格式，响应头：Content-Type告诉浏览器怎么解析

        //json数据格式需要通过io流获取
        HashMap hashMap = new ObjectMapper().readValue(req.getInputStream(), HashMap.class);
        System.out.println(hashMap);

        HashMap<String,Object> r = new HashMap<>();
        r.put("success",true);
        r.put("code",200);
        PrintWriter pw = resp.getWriter();
        pw.println(new ObjectMapper().writeValueAsString(r));
        pw.flush();



    }
}
