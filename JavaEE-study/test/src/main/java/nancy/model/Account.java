package nancy.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @ClassName Account
 * @Description TODO
 * @Author DELL
 * @Data 2020/7/13 23:24
 * @Version 1.0
 **/

@Getter
@Setter
@ToString
public class Account implements Serializable {
    private Integer id;
    private String name;
    private Float money;


}
