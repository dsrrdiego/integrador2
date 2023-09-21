package entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

// import antlr.collections.List;

// import org.hibernate.mapping.List;

@Entity
public class Carrera {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id_carrera;

    // Relación con Inscripto
    @OneToMany(mappedBy = "carrera")
    private List<Inscripto> inscripciones;

	@Column
	private String nombre;

	@Column
	private int duracion;

	@Column
	private String institucion;


	// @ManyToMany
	// private Set<Estudiante> inscriptoSet=new HashSet<>();

	@ManyToMany(mappedBy = "carreras")
    private List<Estudiante> estudiantes;

	public Carrera() {
		super();
	}

	public Carrera(String nombre, int duracion, String institucion) {
		this.nombre = nombre;
		this.duracion = duracion;
		this.institucion = institucion;
	}

	public Integer getId_carrera() {
		return this.id_carrera;
	}

	public void setId_carrera(int id_carrera) {
		this.id_carrera = id_carrera;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public String getInstitucion() {
		return institucion;
	}

	public void setInstitucion(String institucion) {
		this.institucion = institucion;
	}

	@Override
	public String toString() {
		return "Carrera [id_carrera= " + id_carrera + ", nombre= " + nombre + ", duracion= " + duracion + ", institucion= "
				+ institucion + "]";
	}

}
