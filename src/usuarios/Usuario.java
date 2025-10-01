package usuarios;

import java.io.Serializable;

public abstract class Usuario implements Serializable {
    protected String id;
    protected String nombre;
    protected String apellidos;
    protected String telefono;
    protected String email;

    public Usuario(String id, String nombre, String apellidos, String telefono, String email) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.email = email;
    }

    public String pedirId() { return id; }
    public String pedirNombre() { return nombre; }
    public String pedirApellidos() { return apellidos; }
    public String pedirNombreYApellidos() { return nombre + " " + apellidos; }
    public String pedirTelefono() { return telefono; }
    public String pedirEmail() { return email; }

    public abstract boolean autenticar();
}