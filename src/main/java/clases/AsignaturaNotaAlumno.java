package clases;

public class AsignaturaNotaAlumno {
	private String asignatura, nota, alumno;
	
	public AsignaturaNotaAlumno(String asignatura, String nota, String alumno) {
		this.asignatura = asignatura;
		this.nota = nota;
		this.alumno = alumno;
	}
	
	public String getAsignatura() {
		return asignatura;
	}
	public String getNota() {
		return nota;
	}
	public String getAlumno() {
		return alumno;
	}
}
