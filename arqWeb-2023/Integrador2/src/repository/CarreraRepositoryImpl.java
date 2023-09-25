package repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import dtos.CarreraConCantidadDTO;
import dtos.EstudianteCarreraDTO;
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
	public Carrera save(Carrera carrera) {
		RepositoryFactory.getEntity_manager().getTransaction().begin();
		if (carrera.getId_carrera() == null) {
			RepositoryFactory.getEntity_manager().persist(carrera);
		} else {
			carrera = RepositoryFactory.getEntity_manager().merge(carrera);
		}

		RepositoryFactory.getEntity_manager().getTransaction().commit();
		RepositoryFactory.cerrar_conexion();
		return carrera;

	}

	@Override
	public void delete(Carrera Carrera) {
		RepositoryFactory.getEntity_manager().remove(Carrera);
	}

	public List<CarreraConCantidadDTO> xEstudiantesInscriptos() {
		// f) recuperar las carreras con estudiantes inscriptos, y ordenar por cantidad
		// de inscriptos.

		// String consulta = "SELECT c FROM Carrera c ORDER BY SIZE(c.estudiantes) ";
		// TypedQuery<Carrera> query =
		// RepositoryFactory.getEntity_manager().createQuery(consulta, Carrera.class);
		// return query.getResultList();

		String consulta = "SELECT NEW dtos.CarreraConCantidadDTO(c , SIZE(c.estudiantes)) FROM Carrera c ORDER BY SIZE(c.estudiantes)";

		return RepositoryFactory.getEntity_manager().createQuery(consulta,
				CarreraConCantidadDTO.class).getResultList();

	}

	/**
	 * Generar un reporte de las carreras, que para cada carrera incluya información
	 * de los
	 * inscriptos y egresados por año. Se deben ordenar las carreras
	 * alfabéticamente, y presentar
	 * los años de manera cronológica
	 */
	public List<EstudianteCarreraDTO> reporte() {
		String consulta = "SELECT NEW dtos.EstudianteCarreraDTO(c , e, i, i.fecha as fech) FROM Inscripto i JOIN i.estudiante e JOIN i.carrera c";
		TypedQuery<EstudianteCarreraDTO> query = RepositoryFactory.getEntity_manager().createQuery(consulta,
				EstudianteCarreraDTO.class);
		List<EstudianteCarreraDTO> ingresos = query.getResultList();

		consulta = "SELECT NEW dtos.EstudianteCarreraDTO(c , e, i, (i.fecha + i. antiguedad) as fech) FROM Inscripto i JOIN i.estudiante e JOIN i.carrera c WHERE i.esEgresado IS TRUE";
		query = RepositoryFactory.getEntity_manager().createQuery(consulta, EstudianteCarreraDTO.class);
		List<EstudianteCarreraDTO> egrersos = query.getResultList();

		List<EstudianteCarreraDTO> resultados = new ArrayList<>();
		resultados.addAll(ingresos);
		resultados.addAll(egrersos);

		return resultados;
	}

}