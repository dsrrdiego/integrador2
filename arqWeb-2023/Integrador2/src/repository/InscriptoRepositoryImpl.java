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
}