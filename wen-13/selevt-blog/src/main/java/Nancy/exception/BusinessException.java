package Nancy.exception;

/**
 * @ClassName BusinessException
 * @Description TODO
 * @Author DELL
 * @Data 2020/5/17 9:08
 * @Version 1.0
 **/
public class BusinessException extends Baseexception{

    public BusinessException(String code, String message) {
        super(code, null,message);
    }

    public BusinessException(String code, Throwable cause, String message) {
        super("BUS"+code, cause, "业务异常"+message);
    }
}
