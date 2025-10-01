package soporte;

import citas.Cita;
import usuarios.Medico;

public class Reporte {

    public void generarPDF(Cita cita) {
        // Aquí iría la lógica real de generación de PDF con librerías externas (ej. iText)
        // Por ahora solo simulamos
        System.out.println("[Reporte] Generando PDF para la cita: " + cita.pedirIdCita());
    }

    public void generarEstadisticas(Medico medico) {
        // Aquí se puede implementar lógica de estadísticas
        // como número de citas atendidas, inasistencias, etc.
        System.out.println("[Reporte] Generando estadísticas para el médico: " + medico.pedirNombre() + " " + medico.pedirApellidos());
    }
}
