package Nancy.modol;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @ClassName Result
 * @Description TODO
 * @Author DELL
 * @Data 2020/5/12 15:16
 * @Version 1.0
 **/

@Setter
@Getter
@ToString
public class Result {
    private boolean success;
    private String message;
    private String stackTrace;
    private Object data;
}
