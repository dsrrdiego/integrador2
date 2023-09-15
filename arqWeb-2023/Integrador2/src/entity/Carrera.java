package modelos;


import java.util.List;

import javax.persistence.*;

// import antlr.collections.List;

// import org.hibernate.mapping.List;



@Entity
public class Carrera {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_carrera;

	@Column
    private String nombre;

	@Column
    private int duracion;

	@Column
    private String institucion;

	@OneToMany
	private List<Carrera> carreras;

	//@OneToMany
	//private Carrera carrera;
	

    public Carrera(){
        super();
    }

    public Carrera(String nombre, int duracion, String institucion){
        this.nombre = nombre;
        this.duracion = duracion;
        this.institucion = institucion;
    }

	public int getId_carrera() {
		return id_carrera;
	}

	public void setId_carrera(int id_carrera) {
		this.id_carrera = id_carrera;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public String getInstitucion() {
		return institucion;
	}

	public void setInstitucion(String institucion) {
		this.institucion = institucion;
	}
    
    
    
    

    

}
