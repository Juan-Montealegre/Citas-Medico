package usuarios;

import java.util.Date;
import java.io.Serializable;

public class Paciente extends Usuario implements Serializable {
    private Date fechaNacimiento;
    private String genero;

    public Paciente(String id, String nombre, String apellidos, String telefono, String email, Date fechaNacimiento, String genero) {
        super(id, nombre, apellidos, telefono, email);
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
    }

    public Date pedirFechaNacimiento() { return fechaNacimiento; }
    public String pedirGenero() { return genero; }

    @Override
    public boolean autenticar() {
        // La autenticación de un paciente puede ser diferente, o no ser necesaria en este sistema.
        return true;
    }
}