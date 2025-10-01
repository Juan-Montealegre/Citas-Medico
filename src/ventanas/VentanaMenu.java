package ventanas;

import javax.swing.*;
import java.awt.*;

public class VentanaMenu extends JFrame {

    private JButton botonVerCitas;
    private JButton botonRegistrarInasistencia;
    private JButton botonHistorial;
    private JButton botonAtenderCita; // Nuevo botón
    private JButton botonSalir;

    public VentanaMenu() {
        setTitle("Menú Principal - Citas Médico");
        setSize(400, 350); // Aumentar el tamaño para el nuevo botón
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.decode("#F5F5F5"));

        JPanel panel = new JPanel(new GridLayout(5, 1, 10, 10)); // Cambiar el GridLayout
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        botonVerCitas = new JButton("Ver Citas del Día");
        botonRegistrarInasistencia = new JButton("Registrar Inasistencia");
        botonHistorial = new JButton("Historial de Citas");
        botonAtenderCita = new JButton("Atender Cita"); // Instanciar nuevo botón
        botonSalir = new JButton("Salir");

        aplicarEstiloBoton(botonVerCitas);
        aplicarEstiloBoton(botonRegistrarInasistencia);
        aplicarEstiloBoton(botonHistorial);
        aplicarEstiloBoton(botonAtenderCita);
        aplicarEstiloBoton(botonSalir);

        panel.add(botonVerCitas);
        panel.add(botonRegistrarInasistencia);
        panel.add(botonHistorial);
        panel.add(botonAtenderCita); // Añadir nuevo botón al panel
        panel.add(botonSalir);

        add(panel, BorderLayout.CENTER);
    }

    private void aplicarEstiloBoton(JButton boton) {
        boton.setBackground(Color.decode("#3498DB"));
        boton.setForeground(Color.WHITE);
        boton.setFocusPainted(false);
    }

    public JButton obtenerBotonVerCitas() { return botonVerCitas; }
    public JButton obtenerBotonRegistrarInasistencia() { return botonRegistrarInasistencia; }
    public JButton obtenerBotonHistorial() { return botonHistorial; }
    public JButton obtenerBotonAtenderCita() { return botonAtenderCita; } // Nuevo getter
    public JButton obtenerBotonSalir() { return botonSalir; }

    public void modificarVisible(boolean visible) { setVisible(visible); }
}