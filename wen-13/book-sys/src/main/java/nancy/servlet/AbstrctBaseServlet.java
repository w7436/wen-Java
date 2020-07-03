package nancy.servlet;

import nancy.exception.Baseexception;
import nancy.model.responseResult;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName AbstrctBaseServlet
 * @Description TODO
 * @Author DELL
 * @Data 2020/7/3 21:14
 * @Version 1.0
 **/
public abstract class AbstrctBaseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");//设置请求的编码格式（针对请求体）
        resp.setCharacterEncoding("UTF-8");//针对响应体
        resp.setContentType("text/html");//设置响应的数据格式，响应头：Content-Type告诉浏览器怎么解析

        responseResult r = null;
        try {
            Object data = process(req,resp);
            r.setSuccess(true);
            r.setCode("000");
            r.setMessage("操作成功");
            r.setData(data);
        } catch (Exception e) {
            e.printStackTrace();
            if(e instanceof Baseexception ){
                Baseexception ba = (Baseexception) e;
                r.setCode(ba.getCode());
            }
        }

    }

    public abstract Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception;

}
