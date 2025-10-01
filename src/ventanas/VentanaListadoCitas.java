package ventanas;

import citas.Cita;
import citasmedico.Main;
import soporte.GestorDatos;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class VentanaListadoCitas extends JFrame {

    private JTable tablaCitas;
    private DefaultTableModel modeloTabla;
    private GestorDatos gestorDatos;
    private JButton btnCerrar;

    public VentanaListadoCitas(GestorDatos gestorDatos) {
        this.gestorDatos = gestorDatos;
        setTitle("Listado de Citas del Día");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        String[] columnas = {"ID", "Paciente", "Médico", "Fecha", "Hora"};
        modeloTabla = new DefaultTableModel(columnas, 0);
        tablaCitas = new JTable(modeloTabla);
        JScrollPane scroll = new JScrollPane(tablaCitas);

        btnCerrar = new JButton("Cerrar");
        btnCerrar.addActionListener(e -> {
            this.dispose();
            Main.mostrarVentanaMenu();
        });

        JPanel panelBotones = new JPanel();
        panelBotones.add(btnCerrar);

        add(scroll, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);

        cargarCitasDelDia();
    }

    private void cargarCitasDelDia() {
        modeloTabla.setRowCount(0);
        List<Cita> citasDelDia = gestorDatos.filtrarCitasPorFecha(new Date());

        for (Cita cita : citasDelDia) {
            modeloTabla.addRow(new Object[]{
                    cita.pedirIdCita(),
                    gestorDatos.buscarPacientePorId(cita.pedirIdPaciente()).pedirNombre(), // Línea corregida
                    gestorDatos.buscarMedicoPorId(cita.pedirIdMedico()).pedirNombre(), // Línea corregida
                    cita.pedirFecha(),
                    cita.pedirHora()
            });
        }
    }

    public void modificarVisible(boolean visible) { setVisible(visible); }
}