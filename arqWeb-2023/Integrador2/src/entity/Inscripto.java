package entity;

import javax.persistence.*;

@Entity
@IdClass(claveCompuestaInscripto.class)
public class Inscripto {

	// @GeneratedValue(strategy = GenerationType.AUTO)
	
	// private int id;
	// @EmbeddedId
    // private claveCompuestaInscripto id;

	@Id
	@ManyToOne
    @JoinColumn(name = "nro_libreta")
	private Estudiante estudiante;

	@Id
	@ManyToOne
    @JoinColumn(name = "carrera")
	private Carrera carrera;

	@Column
	private int anioIngreso;
	
	@Column
	private int anioEgreso;


	public Inscripto() {
		super();
	}

	public int getAnioEgreso() {
		return anioEgreso;
	}

	public Inscripto(Estudiante e, Carrera c, int anioIngreso) {
		this.estudiante=e;
		this.carrera=c;
		this.anioIngreso=anioIngreso;
	}

	public int getAnioIngreso() {
		return anioIngreso;
	}
	public void setAnioEgreso(int anio){
		this.anioEgreso=anio;
	}
	public Estudiante getId(){
		return this.estudiante;
	}
}
