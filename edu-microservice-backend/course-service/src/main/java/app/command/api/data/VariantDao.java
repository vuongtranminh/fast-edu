package app.command.api.data;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import app.command.api.data.VariantPo;

@Mapper
public interface VariantDao extends BaseDao<VariantPo> {

}