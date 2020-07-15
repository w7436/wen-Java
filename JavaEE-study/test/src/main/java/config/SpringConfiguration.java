package config;

/**
 * @ClassName SpringConfiguration
 * @Description TODO
 * @Author DELL
 * @Data 2020/7/14 11:04
 * @Version 1.0
 **/

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * Configuration
 *        作用：指定当前类是一个配置类
 * ComponentScan
 *        作用：用于通过注解指定spring在创建容器时要扫描的包
 *        属性：
 *           value：和basePackage的作用是一样的，都是用于指定创建容器时要扫描的包
 *           使用这个注解就相当于在配置了
 *               <context:component-scan base-package="nancy"></context:component-scan>
 * Bean
 *     作用：用于把当前的方法的返回值作为bean对象放入容器中
 *     属性：
 *          name:用于指定bean的id，不写的时候，默认是方法名
 *注意：当使用注解配置方法的时候，如果方法有参数，spring框架会首先从容器中查找有没有可用的bean对象
 *      查找方式和Autowired一样
 * Import:导入其他的配置类
 * PropertySources:用于指定properties文件的位置
 *          属性：
 *              value：指定文件的名称和路径
 *              classpath：表示类路径
 *
 *
 */

@Configuration
@ComponentScan("nancy")
@Import(JdbcConfig.class)
@PropertySource("classpath:jdbcConfig.properties")
public class SpringConfiguration {

}
