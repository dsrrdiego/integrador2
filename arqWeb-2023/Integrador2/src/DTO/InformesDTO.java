public class InformesDTO {
	
    /**
     * Generar un reporte de las carreras, que para cada carrera incluya información de los 
     * inscriptos y egresados por año. Se deben ordenar las carreras alfabéticamente, y presentar
     * los años de manera cronológica
     */
    private String carrera;

    private String apellido;

    private String nombre;

    // anio que se inscribio a la carrera
    private int corte;

    private boolean se_graduado;

    private int anio_graduado;

	private int cantInscriptos;

    public String getCarrera() {
		return this.carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

    public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

    public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

    public Int getCantInscriptos() {
		return this.cantInscriptos;
	}

	public void setCantInscriptos(Int cant) {
		this.cantInscriptos = cant;
	}

    public Int getCortes() {
		return this.corte;
	}

	public void setCorte(Int anio) {
		this.corte = anio;
	}

    public Int getSe_graduo() {
		return this.se_graduo;
	}

	public void setSe_graduo(boolean se_graduo) {
		this.se_graduo = se_graduo
	}


}
