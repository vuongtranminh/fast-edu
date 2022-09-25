package app.command.api.data;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import app.command.api.data.ItemCartPo;

@Mapper
public interface ItemCartDao extends BaseDao<ItemCartPo> {

}