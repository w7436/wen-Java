package Nancy.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName Baseexception
 * @Description TODO
 * @Author DELL
 * @Data 2020/5/12 16:52
 * @Version 1.0
 **/
@Setter
@Getter
public class Baseexception extends RuntimeException{
    protected  String code;

    public Baseexception(String code,String message) {
        this(code,null,message);
    }
    public Baseexception(String code,Throwable cause,String message) {
        super(message,cause);
        this.code = code;
    }
}
