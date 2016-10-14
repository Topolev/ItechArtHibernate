package by.topolev.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T> {
	List<T> findAll();
	T create (T entity);
	void delete (T entity);
}
