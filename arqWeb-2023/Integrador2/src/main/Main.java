package main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelos.Estudiante;

public class Main {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Integrador2");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		// Estudiante e1=new Estudiante(1,"pepe","arr",2951,11,"3arroyos1");
		// em.persist(e1);
		List<Estudiante> estudiantes = em.createQuery("select c from Estudiante c").getResultList();
		estudiantes.forEach(c -> System.out.println(c));

		// a) dar de alta un estudiante
		// puntoA(em);

		// b) matricular un estudiante en una carrera
		puntoB();

		// c) recuperar todos los estudiantes, y especificar algún criterio de
		// ordenamiento simple.
		puntoC();

		// d) recuperar un estudiante, en base a su número de libreta universitaria.
		puntoD();

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
		em.persist(e1);
		Estudiante e2=new Estudiante(2,"MANU","arr",2971,11,"3arroyos1");
		em.persist(e2);
	}

	private static void puntoB() {
	}

	private static void puntoC() {
	}

	private static void puntoD() {
	}

	private static void puntoE() {
	}

	private static void puntoF() {
	}

	private static void puntoG() {
	}

	private static void puntoH() {
	}

	private static void punto3() {
	}

}