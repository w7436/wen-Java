package frank.servlet;

import frank.exception.BaseException;
import frank.model.ResponseResult;
import frank.util.CountHolder;
import frank.util.JSONUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

public abstract class AbstractBaseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");//针对请求体设置编码，注意对url中的请求数据无效
        resp.setCharacterEncoding("UTF-8");//针对响应体设置编码
        resp.setContentType("application/json");//设置响应的数据格式：响应头Content-Type告诉浏览器怎么解析
        ResponseResult r = new ResponseResult();

        try {
            Object data = process(req, resp);//父类的service调用doGet/doPost方法，执行到这里，调用子类的process方法
            //只要process没有抛异常，就返回成功的数据
            r.setSuccess(true);
            r.setCode("200");
            r.setMessage("操作成功");
            r.setTotal(CountHolder.get());//可能是分页的接口，get可以获取到值，也可能不是，返回null
            r.setData(data);
        } catch (Exception e) {//process抛异常的处理逻辑
            e.printStackTrace();
            if(e instanceof BaseException){
                BaseException be = (BaseException) e;
                r.setCode(be.getCode());
                r.setMessage(be.getMessage());
            }else{
                r.setCode("500");
                r.setMessage("未知的错误");
            }
            //设置堆栈信息
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            r.setStackTrace(sw.toString());
        }finally {
            CountHolder.remove();//ThreadLocal规范做法，线程结束前，一定要remove删除。否则可能出现内存泄漏
        }
        PrintWriter pw = resp.getWriter();
        pw.println(JSONUtil.write(r));
        pw.flush();
    }
    //抽象方法：子类重写
    public abstract Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception;
}
