package nancy.servlet;

import nancy.exception.Baseexception;
import nancy.model.responseResult;
import nancy.util.JsonUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

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


        responseResult r = new responseResult();
        try {
            Object data = process(req,resp);//父类的service调用doGet/doPost方法，执行到这里，调用了子类的process方法
            //只要process没有抛异常就返回成功的数据
            r.setSuccess(true);
            r.setCode("000");
            r.setMessage("操作成功");
            r.setData(data);
        } catch (Exception e) {//出现异常处理逻辑
            e.printStackTrace();
            if(e instanceof Baseexception ){
                Baseexception ba = (Baseexception) e;
                r.setCode(ba.getCode());
                r.setMessage(ba.getMessage());
            }else{
                r.setCode("500");
                r.setMessage("未知的错误");
            }
            //设置堆栈信息
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace();
            r.setStackTrace(sw.toString());
        }

        PrintWriter pw = resp.getWriter();
        pw.println(JsonUtil.write(r));
        pw.flush();

    }

    public abstract Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception;

}
