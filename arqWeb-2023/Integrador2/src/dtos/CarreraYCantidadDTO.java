package dtos;

import entity.Carrera;

public class CarreraYCantidadDTO {
    private Carrera c;
    private int cantidad;
    public CarreraYCantidadDTO(Carrera c, int cantidad) {
        this.c = c;
        this.cantidad = cantidad;
    }
    public CarreraYCantidadDTO() {
        super();
    }
    @Override
    public String toString() {
        return "\n" + cantidad + " Inscriptos en " + c.getNombre() + " " + c.getInstitucion()+ " Duración: "+c.getDuracion();
    }
    
}
