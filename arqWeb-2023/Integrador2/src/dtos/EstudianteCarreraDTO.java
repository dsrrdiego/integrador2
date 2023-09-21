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

    public EstudianteCarreraDTO(Carrera carrera,Estudiante estudiante, Inscripto inscripto) {
        this.estudiante = estudiante;
        this.carrera = carrera;
        this.inscripto= inscripto;
    }

    @Override
    public String toString() {
        return "\n"+carrera.getNombre() + " Año ingrerso: "+inscripto.getFecha()+" "+estudiante.getNombre()+" "+estudiante.getApellido()+" Egreso en: "+ inscripto.getFechaEgreso()    + "]";
    }

    @Override
    public int compareTo(Object arg0) {
        EstudianteCarreraDTO e=(EstudianteCarreraDTO) arg0;
        // return carrera.getNombre().compareTo(e.getNombreCarrera());
        return inscripto.getFecha().compareTo(e.getFechaCarrera());
    }

    public String getNombreCarrera(){
        return this.carrera.getNombre();
    }
    public String getFechaCarrera(){
        return this.inscripto.getFecha();
    }

    
    
    
}
