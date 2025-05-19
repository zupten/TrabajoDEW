package clases;

public class Asignatura {
	String acronimo, cuatrimestre, nombre;
	float creditos;
	int curso;
	
	public Asignatura(String acronimo, String cuatrimestre, String nombre, float creditos, int curso) {
		this.acronimo = acronimo;
		this.cuatrimestre = cuatrimestre;
		this.nombre = nombre;
		this.creditos = creditos;
		this.curso = curso;
	}
	
    public String getAcronimo() {
        return acronimo;
    }
}
