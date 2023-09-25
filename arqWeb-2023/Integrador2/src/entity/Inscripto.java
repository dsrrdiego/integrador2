package entity;

import javax.persistence.*;

@Entity
@IdClass(claveCompuestaInscripto.class)
public class Inscripto {

	@Id
	@ManyToOne
	@JoinColumn(name = "nro_libreta")
	private Estudiante estudiante;

	@Id
	@ManyToOne
	@JoinColumn(name = "carrera")
	private Carrera carrera;

	@Column
	private int fecha;


	public Inscripto() {
		super();
	}


	public int getAntiguedad() {
		return antiguedad;
	}

	public Integer isEsEgresado() {
		return esEgresado;
	}

	@Column
	private int antiguedad;

	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}

	public void setEsEgresado(Integer esEgresado) {
		this.esEgresado = esEgresado;
	}

	@Column 
	private Integer esEgresado;

	public Inscripto(Estudiante e, Carrera c, int fecha) {
		this.estudiante = e;
		this.carrera = c;
		this.fecha = fecha;
	}

	public int getfecha() {
		return fecha;
	}


	public Estudiante getId() {
		return this.estudiante;
	}

	@Override
	public String toString() {
		return "Inscripto [estudiante=" + estudiante.getId() + ", carrera=" + carrera.getId_carrera() + ", fecha="
				+ fecha
				+ ", anioEgreso=" + (fecha+antiguedad) + "]";
	}
}
