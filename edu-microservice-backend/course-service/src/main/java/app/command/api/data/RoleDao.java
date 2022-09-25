package app.command.api.data;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import app.command.api.data.RolePo;

@Mapper
public interface RoleDao extends BaseDao<RolePo> {

}