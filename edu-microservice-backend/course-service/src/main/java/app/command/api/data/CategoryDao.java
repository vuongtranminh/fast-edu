package app.command.api.data;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import app.command.api.data.CategoryPo;

@Mapper
public interface CategoryDao extends BaseDao<CategoryPo> {

}