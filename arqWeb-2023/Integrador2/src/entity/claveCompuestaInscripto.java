package entity;

import java.io.Serializable;


// @Embeddable
public class claveCompuestaInscripto implements Serializable{
    // @ManyToOne
    // @JoinColumn(name = "nro_libreta")
    private Estudiante estudiante;

    // @ManyToOne
    // @JoinColumn(name = "carrera")
	private Carrera carrera;

    public claveCompuestaInscripto(){}

    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return super.hashCode();
    }
    
}
