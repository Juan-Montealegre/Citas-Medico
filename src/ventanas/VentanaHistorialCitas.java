package ventanas;

import citas.Cita;
import soporte.GestorDatos;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class VentanaHistorialCitas extends JFrame {

    private JTable tablaCitas;
    private DefaultTableModel modeloTabla;
    private GestorDatos gestorDatos;
    private JButton btnCerrar; // Nuevo botón

    public VentanaHistorialCitas(GestorDatos gestorDatos) {
        this.gestorDatos = gestorDatos;

        setTitle("Historial de Citas");
        setSize(700, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.decode("#F5F5F5"));

        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        panel.setBackground(Color.decode("#F5F5F5"));

        String[] columnas = {"ID", "Fecha", "Hora", "Estado", "Descripción", "Observaciones"};
        modeloTabla = new DefaultTableModel(columnas, 0);

        tablaCitas = new JTable(modeloTabla);
        JScrollPane scroll = new JScrollPane(tablaCitas);

        JButton btnActualizar = new JButton("Actualizar");
        btnActualizar.addActionListener(e -> cargarCitas());
        btnCerrar = new JButton("Cerrar"); // Inicialización del nuevo botón

        JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelBoton.setBackground(Color.decode("#F5F5F5"));
        panelBoton.add(btnActualizar);
        panelBoton.add(btnCerrar); // Agregando el nuevo botón

        panel.add(scroll, BorderLayout.CENTER);
        panel.add(panelBoton, BorderLayout.SOUTH);

        add(panel);

        cargarCitas();
    }

    private void cargarCitas() {
        modeloTabla.setRowCount(0);
        List<Cita> citas = gestorDatos.getCitas();
        for (Cita cita : citas) {
            modeloTabla.addRow(new Object[]{
                    cita.pedirIdCita(),
                    cita.pedirFecha(),
                    cita.pedirHora(),
                    cita.pedirEstado(),
                    cita.pedirDescripcion(),
                    cita.pedirObservaciones()
            });
        }
    }

    public JButton obtenerBotonCerrar() {
        return btnCerrar;
    }

    public void modificarVisible(boolean visible) { setVisible(visible); }
}