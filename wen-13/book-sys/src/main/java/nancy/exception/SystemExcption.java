package nancy.exception;

/**
 * @ClassName SystemExcption
 * @Description TODO
 * @Author DELL
 * @Data 2020/5/16 11:49
 * @Version 1.0
 **/
public class SystemExcption extends Baseexception{

    public SystemExcption(String message, String code) {
        super("SYS"+code,"服务端错误"+message);
    }

    public SystemExcption(String code, String message, Throwable cause) {
        super("SYS"+code, "服务端错误"+message, cause);
    }
}
