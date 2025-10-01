package ventanas;

import javax.swing.*;
import java.awt.*;

public class VentanaRegistroMedico extends JFrame {

    private JTextField campoNombre;
    private JTextField campoApellidos;
    private JTextField campoCedula;
    private JPasswordField campoContrasena;
    private JPasswordField campoConfirmarContrasena;
    private JTextField campoTelefono;
    private JTextField campoEmail;
    private JTextField campoBarrio;
    private JTextField campoFechaNacimiento;
    private JTextField campoEspecialidad;
    private JButton botonRegistrar;
    private JButton botonCancelar;

    public VentanaRegistroMedico(soporte.GestorDatos gestorDatos) {
        setTitle("Registro de Médico");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.decode("#F5F5F5"));

        JPanel panelPrincipal = new JPanel(new GridBagLayout());
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panelPrincipal.setBackground(Color.decode("#F5F5F5"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel titulo = new JLabel("Formulario de Registro de Médico");
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(0, 0, 20, 0);
        panelPrincipal.add(titulo, gbc);

        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridwidth = 1;

        gbc.gridx = 0;
        gbc.gridy = 1;
        panelPrincipal.add(new JLabel("Cédula:"), gbc);
        gbc.gridx = 1;
        campoCedula = new JTextField(15);
        panelPrincipal.add(campoCedula, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panelPrincipal.add(new JLabel("Nombre:"), gbc);
        gbc.gridx = 1;
        campoNombre = new JTextField(15);
        panelPrincipal.add(campoNombre, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panelPrincipal.add(new JLabel("Apellidos:"), gbc);
        gbc.gridx = 1;
        campoApellidos = new JTextField(15);
        panelPrincipal.add(campoApellidos, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panelPrincipal.add(new JLabel("Teléfono:"), gbc);
        gbc.gridx = 1;
        campoTelefono = new JTextField(15);
        panelPrincipal.add(campoTelefono, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        panelPrincipal.add(new JLabel("Email:"), gbc);
        gbc.gridx = 1;
        campoEmail = new JTextField(15);
        panelPrincipal.add(campoEmail, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        panelPrincipal.add(new JLabel("Contraseña:"), gbc);
        gbc.gridx = 1;
        campoContrasena = new JPasswordField(15);
        panelPrincipal.add(campoContrasena, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        panelPrincipal.add(new JLabel("Confirmar Contraseña:"), gbc);
        gbc.gridx = 1;
        campoConfirmarContrasena = new JPasswordField(15);
        panelPrincipal.add(campoConfirmarContrasena, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        panelPrincipal.add(new JLabel("Barrio:"), gbc);
        gbc.gridx = 1;
        campoBarrio = new JTextField(15);
        panelPrincipal.add(campoBarrio, gbc);

        gbc.gridx = 0;
        gbc.gridy = 9;
        panelPrincipal.add(new JLabel("Fecha de Nacimiento:"), gbc);
        gbc.gridx = 1;
        campoFechaNacimiento = new JTextField(15);
        panelPrincipal.add(campoFechaNacimiento, gbc);

        gbc.gridx = 0;
        gbc.gridy = 10;
        panelPrincipal.add(new JLabel("Especialidad:"), gbc);
        gbc.gridx = 1;
        campoEspecialidad = new JTextField(15);
        panelPrincipal.add(campoEspecialidad, gbc);

        botonRegistrar = new JButton("Registrar");
        botonCancelar = new JButton("Cancelar");

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panelBotones.setBackground(Color.decode("#F5F5F5"));
        panelBotones.add(botonRegistrar);
        panelBotones.add(botonCancelar);

        gbc.gridx = 0;
        gbc.gridy = 11;
        gbc.gridwidth = 2;
        panelPrincipal.add(panelBotones, gbc);

        add(panelPrincipal, BorderLayout.CENTER);
    }

    public JButton obtenerBotonRegistrar() {
        return botonRegistrar;
    }

    public JButton obtenerBotonCancelar() {
        return botonCancelar;
    }

    public JTextField obtenerCampoCedula() { return campoCedula; }
    public JPasswordField obtenerCampoContrasena() { return campoContrasena; }
    public JPasswordField obtenerCampoConfirmarContrasena() { return campoConfirmarContrasena; }
    public JTextField obtenerCampoNombre() { return campoNombre; }
    public JTextField obtenerCampoApellidos() { return campoApellidos; }
    public JTextField obtenerCampoTelefono() { return campoTelefono; }
    public JTextField obtenerCampoEmail() { return campoEmail; }
    public JTextField obtenerCampoBarrio() { return campoBarrio; }
    public JTextField obtenerCampoFechaNacimiento() { return campoFechaNacimiento; }
    public JTextField obtenerCampoEspecialidad() { return campoEspecialidad; }

    public void modificarVisible(boolean visible) {
        setVisible(visible);
    }
}