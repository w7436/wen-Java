package Nancy.exception;

/**
 * @ClassName SystemExcption
 * @Description TODO
 * @Author DELL
 * @Data 2020/5/16 11:49
 * @Version 1.0
 **/
public class SystemExcption extends Baseexception{
    public SystemExcption(String code,String message) {
        this(code,null,message);
    }
    public SystemExcption(String code,Throwable cause,String message) {
       super("SYS"+code,cause,"系统异常"+message);
    }
}
