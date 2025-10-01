package ventanas;

import javax.swing.*;
import java.awt.*;

public class VentanaIniciar extends JFrame {

    private JTextField campoCedula;
    private JPasswordField campoContrasena;
    private JButton botonIngresar;
    private JButton botonRegistrar;

    public VentanaIniciar() {
        setTitle("Iniciar Sesión - Citas Médico");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.decode("#F5F5F5"));

        JPanel panelPrincipal = new JPanel(new GridBagLayout());
        panelPrincipal.setBackground(Color.decode("#F5F5F5"));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Título
        JLabel titulo = new JLabel("ACCESO DE MÉDICOS");
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panelPrincipal.add(titulo, gbc);

        // Campos de entrada
        gbc.gridwidth = 1;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.EAST;
        panelPrincipal.add(new JLabel("Cédula:"), gbc);
        campoCedula = new JTextField(15);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panelPrincipal.add(campoCedula, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.EAST;
        panelPrincipal.add(new JLabel("Contraseña:"), gbc);
        campoContrasena = new JPasswordField(15);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panelPrincipal.add(campoContrasena, gbc);

        // Botones
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        botonIngresar = new JButton("Ingresar");
        aplicarEstiloBoton(botonIngresar);
        panelPrincipal.add(botonIngresar, gbc);

        gbc.gridx = 1;
        botonRegistrar = new JButton("Registrar");
        aplicarEstiloBoton(botonRegistrar);
        panelPrincipal.add(botonRegistrar, gbc);

        add(panelPrincipal);
    }

    private void aplicarEstiloBoton(JButton boton) {
        boton.setBackground(Color.decode("#3498DB"));
        boton.setForeground(Color.WHITE);
        boton.setFocusPainted(false);
    }

    public JButton obtenerBotonIniciar() { return botonIngresar; }
    public JButton obtenerBotonRegistrar() { return botonRegistrar; }
    public JTextField obtenerCampoCedula() { return campoCedula; }
    public JPasswordField obtenerCampoContrasena() { return campoContrasena; }
    public void modificarVisible(boolean visible) { setVisible(visible); }
}