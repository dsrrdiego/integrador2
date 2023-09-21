package repository;

import java.util.List;

import javax.persistence.TypedQuery;

import entity.Carrera;
import entity.Estudiante;

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
		return RepositoryFactory.getEntity_manager().createQuery("SELECT e FROM Carrera e", Carrera.class).getResultList();
	}



	@Override
	public Carrera save(Carrera carrera) {
		RepositoryFactory.getEntity_manager().getTransaction().begin();
		if (carrera.getId_carrera() == 0) {
			RepositoryFactory.getEntity_manager().persist(carrera);
			RepositoryFactory.getEntity_manager().getTransaction().commit();
			RepositoryFactory.cerrar_conexion();
			return carrera;
		}
		carrera = RepositoryFactory.getEntity_manager().merge(carrera);
		RepositoryFactory.getEntity_manager().getTransaction().commit();
		RepositoryFactory.cerrar_conexion();
		return carrera;

	}

	@Override
	public void delete(Carrera Carrera) {
		RepositoryFactory.getEntity_manager().remove(Carrera);
	}

    public List<Carrera> xEstudiantesInscriptos() {
		// f) recuperar las carreras con estudiantes inscriptos, y ordenar por cantidad
		// de inscriptos.

		// String consulta="SELECT c FROM Carrera c JOIN c.estudiantes e ORDER BY GROUP BY c HAVING COUNT(e) ";
		 String consulta= "SELECT c FROM Carrera c ORDER BY SIZE(c.estudiantes) ";
		TypedQuery<Carrera> query = RepositoryFactory.getEntity_manager().createQuery(consulta, Carrera.class);
		return query.getResultList();
    }
}