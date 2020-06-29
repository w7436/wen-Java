package exception;

/**
 * @ClassName BaseException
 * @Description TODO
 * @Author DELL
 * @Data 2020/6/25 15:39
 * @Version 1.0
 **/
public class BaseException extends RuntimeException{

    public BaseException(Throwable cause, String message) {
        super(message);
    }
}
