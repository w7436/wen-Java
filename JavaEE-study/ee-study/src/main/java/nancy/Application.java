package nancy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName Application
 * @Description TODO
 * @Author DELL
 * @Data 2020/6/8 19:41
 * @Version 1.0
 **/
@SpringBootApplication
@MapperScan(basePackages = "nancy.mapper")//扫描接口类。接口上加上Mapper注解的，会通过mybatis框架生成代理类
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
