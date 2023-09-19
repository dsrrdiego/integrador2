package main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import repository.RepositoryFactory;

import entity.Estudiante;
import entity.Carrera;
import entity.Inscripto;

public class Main {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Integrador2");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		// Estudiante e1=new Estudiante(1,"pepe","arr",2951,11,"3arroyos1");
		// em.persist(e1);
		/*List<Estudiante> estudiantes = em.createQuery("select e from Estudiante e").getResultList();
		estudiantes.forEach(c -> System.out.println(c));*/

		List<Carrera> carreras = em.createQuery("select c from Carrera c").getResultList();
		carreras.forEach(c -> System.out.println(c));

		List<Inscripto> inscriptos = em.createQuery("select c from Inscripto c").getResultList();
		inscriptos.forEach(c -> System.out.println(c));

		// a) dar de alta un estudiante
		// puntoA(em);
		RepositoryFactory.getInstance(RepositoryFactory.MYSQL);

		Estudiante e1 = new Estudiante(1,"pepe","arr",2951,11,"3arroyos1");
		Estudiante e = RepositoryFactory.get_repositorio_estudiante().save(e1);

		Estudiante e2 = new Estudiante(2,"manolo","fugo",51,18,"Chaves");
		Estudiante e = RepositoryFactory.get_repositorio_estudiante().save(e2);

		System.out.println(j);

		// b) matricular un estudiante en una carrera
		//puntoB(e1, 3, '2023');
		//puntoB(e2, 3, '2023');
		puntoB(em);

		// c) recuperar todos los estudiantes, y especificar algún criterio de
		// ordenamiento simple.
		puntoC();

		// d) recuperar un estudiante, en base a su número de libreta universitaria.
		int nro_libreta = 123;
		puntoD(nro_libreta);
		
		

		// e) recuperar todos los estudiantes, en base a su género.
		puntoE();
		

		// f) recuperar las carreras con estudiantes inscriptos, y ordenar por cantidad
		// de inscriptos.
		

		puntoF();

		// g) recuperar los estudiantes de una determinada carrera, filtrado por ciudad
		// de residencia.
		

		puntoG();

		// 3) Generar un reporte de las carreras, que para cada carrera incluya
		// información de los
		// inscriptos y egresados por año. Se deben ordenar las carreras
		// alfabéticamente, y presentar
		// los años de manera cronológica.
		punto3();

		em.getTransaction().commit();
		em.close();
		emf.close();
	}

	private static void puntoA(EntityManager em) {

		Estudiante e1=new Estudiante(1,"pepe","arr",2951,11,"3arroyos1");
		// Estudiante e1=new Estudiante(1,"pepe","arr",2951,11,"3arroyos1");
		// Estudiante e1=new Estudiante("olfa","croquetis","29555000",33,"fem","3a");
		Estudiante e1=new Estudiante(456,"trotun", "grapis", 22999888 ,22, "fem","3a");
		em.persist(e1);
		// Estudiante e2=new Estudiante(2,"MANU","arr",2971,11,"3arroyos1");
		// em.persist(e2);
	}

	/*private static void puntoB(EntityManager em, e1, carrera, '2023') {

		Inscripto ins = new Inscripto(int nro_libreta, int carrera, int antiguedad, boolean graduado); 
		em.save(ins);
	}*/

	
	private static void puntoB(EntityManager em) { 
		Estudiante e3=new Estudiante(822,"trotun", "grapis", 22999888 ,22, "fem","3a");
		em.persist(e3);
		
		Carrera c1 = new Carrera("Tudai", 2, "ee");
		em.persist(c1);
		
		Inscripto i1 = new Inscripto(e3, c1, 2, false);
		em.persist(i1);
	}

	private static void puntoC() {

		return List<Estudiante> estudiantes = RepositoryFactory.get_repositorio_estudiante().findAll();
	}

	private static void puntoD(nro_libreta) {

		return RepositoryFactory.get_repositorio_estudiante().findById(nro_libreta);
	}

	private static void puntoE() {

		// SELECT * FROM `estudiante` WHERE genero = ? ORDER BY apellido, nombre
	}

	private static void puntoF() {

		/* SELECT * FROM `inscripto` as ins
		INNER JOIN estudiante as e on ins.nro_libreta = e.nro_libreta
		INNER JOIN carrera as c on ins.carrera = c.id_carrera
		ORDER BY e.apellido, e.nombre; */
	}

	private static void puntoG() {

		/*SELECT * FROM `inscripto` as ins 
		INNER JOIN estudiante as e on ins.nro_libreta = e.nro_libreta 
		INNER JOIN carrera as c on ins.carrera = c.id_carrera where c.id_carrera = 3 and e.ciudad_reside like '%ne%' ORDER BY e.apellido, e.nombre; */
	}

	private static void puntoH() {
	}

	private static void punto3() {

		/* SELECT * FROM `inscripto` as ins
		INNER JOIN estudiante as e on ins.nro_libreta = e.nro_libreta
		INNER JOIN carrera as c on ins.carrera = c.id_carrera
        where ins.graduado= 1 
		ORDER BY ins.anio_graduado DESC,  c.nombre, e.apellido, e.nombre; */
	}

}