package dtos;

import entity.Carrera;
import entity.Estudiante;
import entity.Inscripto;

public class EstudianteCarreraDTO {
    private Estudiante estudiante;
    private Carrera carrera;
    private Inscripto inscripto;

    public EstudianteCarreraDTO(){
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

    
    
    
}
