package ventanas;

import citasmedico.Main;
import citas.Cita;
import citas.EstadoCita;
import soporte.GestorDatos;
import javax.swing.*;
import java.awt.*;

public class VentanaRegistrarInasistencia extends JFrame {

    private GestorDatos gestorDatos;
    private JTextField campoIdCita;
    private JTextArea campoObservaciones;
    private JButton botonRegistrar;
    private JButton botonCancelar;

    public VentanaRegistrarInasistencia(GestorDatos gestorDatos) {
        this.gestorDatos = gestorDatos;
        setTitle("Registrar Inasistencia - Citas Médico");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.decode("#F5F5F5"));

        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.setBackground(Color.decode("#F5F5F5"));

        JPanel panelSuperior = new JPanel(new GridLayout(2, 2, 10, 10));
        panelSuperior.setBackground(Color.decode("#F5F5F5"));
        JLabel lblIdCita = new JLabel("ID de la Cita:");
        campoIdCita = new JTextField();

        JLabel lblObservaciones = new JLabel("Observaciones:");
        campoObservaciones = new JTextArea(5, 20);
        JScrollPane scrollObservaciones = new JScrollPane(campoObservaciones);

        panelSuperior.add(lblIdCita);
        panelSuperior.add(campoIdCita);
        panelSuperior.add(lblObservaciones);
        panelSuperior.add(scrollObservaciones);

        JPanel panelBotones = new JPanel(new FlowLayout());
        panelBotones.setBackground(Color.decode("#F5F5F5"));
        botonRegistrar = new JButton("Registrar");
        botonCancelar = new JButton("Cancelar");
        aplicarEstiloBoton(botonRegistrar, Color.decode("#27AE60"));
        aplicarEstiloBoton(botonCancelar, Color.decode("#E74C3C"));

        panelBotones.add(botonRegistrar);
        panelBotones.add(botonCancelar);

        panel.add(panelSuperior, BorderLayout.CENTER);
        panel.add(panelBotones, BorderLayout.SOUTH);

        add(panel);

        botonRegistrar.addActionListener(e -> {
            String idCita = campoIdCita.getText();
            String observaciones = campoObservaciones.getText();

            Cita cita = gestorDatos.buscarCitaPorId(idCita);
            if (cita != null) {
                cita.modificarEstado(EstadoCita.inasistencia);
                cita.modificarObservaciones(observaciones);
                gestorDatos.actualizarCita(cita);
                JOptionPane.showMessageDialog(this, "Inasistencia registrada correctamente.");
                this.dispose();
                Main.mostrarVentanaMenu();
            } else {
                JOptionPane.showMessageDialog(this, "ID de cita no encontrado.");
            }
        });

        botonCancelar.addActionListener(e -> {
            this.dispose();
            Main.mostrarVentanaMenu();
        });
    }

    private void aplicarEstiloBoton(JButton boton, Color color) {
        boton.setBackground(color);
        boton.setForeground(Color.WHITE);
        boton.setFocusPainted(false);
    }

    public void modificarVisible(boolean visible) { setVisible(visible); }
}