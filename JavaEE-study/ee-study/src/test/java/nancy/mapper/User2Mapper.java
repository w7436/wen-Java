package nancy.mapper;

import java.util.List;
import nancy.model.User2;

public interface User2Mapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User2 record);

    User2 selectByPrimaryKey(Integer id);

    List<User2> selectAll();

    int updateByPrimaryKey(User2 record);
}