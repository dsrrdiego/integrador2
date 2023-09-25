package main;

import java.util.Comparator;
import java.util.List;

import dtos.CarreraConCantidadDTO;
import dtos.EstudianteCarreraDTO;
import entity.Carrera;
import entity.Estudiante;
import entity.Inscripto;
import repository.RepositoryFactory;

public class Main {
	public final static String UnidadDePresistencia="MySql";
	// public final static String UnidadDePresistencia="Derby";

	public static void main(String[] args) {
		RepositoryFactory.getInstance(UnidadDePresistencia);

		// a) dar de alta un estudiante
		// puntoA();
		//No es autoincremental porque el Id es el numero de libreta
		
		// puntoAgregarCarreras();

		// b) matricular un estudiante en una carrera
		// puntoB();

		//b2) ingresar fecha de egreso a tal o cual alumno de tal carrera
		// puntoB2();

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
		// puntoG();

		// 3) Generar un reporte de las carreras, que para cada carrera incluya
		// información de los inscriptos y egresados por año. Se deben ordenar las carreras
		// alfabéticamente, y presentar los años de manera cronológica.
		// punto3();
	}
	
	
	private static void puntoA() {
		Estudiante e1 = new Estudiante(1,"una", "perez" ,29550561,41,"femenina","1 arroyos");
		// Estudiante e1 = new Estudiante(2,"dos", "dosillino" ,29550562,42,"masculine","2arroyos");
		// Estudiante e1 = new Estudiante(3,"tres", "triquinosis" ,29550563,23,"femenina","tres arroyos");
		// Estudiante e1 = new Estudiante(4,"cuatro", "cuartirolo" ,29550564,14,"femenina","tres algarrobos");
		RepositoryFactory.get_repositorio_estudiante().save(e1);
	}
	
	private static void puntoB() {
		Estudiante e=RepositoryFactory.get_repositorio_estudiante().findById(1); //por numero de libreta
		Carrera c=RepositoryFactory.get_repositorio_carrera().findById(2); 
		Inscripto i =new Inscripto(e, c, 2002);
		RepositoryFactory.get_repositorio_inscripto().save(i);
		
	}
	private static void puntoB2() {
		Estudiante e=RepositoryFactory.get_repositorio_estudiante().findById(2); //por numero de libreta
		Carrera c=RepositoryFactory.get_repositorio_carrera().findById(1); 
		RepositoryFactory.get_repositorio_inscripto().setEgreso(e, c, 5);
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
		List<CarreraConCantidadDTO> c = RepositoryFactory.get_repositorio_carrera().xEstudiantesInscriptos();
		System.out.println(c);
	}
	
	private static void puntoG() {
		// Recuperar los estudiantes de una determinada carrera, filtrado por ciudad
		// de residencia.
		Carrera carrera=RepositoryFactory.get_repositorio_carrera().findById(2);
		String ciudad="arroyo";
		List<Estudiante> c = RepositoryFactory.get_repositorio_estudiante().xCarreraYciudad(carrera,ciudad);
		System.out.println(c);
	}

	private static void punto3() {
		
		// 3) Generar un reporte de las carreras, que para cada carrera incluya
		// información de los inscriptos y egresados por año. Se deben ordenar las carreras
		// alfabéticamente, y presentar los años de manera cronológica.

		List<EstudianteCarreraDTO> carreras =RepositoryFactory.get_repositorio_carrera().reporte();
		carreras.sort(Comparator
		.comparing(EstudianteCarreraDTO::getNombreCarrera) 
		.thenComparing(EstudianteCarreraDTO::getFech)
		);
		System.out.println(carreras);
		
	}

	private static void puntoAgregarCarreras() {
		// Carrera c=new Carrera("Periodismo", 5,"UNICEN");
		Carrera c =new Carrera("Arquitectura Web", 1,"UNICEN");
		// Carrera c =new Carrera("Odontologia", 3,"UBA");
		// Carrera c =new Carrera("Arqueologia", 23,"EGIPCIAN");
		RepositoryFactory.get_repositorio_carrera().save(c);
		}

}