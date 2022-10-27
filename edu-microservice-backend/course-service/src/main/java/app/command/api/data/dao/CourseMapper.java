package app.command.api.data.dao;

import org.apache.ibatis.annotations.Mapper;
import app.command.api.data.entity.CoursePo;

@Mapper
public interface CourseMapper extends BaseMapper<CoursePo, String> {

}