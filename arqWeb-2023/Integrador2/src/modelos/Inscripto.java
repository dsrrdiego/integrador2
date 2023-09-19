package modelos;

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
	private String fechaEgreso;

	public Inscripto() {
		super();
	}

	public Inscripto(Estudiante estudiante, Carrera carrera, int antiguedad, boolean graduado) {
		this.estudiante = estudiante;
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

	@Override
	public String toString() {
		return "Inscripto [estudiante=" + estudiante + ", carrera=" + carrera + ", graduado=" + graduado + "]";
	}
	

}
