package app.command.api.data.dao;

import org.apache.ibatis.annotations.Mapper;
import app.command.api.data.entity.StepQuizPo;

@Mapper
public interface StepQuizMapper extends BaseMapper<StepQuizPo, String> {

}