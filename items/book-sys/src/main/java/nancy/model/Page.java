package nancy.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @ClassName Page
 * @Description TODO
 * @Author DELL
 * @Data 2020/7/14 18:52
 * @Version 1.0
 **/
@Setter
@Getter
@ToString
public class Page {
    private String searchText;
    private String sortOrder;
    private Integer pageSize;
    private Integer pageNumber;
}
