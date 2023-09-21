package main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

<<<<<<< HEAD
import repository.RepositoryFactory;

import entity.Estudiante;
import entity.Carrera;
import entity.Inscripto;
=======
import entity.Carrera;
import entity.Estudiante;
import entity.Inscripto;
import repository.RepositoryFactory;
>>>>>>> entregable

// import entity.Estudiante;

public class Main {
	// public final static String UnidadDePresistencia="Derby";
	public final static String UnidadDePresistencia="MySql";
	public static void main(String[] args) {
<<<<<<< HEAD
		
		
		RepositoryFactory.getInstance(RepositoryFactory.MYSQL);
		
		 
		Estudiante e3=new Estudiante(892,"trotun", "grapis", 22999888 ,22, "fem","3a");
		Estudiante e = RepositoryFactory.get_repositorio_estudiante().save(e3);
		
		
		Carrera c1 = new Carrera("Tudai", 2, "ee");
		
		
		Inscripto i1 = new Inscripto(e3, c1, 2, false,"re");
		

		System.out.println(e3);

		
	}
=======

		
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
		// puntoF();

		// g) recuperar los estudiantes de una determinada carrera, filtrado por ciudad
		// de residencia.
		// puntoG();

		// 3) Generar un reporte de las carreras, que para cada carrera incluya
		// información de los
		// inscriptos y egresados por año. Se deben ordenar las carreras
		// alfabéticamente, y presentar
		// los años de manera cronológica.
		punto3();

		// puntoAgregarCarreras();

	}
	
	private static void puntoA() {
		// Estudiante e1 = new Estudiante(1,"una", "unaillino" ,29550561,41,"femenina","1 arroyos");
		// Estudiante e1 = new Estudiante(2,"dos", "dosillino" ,29550562,42,"masculine","2arroyos");
		// Estudiante e1 = new Estudiante(3,"tres", "tres de los ultimos" ,29550563,43,"femenina","3a");
		Estudiante e1 = new Estudiante(4,"cuatro", "cuatro de los ultimos" ,29550564,44,"femenina","4a");
		RepositoryFactory.get_repositorio_estudiante().save(e1);
	}

	private static void puntoB() {
		Estudiante e=RepositoryFactory.get_repositorio_estudiante().findById(4); //por numero de libreta
		Carrera c=RepositoryFactory.get_repositorio_carrera().findById(1); 
		Inscripto i =new Inscripto(e, c, 14, false);
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
		// Recuperar los estudiantes de una determinada carrera, filtrado por ciudad
		// de residencia.
		Carrera carrera=RepositoryFactory.get_repositorio_carrera().findById(2);
		String ciudad="2";
		List<Estudiante> c = RepositoryFactory.get_repositorio_estudiante().xCarreraYciudad(carrera,ciudad);
		System.out.println(c);
	}

	private static void punto3() {
		
		// 3) Generar un reporte de las carreras, que para cada carrera incluya
		// información de los
		// inscriptos y egresados por año. Se deben ordenar las carreras
		// alfabéticamente, y presentar
		// los años de manera cronológica.
		List<Carrera> carreras =RepositoryFactory.get_repositorio_carrera().findAll();
		carreras.forEach(c -> {
			System.out.println("----------------------------------------------------------------");
			System.out.println(c);
			// List<Estudiante> estudiantes = RepositoryFactory.get_repositorio_estudiante().xCarreraYciudad(carrera,ciudad);

		});

		
	}

	private static void puntoAgregarCarreras() {
		Carrera c=new Carrera("Periodismo", 5,"UNICEN");
		// Carrera c =new Carrera("Arquitectura Web", 1,"UNICEN");
		// Carrera c =new Carrera("Odontologia", 3,"UBA");
		RepositoryFactory.get_repositorio_carrera().save(c);
		}

>>>>>>> entregable
}