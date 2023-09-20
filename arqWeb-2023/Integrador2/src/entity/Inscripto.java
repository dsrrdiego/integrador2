package entity;

import javax.persistence.*;

@Entity
public class Inscripto {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

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
	private String fechaEgreso;

	public Inscripto() {
		super();
	}

	public Inscripto(Estudiante estudiante, Carrera carrera, int antiguedad, boolean graduado, String fechaEgreso) {
		this.estudiante = estudiante;
		this.carrera = carrera;
		this.antiguedad = antiguedad;
		this.graduado = graduado;
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public Carrera getCarrera() {
		return carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}

	public int getAntiguedad() {
		return antiguedad;
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

	public String getFechaEgreso() {
		return fechaEgreso;
	}

	public void setFechaEgreso(String fechaEgreso) {
		this.fechaEgreso = fechaEgreso;
	}

	@Override
	public String toString() {
		return "Inscripto [estudiante=" + estudiante + ", carrera=" + carrera + ", graduado=" + graduado + "]";
	}
	


}
