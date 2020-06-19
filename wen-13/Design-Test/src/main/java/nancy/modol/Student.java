package nancy.modol;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @ClassName Student
 * @Description TODO
 * @Author DELL
 * @Data 2020/6/17 9:29
 * @Version 1.0
 **/

@Setter
@Getter
@ToString
public class Student {
    private int Id;//学生ID
    private String name;//姓名
    private String department;//系
    private int score;//成绩
}
