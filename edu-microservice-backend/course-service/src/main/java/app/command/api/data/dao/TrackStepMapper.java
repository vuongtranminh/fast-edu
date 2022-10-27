package app.command.api.data.dao;

import org.apache.ibatis.annotations.Mapper;
import app.command.api.data.entity.TrackStepPo;

@Mapper
public interface TrackStepMapper extends BaseMapper<TrackStepPo, String> {

}