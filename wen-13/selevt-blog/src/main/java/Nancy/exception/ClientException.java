package Nancy.exception;

/**
 * @ClassName ClientException
 * @Description TODO
 * @Author DELL
 * @Data 2020/5/12 17:01
 * @Version 1.0
 **/
public class ClientException extends Baseexception{

    public ClientException( String code,String message) {
        this(code,null,message);
    }

    public ClientException(String code,Throwable cause,String message) {
        super("CLI="+code, cause, "客户端异常"+message);
    }
}
