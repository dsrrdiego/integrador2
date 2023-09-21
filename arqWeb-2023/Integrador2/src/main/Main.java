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
		
		
		RepositoryFactory.getInstance(RepositoryFactory.MYSQL);
		
		 
		Estudiante e3=new Estudiante(892,"trotun", "grapis", 22999888 ,22, "fem","3a");
		Estudiante e = RepositoryFactory.get_repositorio_estudiante().save(e3);
		
		
		Carrera c1 = new Carrera("Tudai", 2, "ee");
		
		
		Inscripto i1 = new Inscripto(e3, c1, 2, false,"re");
		

		System.out.println(e3);

		
	}
}