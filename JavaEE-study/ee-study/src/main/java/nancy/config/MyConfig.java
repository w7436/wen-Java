package nancy.config;

import nancy.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Date;

/**
 * @ClassName MyConfig
 * @Description TODO
 * @Author DELL
 * @Data 2020/6/10 19:58
 * @Version 1.0
 **/

@Configuration  //设置配置类，配置类定义到容器中
public class MyConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginIntercepter())//添加一个拦截器,所有匹配的路径，都会进入拦截器
        .addPathPatterns("/1/**")//**代表所有的子路径。*只匹配一级路径
        .excludePathPatterns("/1/login5");//排除路径
    }

    //定义一个名称为方法名user1的User对象，并注册到容器中
    @Bean//使用在方法上，表示注册一个名称为方法名的Bean对象到容器中
    public User user1(){
        User user= new User();
        user.setName("小绿");
        user.setPassword("123");
        user.setBirthday(new Date());
        return user;
    }
    @Bean
    public User user2(){
        User user= new User();
        user.setName("小绿2");
        user.setPassword("123");
        user.setBirthday(new Date());
        return user;
    }
}
