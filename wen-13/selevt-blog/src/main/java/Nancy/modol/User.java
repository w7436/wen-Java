package Nancy.modol;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @ClassName User
 * @Description TODO
 * @Author DELL
 * @Data 2020/5/10 15:10
 * @Version 1.0
 **/


@Getter
@Setter
@ToString
public class User {
    private Integer id;
    private String name;
    private Date createTime;

}
