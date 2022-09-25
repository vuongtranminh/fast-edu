package app.command.api.data;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import app.command.api.data.OrderItemPo;

@Mapper
public interface OrderItemDao extends BaseDao<OrderItemPo> {

}