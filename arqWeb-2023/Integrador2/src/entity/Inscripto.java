package entity;

import javax.persistence.*;

@Entity
public class Inscripto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private int id;

	@ManyToOne
    @JoinColumn(name = "nro_libreta")
	private Estudiante estudiante;

	@ManyToOne
    @JoinColumn(name = "carrera")
	private Carrera carrera;

	@Column
	private int antiguedad;

	@Column
	private boolean graduado;

	@Column
	private String fecha;

	public Inscripto() {
		super();
	}

	public Inscripto(Estudiante e, Carrera c, int antiguedad, boolean graduado) {
		this.estudiante =e ;
		this.carrera = c;
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

	public int getId(){
		return this.estudiante.getId();
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
