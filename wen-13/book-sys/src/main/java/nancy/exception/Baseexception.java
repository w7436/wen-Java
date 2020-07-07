package nancy.exception;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @ClassName Baseexception
 * @Description TODO
 * @Author DELL
 * @Data 2020/5/12 16:52
 * @Version 1.0
 **/
@Setter
@Getter
@ToString
public class Baseexception extends RuntimeException{
    protected  String code;

    public Baseexception(String message, String code) {
        super(message);
        this.code = code;
    }

    public Baseexception( String code,String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }
}
