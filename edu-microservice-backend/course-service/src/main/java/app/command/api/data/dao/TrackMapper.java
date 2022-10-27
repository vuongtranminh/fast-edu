package app.command.api.data.dao;

import org.apache.ibatis.annotations.Mapper;
import app.command.api.data.entity.TrackPo;

@Mapper
public interface TrackMapper extends BaseMapper<TrackPo, String> {

}