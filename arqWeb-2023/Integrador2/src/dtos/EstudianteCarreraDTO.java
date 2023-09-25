package dtos;

import entity.Carrera;
import entity.Estudiante;
import entity.Inscripto;

public class EstudianteCarreraDTO {
    private Estudiante estudiante;
    private Carrera carrera;
    private Inscripto inscripto;

    public EstudianteCarreraDTO() {
        super();
    }
    private int fech;
    public EstudianteCarreraDTO(Carrera carrera,Estudiante estudiante, Inscripto inscripto, int fech) {
        this.estudiante = estudiante;
        this.carrera = carrera;
        this.inscripto= inscripto;
        this.fech=fech; //esta fecha se corresponde tanto como ingreso como egreso
    }

    @Override
    public String toString() {
        String carrera = String.format("%1$-20s", this.carrera.getNombre());

        String accionSinFormato="Ingresó ";
        if (this.inscripto.getfecha()!=this.fech) accionSinFormato="EGRESÓ";

        String fechaEgres=" En curso";
        if (this.inscripto.isEsEgresado()==1) fechaEgres=" Egresó en: "+(this.inscripto.getfecha()+this.inscripto.getAntiguedad());
        String accion = String.format("%1$-10s", accionSinFormato);

        String nombre=String.format("%1$-30s", (this.estudiante.getNombre()+"~"+this.estudiante.getApellido()));
        return "\n"+ carrera+"Fecha: "+this.fech+" "+ accion+" Nombre: "+nombre+"|"+fechaEgres+ "]";
    }

    public String getNombreCarrera(){
        return this.carrera.getNombre();
    }
    public int getFechaCarrera(){
        return this.inscripto.getfecha();
    }
    public int getFech(){
        return this.fech;
    }
 
    
}
