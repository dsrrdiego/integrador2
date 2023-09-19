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
	private String fechaEgreso;
	
	private int anio_graduado;

	@Override
	public String toString() {
		return "Inscripto [estudiante=" + estudiante + ", carrera=" + carrera + ", graduado=" + graduado + "]";
	}
	


}
