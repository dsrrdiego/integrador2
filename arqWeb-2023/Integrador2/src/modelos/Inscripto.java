package modelos;

import javax.persistence.*;

@Entity
public class Inscripto {

	// @EmbeddedId
	// private claveCompuestaInscripto ids;
	@Id
	private int nro_libreta;

	@Column
	private int carrera;
	
	// @ManyToOne
	// @JoinColumn(name = "id_carrera")
	// private Inscripto inscripto;
	
	/*
	
		// private Estudiante estudiante;
		// @JoinColumn(name = "nro_libreta")
	 * @Id
	 * 
	 * @JoinColumn(name="nro_libreta")
	 * private Estudiante estudiante;
	 */
	// @ManyToOne
	// @JoinColumn(name="id_carrera")
	// @Column
	// private int carrera;
	// private Carrera carrera;

	@Column
	private int antiguedad;

	@Column
	private boolean graduado;

	/// @JoinColumn(name="")

	// @ManyToOne
	// private Lis<Estudiante> estudiante;

	// @ManyToOne
	// private Lis<Carrera> carreras;

	public Inscripto() {
		super();
	}

	public Inscripto(int nro_libreta, int carrera, int antiguedad, boolean graduado) {
		this.nro_libreta =nro_libreta ;
		this.carrera = carrera;
		this.antiguedad = antiguedad;
		this.graduado = graduado;
	}

	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}

	public boolean isGraduado() {
		return graduado;
	}

	public void setGraduado(boolean graduado) {
		this.graduado = graduado;
	}
	/*
	 * @Override
	 * public String toString() {
	 * return "Inscripto [nro_libreta_estudiante=" + nro_libreta_estudiante +
	 * ", id_carrera=" + id_carrera
	 * + ", antiguedad=" + antiguedad + ", graduado=" + graduado + "]";
	 * }
	 */

}
