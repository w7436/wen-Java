package model;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @ClassName Test
 * @Description TODO
 * @Author DELL
 * @Data 2020/6/8 19:01
 * @Version 1.0
 **/

public class Test implements BeanNameAware, BeanFactoryAware, ApplicationContextAware,
        BeanPostProcessor, BeanFactoryPostProcessor, InitializingBean, DisposableBean {

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("BeanFactoryAware");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("BeanNameAware");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("ApplicationContextAware");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("BeanPostProcessor Before");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("BeanPostProcessor After");
        return bean;
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("BeanFactoryPostProcessor");
    }

    @Override
    public void destroy() throws Exception {//Bean的销毁方法
        System.out.println("DisposableBean");
    }

    //配置文件中也可以进行初始化：使用:init-menthod+自定义方法
    @Override
    public void afterPropertiesSet() throws Exception {//Bean的初始化方法：bean的构造方法创建好之后就会调用初始化方法
        System.out.println("InitializingBean");
    }
    public void init(){

    }
}
