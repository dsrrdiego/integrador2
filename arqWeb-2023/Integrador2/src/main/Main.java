package main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entity.Carrera;
import entity.Estudiante;
import entity.Inscripto;
import repository.RepositoryFactory;

// import entity.Estudiante;

public class Main {
	// public final static String UnidadDePresistencia="Derby";
	public final static String UnidadDePresistencia="MySql";
	public static void main(String[] args) {

		// estudiantes.forEach(c -> System.out.println(c));
		
		RepositoryFactory.getInstance(UnidadDePresistencia);
		// a) dar de alta un estudiante
		// puntoA();
		//No es autoincremental porque el Id es el numero de libreta

		// b) matricular un estudiante en una carrera
		// puntoB();

		// c) recuperar todos los estudiantes, y especificar algún criterio de
		// ordenamiento simple.
		// puntoC();

		// d) recuperar un estudiante, en base a su número de libreta universitaria.
		// puntoD(2);

		// e) recuperar todos los estudiantes, en base a su género.
		// puntoE("fem");

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
		// punto3();

		puntoAgregarCarreras();

		// em.getTransaction().commit();
		// em.close();
		// emf.close();
	}
	
	private static void puntoA() {
		Estudiante e1 = new Estudiante(3,"tres", "tres de los ultimos" ,29550563,43,"femenina","4a");
		RepositoryFactory.get_repositorio_estudiante().save(e1);
	}

	private static void puntoB() {
		Inscripto i=new Inscripto(3, 1, 1, false);
		RepositoryFactory.get_repositorio_inscripto().save(i);

	}

	private static void puntoC() {
		List<Estudiante> estudiantes = RepositoryFactory.get_repositorio_estudiante().findAll();
		System.out.println(estudiantes);
		
	}
	
	private static void puntoD(int nro_libreta) {
		Estudiante e=RepositoryFactory.get_repositorio_estudiante().findById(nro_libreta);
		System.out.println(e);
	}
	
	private static void puntoE(String g) {
		List<Estudiante> estudiantes = RepositoryFactory.get_repositorio_estudiante().xGenero(g);
		System.out.println(estudiantes);
	}
	
	private static void puntoF() {
		// f) recuperar las carreras con estudiantes inscriptos, y ordenar por cantidad
		// de inscriptos.
		List<Carrera> c = RepositoryFactory.get_repositorio_carrera().xEstudiantesInscriptos();
		System.out.println(c);
	}

	private static void puntoG() {
	}

	private static void puntoH() {
	}

	private static void punto3() {
	}

	private static void puntoAgregarCarreras() {
		// Carrera c=new Carrera("Periodismo", 5,"UNICEN");
		// Carrera c =new Carrera("Arquitectura Web", 1,"UNICEN");
		// Carrera c =new Carrera("Odontologia", 3,"UBA");
		// RepositoryFactory.get_repositorio_carrera().save(c);
		}

}