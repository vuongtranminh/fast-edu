package app.command.api.data;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import app.command.api.data.AddressPo;

@Mapper
public interface AddressDao extends BaseDao<AddressPo> {

}