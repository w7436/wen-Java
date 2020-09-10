package nancy.dao;

import nancy.pojo.User;

import java.util.List;

/**
 * @ClassName UserDao
 * @Description TODO
 * @Author DELL
 * @Data 2020/9/10 15:34
 * @Version 1.0
 **/
public interface UserDao {
     List<User> getUserList();
}
