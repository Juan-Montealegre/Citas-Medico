package soporte;

import citas.Cita;
import citas.EstadoCita;
import usuarios.Medico;
import usuarios.Paciente;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class GestorDatos implements Serializable {

    private static final long serialVersionUID = 1L; // Añadido para consistencia en la serialización

    private List<Medico> medicos;
    private List<Paciente> pacientes;
    private List<Cita> citas;
    private transient final Persistente sistemaPersistencia;
    private static final String NOMBRE_ARCHIVO = "datos.bin";

    public GestorDatos() {
        this.sistemaPersistencia = new SistemaPersistencia();
        cargarDatos();
    }

    private void cargarDatos() {
        try {
            GestorDatos datosCargados = (GestorDatos) sistemaPersistencia.leer(NOMBRE_ARCHIVO);
            this.medicos = datosCargados.medicos;
            this.pacientes = datosCargados.pacientes;
            this.citas = datosCargados.citas;
            System.out.println("Datos cargados correctamente desde " + NOMBRE_ARCHIVO);
        } catch (RuntimeException e) {
            System.out.println("Error al cargar datos. Creando datos de prueba...");
            crearDatosDePrueba();
            guardarDatos();
        }
    }

    public void guardarDatos() {
        sistemaPersistencia.guardar(this, NOMBRE_ARCHIVO);
    }

    private void crearDatosDePrueba() {
        medicos = new ArrayList<>();
        pacientes = new ArrayList<>();
        citas = new ArrayList<>();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            Medico medicoPrueba = new Medico(
                    "M1",
                    "David",
                    "Gómez",
                    "3001234567",
                    "david.gomez@mail.com",
                    "123", // Cédula para iniciar sesión
                    "123", // Contraseña
                    "Centro",
                    sdf.parse("10/05/1980"),
                    "Cardiología"
            );
            medicos.add(medicoPrueba);

            Paciente paciente1 = new Paciente("P1", "Ana", "López", "3011111111", "ana.lopez@mail.com", sdf.parse("20/01/1995"), "Barrio 1");
            Paciente paciente2 = new Paciente("P2", "Carlos", "Pérez", "3022222222", "carlos.perez@mail.com", sdf.parse("15/03/1988"), "Barrio 2");
            pacientes.add(paciente1);
            pacientes.add(paciente2);

            Date fechaHoy = new Date();
            Date fechaAyer = sdf.parse("28/09/2025");

            Cita citaHoyPendiente = new Cita("C1", fechaHoy, "10:00", paciente1.pedirId(), medicoPrueba.pedirId());
            citas.add(citaHoyPendiente);

            Cita citaHoyPendiente2 = new Cita("C2", fechaHoy, "11:00", paciente2.pedirId(), medicoPrueba.pedirId());
            citas.add(citaHoyPendiente2);

            Cita citaPasadaAtendida = new Cita("C3", fechaAyer, "09:00", paciente1.pedirId(), medicoPrueba.pedirId());
            citaPasadaAtendida.modificarEstado(EstadoCita.atendida);
            citaPasadaAtendida.modificarObservaciones("Cita de seguimiento exitosa.");
            citas.add(citaPasadaAtendida);

            Cita citaPasadaInasistencia = new Cita("C4", fechaAyer, "15:00", paciente2.pedirId(), medicoPrueba.pedirId());
            citaPasadaInasistencia.modificarEstado(EstadoCita.inasistencia);
            citas.add(citaPasadaInasistencia);

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public boolean autenticarMedico(String cedula, String contrasena) {
        return medicos.stream()
                .anyMatch(m -> m.pedirCedula().equals(cedula) && m.pedirContrasenaHash().equals(contrasena));
    }

    public void agregarMedico(Medico medico) {
        medicos.add(medico);
        guardarDatos();
    }

    public void agregarPaciente(Paciente paciente) {
        pacientes.add(paciente);
        guardarDatos();
    }

    public void agregarCita(Cita cita) {
        citas.add(cita);
        guardarDatos();
    }

    public void actualizarCita(Cita citaActualizada) {
        for (int i = 0; i < citas.size(); i++) {
            if (citas.get(i).pedirIdCita().equals(citaActualizada.pedirIdCita())) {
                citas.set(i, citaActualizada);
                break;
            }
        }
        guardarDatos();
    }

    public Medico buscarMedicoPorId(String id) {
        return medicos.stream().filter(m -> m.pedirId().equals(id)).findFirst().orElse(null);
    }

    public Paciente buscarPacientePorId(String id) {
        return pacientes.stream().filter(p -> p.pedirId().equals(id)).findFirst().orElse(null);
    }

    public Cita buscarCitaPorId(String id) {
        return citas.stream().filter(c -> c.pedirIdCita().equals(id)).findFirst().orElse(null);
    }

    public List<Cita> getCitas() {
        return citas;
    }

    public List<Cita> filtrarCitasPorFecha(Date fecha) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return citas.stream()
                .filter(c -> sdf.format(c.pedirFecha()).equals(sdf.format(fecha)))
                .collect(Collectors.toList());
    }
}