package nancy.exception;

/**
 * @ClassName BusinessException
 * @Description TODO
 * @Author DELL
 * @Data 2020/5/17 9:08
 * @Version 1.0
 **/
public class BusinessException extends Baseexception{

    public BusinessException(String message, String code) {
        super("BUS"+code,"业务错误"+message);
    }

    public BusinessException(String code, String message, Throwable cause) {
        super("BUS"+code, "业务错误"+message, cause);
    }
}
