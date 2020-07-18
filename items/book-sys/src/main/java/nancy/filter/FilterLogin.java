package nancy.filter;

import nancy.model.responseResult;
import nancy.util.JsonUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName FilterLogin
 * @Description TODO
 * @Author DELL
 * @Data 2020/7/11 10:11
 * @Version 1.0
 **/
@WebFilter("/*")
public class FilterLogin implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String uri = req.getServletPath();
        HttpSession session = req.getSession(false);
        if(session == null) {//，没有登录
            //访问首页 /public/page/main.html，没有登录重定向到登陆页面
            if ("/public/page/main.html".equals(uri)) {
                String schema = req.getScheme();//http
                String host = req.getServerName();//服务器ip或域名
                int port = req.getServerPort();//服务器端口号
                String contextPath = req.getContextPath();
                String basePath = schema + "://" + host + ":" + port + contextPath;
                res.sendRedirect(basePath + "/public/index.html");
                return;
                //访问后台的敏感资源，servlet的敏感服务，返回json数据
            } else if (!"/login.html".equals(uri) && !uri.startsWith("/public/") && !uri.startsWith("/static/")
                    && !"/user/login".equals(uri)) {//访问敏感资源
                req.setCharacterEncoding("UTF-8");//针对请求体设置编码，注意对url中的请求数据无效
                res.setCharacterEncoding("UTF-8");//针对响应体设置编码
                res.setContentType("application/json");//设置响应的数据格式：响应头Content-Type告诉浏览器怎么解析
                responseResult r = new responseResult();
                r.setCode("301");
                r.setMessage("未被授权的访问");
                PrintWriter pw = res.getWriter();
                pw.println(JsonUtil.write(r));
                pw.flush();
                return;
            }
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}

//@WebFilter("/*")
//public class FilterLogin implements Filter {
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest req = (HttpServletRequest) servletRequest;
//        String uri = req.getServletPath();
//
//        //访问首页没有登录，则重定向到登录页面
//        if(!"/login.html".equals(uri) && !uri.startsWith("/public/") && !uri.startsWith("/static/")
//                && !"/user/login".equals(uri)){
//            HttpSession session = req.getSession(false);
//            if(session == null){//访问敏感url，没有登录需要跳转到登录页面先进行登录
//                String schema = req.getScheme();//http
//                String host = req.getServerName();//服务器ip或者域名
//                int port = req.getServerPort();//服务器端口号
//                String contextPath = req.getContextPath();
//                String basePath = schema+"://"+host+":"+port+contextPath;
//                ((HttpServletResponse) servletResponse).sendRedirect(basePath+"/public/index.html");
//                return;
//            }
//        }
//        filterChain.doFilter(servletRequest,servletResponse);
//    }
//
//    @Override
//    public void destroy() {
//
//    }
//}
