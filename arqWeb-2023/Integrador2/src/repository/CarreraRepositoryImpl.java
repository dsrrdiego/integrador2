package repository;

import java.util.List;
import entity.Carrera;

public class CarreraRepositoryImpl implements CarreraRepository {

	public static CarreraRepositoryImpl instance = new CarreraRepositoryImpl();

	private CarreraRepositoryImpl() {
	}

	public static CarreraRepositoryImpl get_instance() {
		return instance;
	}

	@Override
	public Carrera findById(Integer id) {
		return RepositoryFactory.getEntity_manager().find(Carrera.class, id);
	}

	@Override
	public List<Carrera> findAll() {
		return RepositoryFactory.getEntity_manager().createQuery("SELECT e FROM Carrera e", Carrera.class)
				.getResultList();
	}

	@Override
	public Carrera save(Carrera Carrera) {
		RepositoryFactory.getEntity_manager().getTransaction().begin();
		if (Carrera.getId() == null) {
			RepositoryFactory.getEntity_manager().persist(Carrera);
			RepositoryFactory.getEntity_manager().getTransaction().commit();
			RepositoryFactory.cerrar_conexion();
			return Carrera;
		}
		Carrera = RepositoryFactory.getEntity_manager().merge(Carrera);
		RepositoryFactory.getEntity_manager().getTransaction().commit();
		RepositoryFactory.cerrar_conexion();
		return Carrera;

	}

	@Override
	public void delete(Carrera Carrera) {
		RepositoryFactory.getEntity_manager().remove(Carrera);
	}
}