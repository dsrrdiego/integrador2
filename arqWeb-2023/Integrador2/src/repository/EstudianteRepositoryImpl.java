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
	// este devuelve un estudiante por su id que seria el nro de libreta
	public Estudiante findById(Integer id) {
		return RepositoryFactory.getEntity_manager().find(Estudiante.class, id);
	}

	@Override
	public List<Estudiante> findAll() {
		return RepositoryFactory.getEntity_manager().createQuery("SELECT e FROM estudiante e", Estudiante.class)
				.getResultList();
	}

	@Override
	public Estudiante save(Estudiante estudiante) {

		RepositoryFactory.getEntity_manager().getTransaction().begin();
		if (estudiante.getId() == null) {
			RepositoryFactory.getEntity_manager().persist(estudiante);
			RepositoryFactory.getEntity_manager().getTransaction().commit();
			RepositoryFactory.cerrar_conexion();
			return estudiante;
		}
		estudiante = RepositoryFactory.getEntity_manager().merge(estudiante);
		RepositoryFactory.getEntity_manager().getTransaction().commit();
		RepositoryFactory.cerrar_conexion();
		return estudiante;

	}

	@Override
	public void delete(Estudiante Estudiante) {
		RepositoryFactory.getEntity_manager().remove(Estudiante);
	}

	/* // recupera todos los estudiantes en base a su genero 
	public List<Estudiante> estudiantesPorGenero(genero) { // me falta pasarle el parmetro a la consulta
		
		Query sql1= ("SELECT e FROM estudiante e where genero = :sexo", Estudiante.class);
		sql.setParameter("sexo", genero);
		RepositoryFactory.getEntity_manager().createQuery(sql1).getResultList();
	}

	// recuperar un estudiante, en base a su número de libreta universitaria.
	public List<Estudiante> estudiantesPorLegajo(nro_libreta) { // me falta pasarle el parmetro a la consulta
		
		Query sql=("SELECT e FROM estudiante e where nro_libreta = :libreta", Estudiante.class);
		sql.setParameter("libreta", libreta);
		RepositoryFactory.getEntity_manager().createQuery(sql).getResultList();
	} */

}