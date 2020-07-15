package nancy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @ClassName Client
 * @Description TODO
 * @Author DELL
 * @Data 2020/7/15 16:00
 * @Version 1.0
 **/
public class Client {
    public static void main(String[] args) {
        final Producer producer = new Producer();

        /**
         * 动态代理：
         *      特点：字节码随用随创建，随用随加载
         *      作用：在不修改源码的基础上对方法进行增强
         *      分类：
         *          1、基于接口：涉及的类（Proxy）,提供者JDK官方
         *                      如何创建代理对象：使用Proxy中的newProxyInstance方法
         *                      创建代理对象的要求：被代理的类最少实现一个接口，如果没有则不能使用
         *                      newProxyInstance的参数：
         *                          1）ClassLoader：类加载器，用于加载代理对象字节码的，和被代理对象使用相同的类加载器
         *                          2）Class[] :用于让代理对象和被代理对象有相同的方法
         *                          3）InvocationHandler:用于提供增强的代码
         *          2、基于子类:涉及的类（Enhancer）提供者是第三方cglib库
         *                     创建代理对象：使用Enhancer中的create方法
         *                     创建代理对象的要求:被代理类不能是最终类
         *                     create方法参数：
         *                          1)Class：字节码，用于指定被代理对象的字节码
         *                          2)Callback：用于提供增强的代码
         */
        Producer cglib = (Producer) Enhancer.create(producer.getClass(), new MethodInterceptor() {
            /**
             *执行被代理类对象的任何方法都会经过该方法
             * @param o
             * @param method
             * @param objects
             * 以上参数和基于借口的动态代理是一样的
             * @param methodProxy 当前之执行方法的代理对象
             * @return
             * @throws Throwable
             */
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                //增强代码
                Object returnValue = null;
                //获取方法执行的参数
                Float money  = (Float) objects[0];
                //判断当前方法是不是销售
                if("saleProduct".equals(method.getName())){
                    returnValue = method.invoke(producer,money*0.8f);
                }
                return returnValue;
            }
        });
        cglib.saleProduct(10000f);


    }
}
