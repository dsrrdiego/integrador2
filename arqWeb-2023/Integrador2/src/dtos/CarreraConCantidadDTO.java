package dtos;

import entity.Carrera;
// import entity.Estudiante;
// import entity.Inscripto;

public class CarreraConCantidadDTO {
    // private Estudiante estudiante;
    private Carrera carrera;
    // private Inscripto inscripto;
    private int cantidad;

    public CarreraConCantidadDTO() {
        super();
    }

    // private int fech;

    public CarreraConCantidadDTO(Carrera carrera, int cantidad) {
        // this.estudiante = estudiante;
        this.carrera = carrera;
        // this.inscripto= inscripto;
        // this.fech=fech; //esta fecha se corresponde tanto como ingreso como egreso
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        // return "CarreraConCantidadDTO [carrera=" + carrera + ", cantidad=" + cantidad + "]";
        return "\n"+cantidad + " Inscriptos en: "+ carrera.getNombre() ;
    }

    
}
