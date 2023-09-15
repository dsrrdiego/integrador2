package repository;

import java.util.List;
import entity.Estudiante;

public class EstudianteRepositoryImpl implements EstudianteRepository {

	public static EstudianteRepositoryImpl instance = new EstudianteRepositoryImpl();

	private EstudianteRepositoryImpl() {
	}

	public static EstudianteRepositoryImpl get_instance() {
		return instance;
	}

	@Override
	public Estudiante findById(Integer id) {
		return RepositoryFactory.getEntity_manager().find(Estudiante.class, id);
	}

	@Override
	public List<Estudiante> findAll() {
		return RepositoryFactory.getEntity_manager().createQuery("SELECT e FROM estudiante e", Estudiante.class)
				.getResultList();
	}

	@Override
	public Estudiante save(Estudiante Estudiante) {
		RepositoryFactory.getEntity_manager().getTransaction().begin();
		if (Estudiante.getId() == null) {
			RepositoryFactory.getEntity_manager().persist(Estudiante);
			RepositoryFactory.getEntity_manager().getTransaction().commit();
			RepositoryFactory.cerrar_conexion();
			return Estudiante;
		}
		Estudiante = RepositoryFactory.getEntity_manager().merge(Estudiante);
		RepositoryFactory.getEntity_manager().getTransaction().commit();
		RepositoryFactory.cerrar_conexion();
		return Estudiante;

	}

	@Override
	public void delete(Estudiante Estudiante) {
		RepositoryFactory.getEntity_manager().remove(Estudiante);
	}

	public List<Estudiante> estudiantesPorGenero(genero) {
		return RepositoryFactory.getEntity_manager().createQuery("SELECT e FROM estudiante e where genero = ?", Estudiante.class)
				.getResultList();
	}
}