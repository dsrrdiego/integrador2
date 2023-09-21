package repository;

import java.util.Collections;
import java.util.List;

import javax.persistence.TypedQuery;

import entity.Carrera;
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
		return RepositoryFactory.getEntity_manager().createQuery("SELECT e FROM Estudiante e ORDER BY e.id", Estudiante.class).getResultList();
	}
	public List<Estudiante> xGenero(String g){
		String consulta = "SELECT e FROM Estudiante e WHERE e.genero LIKE :generoParametro ORDER BY e.apellido, e.nombre";
		TypedQuery<Estudiante> query = RepositoryFactory.getEntity_manager().createQuery(consulta, Estudiante.class);
		query.setParameter("generoParametro", "%"+g+"%");
		return query.getResultList();
	}

	@Override
	public Estudiante save(Estudiante estudiante) {

		RepositoryFactory.getEntity_manager().getTransaction().begin();
		if (estudiante.getId() == 0) {
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

    public List<Estudiante> xCarreraYciudad(Carrera carrera, String ciudad) {
		String consulta = "SELECT e FROM Estudiante e JOIN e.carreras c WHERE c = :carr AND e.ciudad_reside LIKE :city";
		TypedQuery<Estudiante> query = RepositoryFactory.getEntity_manager().createQuery(consulta, Estudiante.class);
		query.setParameter("carr", carrera);
		query.setParameter("city", "%"+ciudad+"%");
		return query.getResultList();
        // return null;
    }


}