package modelos;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class claveCompuestaInscripto implements Serializable{
    private int nro_libreta;
    private int carrera;
}
