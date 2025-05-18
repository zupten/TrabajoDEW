package clases;

public class Usuario {
    private String dni;
    private String password;

    public Usuario(String dni, String password) {
        setDni(dni);
        setPassword(password);
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}