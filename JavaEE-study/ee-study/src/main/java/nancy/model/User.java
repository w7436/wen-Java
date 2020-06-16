package nancy.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @ClassName User
 * @Description TODO
 * @Author DELL
 * @Data 2020/6/8 21:15
 * @Version 1.0
 **/

@Getter
@Setter
@ToString
public class User {
    protected String name;
    private String password;
    private Date birthday;



}
