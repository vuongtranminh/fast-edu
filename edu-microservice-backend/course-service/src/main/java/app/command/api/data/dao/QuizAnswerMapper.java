package app.command.api.data.dao;

import org.apache.ibatis.annotations.Mapper;
import app.command.api.data.entity.QuizAnswerPo;

@Mapper
public interface QuizAnswerMapper extends BaseMapper<QuizAnswerPo, String> {

}