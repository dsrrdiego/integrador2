package modelos;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Estudiante {

	@Id
	@Column(name = "nro_libreta")
	private int id;

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

	@OneToMany
	private List<Estudiante> estudiante;

	public Estudiante() {
		super();
	}

	public Estudiante(int nro_libreta, String nombre, String apellido, int nro_doc, int edad, String ciudad) {
		super();
		this.id = nro_libreta;
		this.nombre = nombre;
		this.apellido = apellido;
		this.nro_doc = nro_doc;
		this.edad = edad;
		this.ciudad_reside = ciudad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getNroDoc() {
		return nro_doc;
	}

	public void setNroDoc(int nro_doc) {
		this.nro_doc = nro_doc;
	}

	public String getCiudadReside() {
		return ciudad_reside;
	}

	public void setCiudadReside(String ciudad) {
		this.ciudad_reside = ciudad;
	}

	@Override
	public String toString() {
		return "Estudiante [id=" + id + ", nombre=" + nombre + "apellido=" + apellido + ", nro_doc="
				+ nro_doc
				+ ", ciudad residente=" + ciudad_reside + "]";
	}
}
