package nancy.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @ClassName Response
 * @Description TODO
 * @Author DELL
 * @Data 2020/6/16 19:53
 * @Version 1.0
 **/

@Setter
@Getter
@ToString
public class Response {
    private boolean success;//操作是否成功
    private String code;//错误码
    private String message;//错误信息
    private String stackTrance;//堆栈信息
    private Object data;//数据
}
