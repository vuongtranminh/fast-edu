package app.command.api.data;

import java.util.List;
import app.command.api.data.Pagination;

public interface BaseDao<T> {

	List<T> findAll();
	T getById(Long id);
	int save(T t);
	int updateById(T t);
	List<T> pagination(Pagination pagination);
	Long countAll();

}