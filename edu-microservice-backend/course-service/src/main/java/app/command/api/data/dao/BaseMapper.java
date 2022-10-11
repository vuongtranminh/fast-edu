package app.command.api.data.dao;

import java.util.List;
import app.command.api.data.Pagination;

public interface BaseMapper<T, ID> {

	List<T> findAll();
	T getById(ID id);
	int save(T t);
	int updateById(T t);
	int deleteById(ID id);
	List<T> pagination(Pagination pagination);
	Long countAll();

}