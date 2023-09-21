package entity;

import javax.persistence.*;

@Entity
public class Inscripto {

	@Id
	private int nro_libreta;

	@Column
	private int carrera;

	@Column
	private int antiguedad;

	@Column
	private boolean graduado;

	@Column
	private String fecha;

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

	public int getId(){
		return this.nro_libreta;
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
