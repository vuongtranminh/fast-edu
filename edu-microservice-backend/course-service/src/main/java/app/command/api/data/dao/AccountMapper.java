package app.command.api.data.dao;

import org.apache.ibatis.annotations.Mapper;
import app.command.api.data.entity.AccountPo;

@Mapper
public interface AccountMapper extends BaseMapper<AccountPo, String> {

}