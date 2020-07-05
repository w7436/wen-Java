package nancy.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import nancy.poji.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author DELL
 * @Data 2020/7/5 21:19
 * @Version 1.0
 **/
@Controller
public class UserController {
    @RequestMapping("/user1")
    //我们正常返回会走视图解析器，而json需要的是返回一个字符串，
    //第三方的jar包可以实现这个问题，jackson，只需要一个简单的注释
    //@ResponseBody,将服务器返回的对象转化为json对象响应回去
    @ResponseBody
    public String user1() throws JsonProcessingException {
        //需要一个jackson对象映射器，其实就是一个类，可以直接将对象转化为json字符串
        ObjectMapper objectMapper = new ObjectMapper();

        //创建一个对象
        User user = new User();
        user.setName("你好");
        user.setAge(1);
        user.setSex("男");

        System.out.println(user);

        //将java对象转化为json字符串，
        String str = objectMapper.writeValueAsString(user);
        System.out.println(str);

        return str;//由于使用了@ResponseBody注解，这里会以json格式返回；

    }
}
