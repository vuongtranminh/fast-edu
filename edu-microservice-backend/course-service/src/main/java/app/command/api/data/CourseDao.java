package app.command.api.data;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import app.command.api.data.CoursePo;

@Mapper
public interface CourseDao extends BaseDao<CoursePo> {

}