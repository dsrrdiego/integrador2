package dtos;

import entity.Carrera;
import entity.Estudiante;
import entity.Inscripto;

public class EstudianteCarreraDTO implements Comparable{
    private Estudiante estudiante;
    private Carrera carrera;
    private Inscripto inscripto;

    public EstudianteCarreraDTO() {
        super();
    }
    private String fech;
    public EstudianteCarreraDTO(Carrera carrera,Estudiante estudiante, Inscripto inscripto, String fech) {
        this.estudiante = estudiante;
        this.carrera = carrera;
        this.inscripto= inscripto;
        this.fech=fech;
    }

    @Override
    public String toString() {
        String carrera = String.format("%1$-20s", this.carrera.getNombre());

        String accionSinFormato="Ingresó ";
        if (!this.inscripto.getFecha().equals(this.fech)) accionSinFormato="EGRESÓ";

        String fechaEgres=" En curso";
        if (this.inscripto.getFechaEgreso()!=null) fechaEgres=" Egresó en: "+this.inscripto.getFechaEgreso();
        String accion = String.format("%1$-10s", accionSinFormato);

        String nombre=String.format("%1$-30s", (this.estudiante.getNombre()+"~"+this.estudiante.getApellido()));
        return "\nFecha: "+this.fech+" "+carrera + accion+" Nombre: "+nombre+"|"+fechaEgres+ "]";
    }

    @Override
    public int compareTo(Object arg0) {
        EstudianteCarreraDTO e=(EstudianteCarreraDTO) arg0;
        return inscripto.getFecha().compareTo(e.getFechaCarrera());
    }

    public String getNombreCarrera(){
        return this.carrera.getNombre();
    }
    public String getFechaCarrera(){
        return this.inscripto.getFecha();
    }
    public String getFech(){
        return this.fech;
    }

    
    
    
}
