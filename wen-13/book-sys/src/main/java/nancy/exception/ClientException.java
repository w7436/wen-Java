package nancy.exception;

/**
 * @ClassName ClientException
 * @Description TODO
 * @Author DELL
 * @Data 2020/5/12 17:01
 * @Version 1.0
 **/
public class ClientException extends Baseexception{


    public ClientException(String message, String code) {
        super("CLI"+code,"客户端错误"+message);
    }

    public ClientException(String code, String message, Throwable cause) {
        super("CLI"+code, "客户端错误"+message, cause);
    }
}
