package dtos;

import entity.Carrera;

public class CarreraConCantidadDTO {
    private Carrera carrera;
    private int cantidad;

    public CarreraConCantidadDTO() {
        super();
    }

    public CarreraConCantidadDTO(Carrera carrera, int cantidad) {
        this.carrera = carrera;
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "\n" + cantidad + " Inscriptos en: " + carrera.getNombre();
    }

}
