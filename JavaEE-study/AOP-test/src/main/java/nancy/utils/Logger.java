package nancy.utils;

/**
 * @ClassName Logger
 * @Description 用于记录日志的工具类，里面提供了公共的代码
 * @Author DELL
 * @Data 2020/7/14 16:10
 * @Version 1.0
 **/
public class Logger {
    /**
     * 用于打印日志，计划让其在切入点方法执行之前执行（切入点方法就是业务层方法）
     */
    public void printLog(){
        System.out.println("Logger类中的printLog方法开始记录日志");
    }
}
