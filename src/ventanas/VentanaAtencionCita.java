package ventanas;

import citas.Cita;
import citas.EstadoCita;
import citasmedico.Main;
import soporte.GestorDatos;

import javax.swing.*;
import java.awt.*;

public class VentanaAtencionCita extends JFrame {

    private GestorDatos gestorDatos;
    private Cita cita;
    private JTextField txtId, txtFecha, txtHora, txtEstado, txtPaciente, txtMedico;
    private JTextArea txtDescripcion, txtObservaciones, txtExamenes, txtFormula;
    private JButton btnCerrar, btnRegresar;

    public VentanaAtencionCita(GestorDatos gestorDatos, Cita cita) {
        this.gestorDatos = gestorDatos;
        this.cita = cita;

        setTitle("Atención de Cita");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.decode("#F5F5F5"));

        JPanel panel = new JPanel(new GridLayout(0, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        panel.setBackground(Color.decode("#F5F5F5"));

        // Campos de información de la cita
        panel.add(new JLabel("ID Cita:"));
        txtId = new JTextField(cita.pedirIdCita());
        txtId.setEditable(false);
        panel.add(txtId);

        panel.add(new JLabel("Fecha:"));
        txtFecha = new JTextField(cita.pedirFecha().toString());
        txtFecha.setEditable(false);
        panel.add(txtFecha);

        panel.add(new JLabel("Hora:"));
        txtHora = new JTextField(cita.pedirHora());
        txtHora.setEditable(false);
        panel.add(txtHora);

        panel.add(new JLabel("Estado:"));
        txtEstado = new JTextField(cita.pedirEstado().toString());
        txtEstado.setEditable(false);
        panel.add(txtEstado);

        panel.add(new JLabel("Paciente:"));
        txtPaciente = new JTextField(gestorDatos.buscarPacientePorId(cita.pedirIdPaciente()).pedirNombre() + " " + gestorDatos.buscarPacientePorId(cita.pedirIdPaciente()).pedirApellidos());
        txtPaciente.setEditable(false);
        panel.add(txtPaciente);

        panel.add(new JLabel("Médico:"));
        txtMedico = new JTextField(gestorDatos.buscarMedicoPorId(cita.pedirIdMedico()).pedirNombre() + " " + gestorDatos.buscarMedicoPorId(cita.pedirIdMedico()).pedirApellidos());
        txtMedico.setEditable(false);
        panel.add(txtMedico);

        // Áreas de texto para diagnóstico y tratamiento
        panel.add(new JLabel("Descripción:"));
        txtDescripcion = new JTextArea(cita.pedirDescripcion() != null ? cita.pedirDescripcion() : "");
        txtDescripcion.setEditable(false);
        panel.add(new JScrollPane(txtDescripcion));

        panel.add(new JLabel("Observaciones:"));
        txtObservaciones = new JTextArea(cita.pedirObservaciones() != null ? cita.pedirObservaciones() : "");
        panel.add(new JScrollPane(txtObservaciones));

        panel.add(new JLabel("Exámenes:"));
        txtExamenes = new JTextArea(cita.pedirExamenes() != null ? cita.pedirExamenes() : "");
        panel.add(new JScrollPane(txtExamenes));

        panel.add(new JLabel("Fórmula Médica:"));
        txtFormula = new JTextArea(cita.pedirFormula() != null ? cita.pedirFormula() : "");
        panel.add(new JScrollPane(txtFormula));

        // Botones
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panelBotones.setBackground(Color.decode("#F5F5F5"));
        btnCerrar = new JButton("Cerrar Cita");
        btnRegresar = new JButton("Regresar al Menú");
        aplicarEstiloBoton(btnCerrar, Color.decode("#27AE60"));
        aplicarEstiloBoton(btnRegresar, Color.decode("#E74C3C"));
        panelBotones.add(btnCerrar);
        panelBotones.add(btnRegresar);

        // Layout principal
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(panelBotones, BorderLayout.SOUTH);

        // Listeners de los botones
        btnCerrar.addActionListener(e -> cerrarCita());
        btnRegresar.addActionListener(e -> {
            this.dispose();
            Main.mostrarVentanaMenu();
        });
    }

    private void cerrarCita() {
        cita.modificarObservaciones(txtObservaciones.getText());
        cita.modificarExamenes(txtExamenes.getText());
        cita.modificarFormula(txtFormula.getText());
        cita.modificarEstado(EstadoCita.atendida);

        gestorDatos.actualizarCita(cita);

        JOptionPane.showMessageDialog(this, "Cita atendida y cerrada con éxito.");
        this.dispose();
        Main.mostrarVentanaMenu();
    }

    private void aplicarEstiloBoton(JButton boton, Color color) {
        boton.setBackground(color);
        boton.setForeground(Color.WHITE);
        boton.setFocusPainted(false);
    }

    public void modificarVisible(boolean visible) { setVisible(visible); }
}