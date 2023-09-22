package repository;

import java.util.List;
import entity.Inscripto;

public class InscriptoRepositoryImpl implements InscriptoRepository {

	public static InscriptoRepositoryImpl instance = new InscriptoRepositoryImpl();

	private InscriptoRepositoryImpl() {
	}

	public static InscriptoRepositoryImpl get_instance() {
		return instance;
	}

	@Override
	public Inscripto findById(Integer id) {
		return RepositoryFactory.getEntity_manager().find(Inscripto.class, id);
	}

	@Override
	public List<Inscripto> findAll() {
		return RepositoryFactory.getEntity_manager().createQuery("SELECT e FROM Inscripto e", Inscripto.class)
				.getResultList();
	}

	@Override
	public Inscripto save(Inscripto Inscripto) {
		RepositoryFactory.getEntity_manager().getTransaction().begin();
		if (Inscripto.getId() == null) {
			RepositoryFactory.getEntity_manager().persist(Inscripto);
			RepositoryFactory.getEntity_manager().getTransaction().commit();
			RepositoryFactory.cerrar_conexion();
			return Inscripto;
		}
		Inscripto = RepositoryFactory.getEntity_manager().merge(Inscripto);
		RepositoryFactory.getEntity_manager().getTransaction().commit();
		RepositoryFactory.cerrar_conexion();
		return Inscripto;

	}

	@Override
	public void delete(Inscripto Inscripto) {
		RepositoryFactory.getEntity_manager().remove(Inscripto);
	}

	/* // F - recuperar las carreras con estudiantes inscriptos, y ordenar por cantidad de inscriptos.
	public List<Estudiante> estudiantesInscriptos() { 
		
		Query sql=("SELECT * FROM `inscripto` as ins
		INNER JOIN estudiante as e on ins.nro_libreta = e.nro_libreta
		INNER JOIN carrera as c on ins.carrera = c.id_carrera
		ORDER BY e.apellido, e.nombre;", Inscripto.class);
		RepositoryFactory.getEntity_manager().createQuery(sql).getResultList();
	}


	// G - recuperar los estudiantes de una determinada carrera, filtrado por ciudad de residencia
	public List<Estudiante> estudiantesInscriptos(int carrera, String ciudad) { 
		
		Query sql=("SELECT * FROM `inscripto` as ins 
		INNER JOIN estudiante as e on ins.nro_libreta = e.nro_libreta 
		INNER JOIN carrera as c on ins.carrera = c.id_carrera where c.id_carrera = :carrera and e.ciudad_reside like '%:ciudad%' ORDER BY e.apellido, e.nombre;", Inscripto.class);
		sql.setParameter("carrera", carrera);
		sql.setParameter("ciudad", ciudad);
		RepositoryFactory.getEntity_manager().createQuery(sql).getResultList();
	} */
}