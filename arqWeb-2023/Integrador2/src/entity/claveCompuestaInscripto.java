package entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

// @Embeddable
public class claveCompuestaInscripto implements Serializable{
    // @ManyToOne
    // @JoinColumn(name = "nro_libreta")
    private Estudiante estudiante;

    // @ManyToOne
    // @JoinColumn(name = "carrera")
	private Carrera carrera;

    // public claveCompuestaInscripto(Estudiante estudiante, Carrera carrera) {
        // this.estudiante = estudiante;
        // this.carrera = carrera;
    // }
    public claveCompuestaInscripto(){}
    
}
