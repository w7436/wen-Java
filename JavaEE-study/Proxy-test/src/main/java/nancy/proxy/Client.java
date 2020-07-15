package nancy.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

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
         *          2、基于子类
         */
        IProducer iProducer = (IProducer)Proxy.newProxyInstance(producer.getClass().getClassLoader(), producer.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     * 作用:执行被代理对象的任何接口方法都会经过该方法
                     * @param proxy 代理对象的引用
                     * @param method 当前执行的方法
                     * @param args 当前执行方法所需要的参数
                     * @return 和被代理对象方法有相同的返回值
                     * @throws Throwable
                     */
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //增强代码
                        Object returnValue = null;
                        //获取方法执行的参数
                        Float money  = (Float) args[0];
                        //判断当前方法是不是销售
                        if("saleProduct".equals(method.getName())){
                            returnValue = method.invoke(producer,money*0.8f);
                        }
                        return returnValue;
                    }
                });
        iProducer.saleProduct(10000f);
    }
}
