package entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Estudiante {
	@Id
	@Column(name = "nro_libreta")
	private Integer id;

    // Relación con Inscripto
    @OneToMany(mappedBy = "estudiante")
	private List<Inscripto> inscripciones;

	@Column
	private String nombre;

	@Column
	private String apellido;

	@Column(name = "dni")
	private Integer nro_doc;

	@Column
	private Integer edad;

	@Column
	private String genero;

	@Column(name = "ciudad")
	private String ciudad_reside;

	// @ManyToMany(mappedBy = "inscriptoSet")
	// private Set<Carrera> carreraSet=new HashSet<>();

	@ManyToMany
    @JoinTable(
        name = "Inscripto",
        joinColumns = @JoinColumn(name = "nro_libreta"),
        inverseJoinColumns = @JoinColumn(name = "carrera")
    )
    private List<Carrera> carreras;

	public Estudiante() {
		super();
	}

	
	public Estudiante(int nro_libreta,String nombre, String apellido, Integer nro_doc, Integer edad, String genero,
			String ciudad_reside) {
		this.id=nro_libreta;
		this.nombre = nombre;
		this.apellido = apellido;
		this.nro_doc = nro_doc;
		this.edad = edad;
		this.genero = genero;
		this.ciudad_reside = ciudad_reside;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public Integer getNro_doc() {
		return nro_doc;
	}


	public Integer getEdad() {
		return edad;
	}


	public String getGenero() {
		return genero;
	}


	public String getCiudad_reside() {
		return ciudad_reside;
	}

	// public Set<Carrera> getCarreraSet() {
		// return carreraSet;
	// }


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public void setNro_doc(Integer nro_doc) {
		this.nro_doc = nro_doc;
	}


	public void setEdad(Integer edad) {
		this.edad = edad;
	}


	public void setGenero(String genero) {
		this.genero = genero;
	}


	public void setCiudad_reside(String ciudad_reside) {
		this.ciudad_reside = ciudad_reside;
	}

	// public void setCarreraSet(Set<Carrera> carreraSet) {
		// this.carreraSet = carreraSet;
	// }


	@Override
	public String toString() {
		return "\nEstudiante [id=" + id + ", nombre= " + nombre + " Apellido= " + apellido + ", nro_doc="
				+ nro_doc+" Género: "+ genero
				+ ", ciudad residente= " + ciudad_reside + "]";
	}


	}
