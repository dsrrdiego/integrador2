package repository;

import java.util.List;

public interface BaseRepository<T, ID> {
	
	T findById(ID id);

	/* listar los resultados */
	List<T> findAll();

	/* guardar informacion*/
	T save(T entity);
	
	/* eliminar informacion*/
	void delete(T entity);
}
