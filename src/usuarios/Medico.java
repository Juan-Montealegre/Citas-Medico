package usuarios;

import java.io.Serializable;
import java.util.Date;
import citas.Cita;
import java.util.List;
import java.util.stream.Collectors;

public class Medico extends Usuario implements Serializable {
    private String cedula;
    private String contrasenaHash;
    private String barrio;
    private Date fechaNacimiento;
    private String especialidad;

    public Medico(String id, String nombre, String apellidos, String telefono, String email,
                  String cedula, String contrasenaHash, String barrio, Date fechaNacimiento, String especialidad) {
        super(id, nombre, apellidos, telefono, email);
        this.cedula = cedula;
        this.contrasenaHash = contrasenaHash;
        this.barrio = barrio;
        this.fechaNacimiento = fechaNacimiento;
        this.especialidad = especialidad;
    }

    public String pedirCedula() { return cedula; }
    public void modificarCedula(String cedula) { this.cedula = cedula; }

    // Método que causa el error
    public String pedirContrasenaHash() { return contrasenaHash; }
    public void modificarContrasenaHash(String contrasenaHash) { this.contrasenaHash = contrasenaHash; }

    public String pedirBarrio() { return barrio; }
    public void modificarBarrio(String barrio) { this.barrio = barrio; }

    public Date pedirFechaNacimiento() { return fechaNacimiento; }
    public void modificarFechaNacimiento(Date fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }

    public String pedirEspecialidad() { return especialidad; }
    public void modificarEspecialidad(String especialidad) { this.especialidad = especialidad; }

    public List<Cita> verCitas(List<Cita> citas, Date fecha) {
        return citas.stream()
                .filter(c -> c.pedirFecha().equals(fecha) && c.pedirIdMedico().equals(this.id))
                .collect(Collectors.toList());
    }

    public void atenderCita(Cita cita) {
        cita.modificarEstado(citas.EstadoCita.atendida);
    }

    @Override
    public boolean autenticar() {
        return true;
    }
}