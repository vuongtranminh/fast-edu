package app.command.api.data.dao;

import org.apache.ibatis.annotations.Mapper;
import app.command.api.data.entity.StepLessonPo;

@Mapper
public interface StepLessonMapper extends BaseMapper<StepLessonPo, String> {

}