package app.command.api.data;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import app.command.api.data.ProductPo;

@Mapper
public interface ProductDao extends BaseDao<ProductPo> {

}