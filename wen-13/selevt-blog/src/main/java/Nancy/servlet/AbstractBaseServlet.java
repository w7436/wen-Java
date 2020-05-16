package Nancy.servlet;

import Nancy.exception.Baseexception;
import Nancy.modol.Result;
import Nancy.util.JSONUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName AbstractBaseServlet
 * @Description TODO
 * @Author DELL
 * @Data 2020/5/12 16:02
 * @Version 1.0
 **/
public abstract class AbstractBaseServlet extends HttpServlet  {

    private static final ConcurrentMap<String,Integer> MAP=new ConcurrentHashMap<>();
    private static final ConcurrentMap<String, AtomicInteger> MAP2=new ConcurrentHashMap<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json;charset=UTF-8");

        //前端约定好的统一返回json数据格式
        Result result = new Result();
        try{
            //正确返回
            Object data = process(req,resp);
            result.setSuccess(true);
            result.setData(data);
        }catch(Exception e){//对异常的处理
           if(e instanceof Baseexception){
               Baseexception be = (Baseexception) e;
               result.setMessage("错误码："+be.getCode()+".错误信息："+be.getMessage());
           }else{
               result.setMessage("服务器异常：未知的错误");
           }
            StringWriter sw = new StringWriter();
            PrintWriter epw = new PrintWriter(sw);
            e.printStackTrace(epw);
            result.setStackTrace(sw.toString());
        }

        PrintWriter pw = resp.getWriter();
        pw.println(JSONUtil.serialize(result));
        pw.flush();

//        System.out.println("Scheme:"+req.getScheme());
//        System.out.println("");
        synchronized (MAP){
            String path = req.getServletPath();
            Integer count = MAP.get(path);
            if(count == null) count = 1;
            else count++;
            MAP.put(path,count);
        }

        //方法二
        String path = req.getServletPath();
        AtomicInteger count = MAP2.putIfAbsent(path,new AtomicInteger(1));
        if (count!=null)  count.getAndIncrement();
    }

    public abstract Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception;

    public static ConcurrentMap<String, Integer> getMAP() {
        return MAP;
    }

    public static ConcurrentMap<String, AtomicInteger> getMAP2() {
        return MAP2;
    }
}
