package nancy.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @ClassName LoginIntercepter
 * @Description TODO
 * @Author DELL
 * @Data 2020/6/10 20:07
 * @Version 1.0
 **/
public class LoginIntercepter implements HandlerInterceptor {

    //Controller接收客户端请求，匹配到路径，并且拦截到，进入方法前执行逻辑
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession(false);//如果没有session不能创建
        if(session != null){//有登录
            //权限的校验
            //if通过
            return true;
            //不通过
          //  response.setStatus(HttpStatus.FORBIDDEN.value());//403，权限不通过

        }
        response.setStatus(HttpStatus.UNAUTHORIZED.value());//401，未授权的，没有登录
        response.sendRedirect("/login.html");
        return false;
    }


    //Controller方法执行完，之后的逻辑
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
