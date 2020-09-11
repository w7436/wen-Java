package nancy.dao;

import nancy.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * @ClassName UserDao
 * @Description TODO
 * @Author DELL
 * @Data 2020/9/10 15:34
 * @Version 1.0
 **/
public interface UserMapper {
     //获取全部用户
     List<User> getUserList();
     //根据id查询用户
     User getUserById(int id);
     //添加用户
     int insertUser(User user);
     //修改用户
     int updateUser(User user);
     //利用map进行添加用户
    int addUser1(Map<String,Object> map);

    //模糊查询
     List<User> getUserLike(String name);
}

