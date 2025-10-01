package citas;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class HistorialCitas {
    private List<Cita> citas;

    public HistorialCitas() {
        this.citas = new ArrayList<>();
    }

    public void agregarCita(Cita cita) {
        citas.add(cita);
    }

    public List<Cita> filtrarPorFecha(Date fecha) {
        return citas.stream()
                .filter(c -> c.pedirFecha().equals(fecha))
                .collect(Collectors.toList());
    }

    public List<Cita> pedirCitas() {
        return citas;
    }
}
