package nancy.controller;

import nancy.model.User;
import nancy.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @ClassName LoginController
 * @Description TODO
 * @Author DELL
 * @Data 2020/6/8 20:07
 * @Version 1.0
 **/
@Controller
@RequestMapping("/1")
public class LoginController {



//    @Autowired
    @Resource
    private LoginService loginService;

    @Autowired//Spring的一个注解
    @Qualifier("user1")//引入名称为user1的对象
    private User user1;

    @Resource(name="user2")//jdk的注解，是一个规范，Spring实现了这个规范
    private User user2;

    /**
     * 两个页面，login.html和login.html，哪些url几种方法进行访问，哪些是转发
     * @return
     * 访问index.html:
     * 1)/----->SpringBoot默认的首页（转发）
     * 2）/index.html
     * 访问login.html
     * 1)/login.html
     * 2)/login 通过LoginConctoller中的方法（转发）
     */
    //@RequestMapping可以使用在类上和方法上，表示客户端请求的配置（包括uri，请求方法，数据类型）
    @RequestMapping("/login")
    public String login(Integer i){
        System.out.println(loginService);
        System.out.println(user1);
        System.out.println(user2);
        if(i == 1){
            return "redirect:/index.html";//重定向
        }else{
            return "forward:/index.html";//转发
        }

    }

    @RequestMapping(value = "/login2" ,method = RequestMethod.POST)
    @ResponseBody
    /**
     * //不加注解，默认就是RequestParam
     * 类型可以是封装的数据类型，自定义类型
     * 设置值的时候，请求数据中，键和自定义类型属性匹配
     * 只接受URL中的数据
     */
    public Object login2(@RequestParam("username") String username1,
                         String password,
                         String password2){
        System.out.println(username1+"="+password+"="+password2);
        User user= new User();
        user.setName("小绿");
        user.setPassword("123");
        user.setBirthday(new Date());
        return user;
    }




    @RequestMapping(value = "/login3" ,method = RequestMethod.POST)
    @ResponseBody
    public Object login3(User u){//请求数据中，键和自定义类型的属性相匹配
        System.out.println(u);
        User user= new User();
        user.setName("小绿");
        user.setPassword("123");
        user.setBirthday(new Date());
        return user;
    }


    @RequestMapping(value = "/login4" ,method = RequestMethod.POST)
    @ResponseBody   // JSON 格式转换注解
    public Object login4(@RequestBody User u){
        System.out.println(u);
        User user= new User();
        user.setName("小绿");
        user.setPassword("123");
        user.setBirthday(new Date());
        return user;
    }

    @RequestMapping(value = "/login5" ,method = RequestMethod.POST)
    @ResponseBody   // 将对象转换为JSON格式返回给前端
    public Object login5(HttpServletRequest request, HttpServletResponse response, User u){

        if ("abc".equals(u.getName()) && "abc".equals(u.getPassword())) {
            HttpSession session = request.getSession();
            session.setAttribute("user",u);
            User user= new User();
            user.setName("小绿");
            user.setPassword("123");
            user.setBirthday(new Date());
            return user;
        }
        throw new RuntimeException("登录不成功");

    }
    @RequestMapping(value = "/{type}/login6" ,method = RequestMethod.POST)//路径变量
    @ResponseBody
    public Object login6(@PathVariable ("type") String type){
        System.out.println(type );
        User user= new User();
        user.setName("小绿");
        user.setPassword("123");
        user.setBirthday(new Date());
        return user;


    }

}
