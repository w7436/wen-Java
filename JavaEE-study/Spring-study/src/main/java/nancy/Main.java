package nancy;

import model.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName Main
 * @Description TODO
 * @Author DELL
 * @Data 2020/6/7 10:37
 * @Version 1.0
 **/
public class Main {
    /**
     * 常用的ApplicationContext的实现类：
     * ClassPathXmlApplicationContext：加载类路径下的配置文件，要求配置文件必须在类路径下
     * FileSystemXmlApplicationContext:可以加载磁盘任意路径下的配置文件（必须有访问权限）
     * AnnotationConfigApplicationContext:用于读取注解创建容器的
     *
     *
     * 核心容器的两个接口产生的问题
     * ApplicationContext（单例模式），在构建核心容器时，创建对象采用的是立即加载的方式，也就是说，只要一读取完配置文件马上就创建配置文件中配置的对象
     * BeanFactory（多例）：在构建核心容器时，创建对象采用的是延迟加载的方式，也就是说，他在读取完配置文件后，不会立即创建对象，而是在什么时候根据id获取对象了，什么时候才创建对象
     * @param args
     */
    public static void main(String[] args) {
        //获取核心容器对象
        ApplicationContext context = new
                ClassPathXmlApplicationContext("applications.xml");
//        //根据id获取对象，从容器中获取bean对象
//        Duck duck1 = (Duck) context.getBean("duck1");
//        System.out.println(duck1);
//        Duck duck1_1 = (Duck) context.getBean("duck1");
//        System.out.println(duck1 == duck1_1);//true：duck1默认scope为单例
//        Duck duck2 = (Duck) context.getBean("duck2");
//        System.out.println(duck2);
//        Duck duck2_2 = (Duck) context.getBean("duck2");
//        System.out.println(duck2 == duck2_2);//false: duck2设置的scope为prototype，getBean生成新的对象
//        DuckShop shop = (DuckShop) context.getBean("duckShop");
//        System.out.println(shop);
//        Person p1 = (Person) context.getBean(Person.class);
//        System.out.println(p1);
//
//        Duck duck3 = (Duck) context.getBean("duck3");
//        System.out.println(duck3);
//
//        Duck duck4 = (Duck) context.getBean("duck4");
//        System.out.println(duck4);

        //通过类型在容器中获取bean：该类型只有一个对象在容器中，否则会报错
//        context.getBean(Duck.class);
        Test test = (Test)context.getBean("test");

    }
}
