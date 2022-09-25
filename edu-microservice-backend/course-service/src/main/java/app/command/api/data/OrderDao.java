package app.command.api.data;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import app.command.api.data.OrderPo;

@Mapper
public interface OrderDao extends BaseDao<OrderPo> {

}