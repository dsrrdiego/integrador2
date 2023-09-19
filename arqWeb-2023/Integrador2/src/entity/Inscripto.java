package entity;

import javax.persistence.*;

@Entity
public class Inscripto {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "nro_libreta_estudiante")
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "id_carrera")
    private Carrera carrera;

	@Column
	private int antiguedad;

	@Column
	private boolean graduado;

	@Column
	private int anio_graduado;

	/// @JoinColumn(name="")

	// @ManyToOne
	// private Lis<Estudiante> estudiante;

	// @ManyToOne
	// private Lis<Carrera> carreras;
	//private String fechaEgreso;

	public Inscripto() {
		super();
	}

	public Inscripto(Estudiante estudiante, Carrera carrera, int antiguedad, boolean graduado) {
		this.estudiante = estudiante;
		this.carrera = carrera;
		this.antiguedad = antiguedad;
		this.graduado = graduado;
		this.anio_graduado = 0; // por defecto es 0 ya que no esta graduado
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
	@Override
	public String toString() {
		return "Inscripto [estudiante=" + estudiante + ", carrera=" + carrera + ", graduado=" + graduado + "]";
	}
	

}
