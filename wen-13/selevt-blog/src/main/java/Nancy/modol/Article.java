package Nancy.modol;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @ClassName Article
 * @Description TODO
 * @Author DELL
 * @Data 2020/5/10 15:10
 * @Version 1.0
 **/

@Setter
@Getter
@ToString
public class Article {


    private Integer id;
    private String title;
    private String content;
    private Integer userId;
    private Date createTime;

    //新增文章时
    private String userAccout;
}
