package clases;

public class Persona extends Usuario {
    private String apellidos;
    private String nombre;

    public Persona(String dni, String password, String apellidos, String nombre) {
        super(dni, password);
        setApellidos(apellidos);
        setNombre(nombre);
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}