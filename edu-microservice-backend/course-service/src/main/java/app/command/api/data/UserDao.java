package app.command.api.data;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import app.command.api.data.UserPo;

@Mapper
public interface UserDao extends BaseDao<UserPo> {

}