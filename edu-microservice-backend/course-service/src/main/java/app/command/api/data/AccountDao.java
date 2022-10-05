package app.command.api.data;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import app.command.api.data.AccountPo;

@Mapper
public interface AccountDao extends BaseDao<AccountPo, Integer> {

}