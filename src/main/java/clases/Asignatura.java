package clases;

public class Asignatura {
	private String acronimo, cuatrimestre, nombre;
	private float creditos;
	private int curso;
	
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

    public String getCuatrimestre() {
        return cuatrimestre;
    }

    public String getNombre() {
        return nombre;
    }

    public float getCreditos() {
        return creditos;
    }

    public int getCurso() {
        return curso;
    }
}
