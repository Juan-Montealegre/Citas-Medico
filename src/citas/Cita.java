package citas;

import java.io.Serializable;
import java.util.Date;

public class Cita implements Serializable {
    private String idCita;
    private Date fecha;
    private String hora;
    private String idPaciente;
    private String idMedico;
    private EstadoCita estado;
    private String descripcion;
    private String formula;
    private String examenes;
    private String observaciones;

    public Cita(String idCita, Date fecha, String hora, String idPaciente, String idMedico) {
        this.idCita = idCita;
        this.fecha = fecha;
        this.hora = hora;
        this.idPaciente = idPaciente;
        this.idMedico = idMedico;
        this.estado = EstadoCita.pendiente;
    }

    public String pedirIdCita() { return idCita; }
    public void modificarIdCita(String idCita) { this.idCita = idCita; }

    public Date pedirFecha() { return fecha; }
    public void modificarFecha(Date fecha) { this.fecha = fecha; }

    public String pedirHora() { return hora; }
    public void modificarHora(String hora) { this.hora = hora; }

    // Métodos para el ID del paciente y médico
    public String pedirIdPaciente() { return idPaciente; }
    public void modificarIdPaciente(String idPaciente) { this.idPaciente = idPaciente; }

    public String pedirIdMedico() { return idMedico; }
    public void modificarIdMedico(String idMedico) { this.idMedico = idMedico; }

    public EstadoCita pedirEstado() { return estado; }
    public void modificarEstado(EstadoCita estado) { this.estado = estado; }

    public String pedirDescripcion() { return descripcion; }
    public void modificarDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String pedirFormula() { return formula; }
    public void modificarFormula(String formula) { this.formula = formula; }

    public String pedirExamenes() { return examenes; }
    public void modificarExamenes(String examenes) { this.examenes = examenes; }

    public String pedirObservaciones() { return observaciones; }
    public void modificarObservaciones(String observaciones) { this.observaciones = observaciones; }
}