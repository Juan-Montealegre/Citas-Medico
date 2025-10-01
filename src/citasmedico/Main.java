package citasmedico;

import soporte.GestorDatos;
import ventanas.*;
import javax.swing.*;
import citas.Cita;

public class Main {

    private static GestorDatos gestorDatos;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            gestorDatos = new GestorDatos();
            mostrarVentanaIniciar();
        });
    }

    public static void mostrarVentanaMenu() {
        VentanaMenu ventanaMenu = new VentanaMenu();
        ventanaMenu.modificarVisible(true);

        ventanaMenu.obtenerBotonVerCitas().addActionListener(e -> {
            ventanaMenu.dispose();
            mostrarVentanaListadoCitas();
        });

        ventanaMenu.obtenerBotonRegistrarInasistencia().addActionListener(e -> {
            ventanaMenu.dispose();
            mostrarVentanaRegistrarInasistencia();
        });

        ventanaMenu.obtenerBotonHistorial().addActionListener(e -> {
            ventanaMenu.dispose();
            mostrarVentanaHistorialCitas();
        });

        ventanaMenu.obtenerBotonAtenderCita().addActionListener(e -> {
            ventanaMenu.dispose();
            mostrarVentanaAtencionCita();
        });

        ventanaMenu.obtenerBotonSalir().addActionListener(e -> {
            System.exit(0);
        });
    }

    public static void mostrarVentanaRegistroMedico() {
        VentanaRegistroMedico ventanaRegistro = new VentanaRegistroMedico(gestorDatos);
        ventanaRegistro.modificarVisible(true);

        ventanaRegistro.obtenerBotonCancelar().addActionListener(e -> {
            ventanaRegistro.dispose();
            mostrarVentanaIniciar();
        });

        ventanaRegistro.obtenerBotonRegistrar().addActionListener(e -> {
            String cedula = ventanaRegistro.obtenerCampoCedula().getText();
            String contrasena = new String(ventanaRegistro.obtenerCampoContrasena().getPassword());
            String confirmarContrasena = new String(ventanaRegistro.obtenerCampoConfirmarContrasena().getPassword());
            String nombre = ventanaRegistro.obtenerCampoNombre().getText();
            String apellidos = ventanaRegistro.obtenerCampoApellidos().getText();
            String telefono = ventanaRegistro.obtenerCampoTelefono().getText();
            String email = ventanaRegistro.obtenerCampoEmail().getText();
            String barrio = ventanaRegistro.obtenerCampoBarrio().getText();
            String fechaNacimientoStr = ventanaRegistro.obtenerCampoFechaNacimiento().getText();
            String especialidad = ventanaRegistro.obtenerCampoEspecialidad().getText();

            // Validación de campos vacíos
            if (cedula.isEmpty() || contrasena.isEmpty() || confirmarContrasena.isEmpty() || nombre.isEmpty() || apellidos.isEmpty() || telefono.isEmpty() || email.isEmpty() || barrio.isEmpty() || fechaNacimientoStr.isEmpty() || especialidad.isEmpty()) {
                JOptionPane.showMessageDialog(ventanaRegistro, "Todos los campos son obligatorios. Por favor, llénelos todos.");
                return;
            }

            if (!contrasena.equals(confirmarContrasena)) {
                JOptionPane.showMessageDialog(ventanaRegistro, "Las contraseñas no coinciden. Inténtelo de nuevo.");
                return;
            }

            try {
                java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
                java.util.Date fechaNacimiento = sdf.parse(fechaNacimientoStr);

                usuarios.Medico nuevoMedico = new usuarios.Medico(
                        cedula,
                        nombre,
                        apellidos,
                        telefono,
                        email,
                        cedula,
                        contrasena,
                        barrio,
                        fechaNacimiento,
                        especialidad
                );

                gestorDatos.agregarMedico(nuevoMedico);

                JOptionPane.showMessageDialog(ventanaRegistro, "¡Registro exitoso!");
                ventanaRegistro.dispose();
                mostrarVentanaIniciar();

            } catch (java.text.ParseException ex) {
                JOptionPane.showMessageDialog(ventanaRegistro, "Formato de fecha inválido. Use dd/MM/yyyy.");
            }
        });
    }

    public static void mostrarVentanaListadoCitas() {
        VentanaListadoCitas ventanaListado = new VentanaListadoCitas(gestorDatos);
        ventanaListado.modificarVisible(true);
    }

    public static void mostrarVentanaRegistrarInasistencia() {
        VentanaRegistrarInasistencia ventanaInasistencia = new VentanaRegistrarInasistencia(gestorDatos);
        ventanaInasistencia.modificarVisible(true);
    }

    public static void mostrarVentanaHistorialCitas() {
        VentanaHistorialCitas ventanaHistorial = new VentanaHistorialCitas(gestorDatos);
        ventanaHistorial.modificarVisible(true);

        ventanaHistorial.obtenerBotonCerrar().addActionListener(e -> {
            ventanaHistorial.dispose();
            mostrarVentanaMenu();
        });
    }

    public static void mostrarVentanaAtencionCita() {
        String idCita = JOptionPane.showInputDialog(null, "Ingrese el ID de la cita a atender:");
        if (idCita != null && !idCita.trim().isEmpty()) {
            Cita cita = gestorDatos.buscarCitaPorId(idCita);
            if (cita != null) {
                VentanaAtencionCita ventanaAtencion = new VentanaAtencionCita(gestorDatos, cita);
                ventanaAtencion.modificarVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Cita con ID " + idCita + " no encontrada.");
                mostrarVentanaMenu();
            }
        } else {
            mostrarVentanaMenu();
        }
    }

    public static void mostrarVentanaIniciar() {
        VentanaIniciar ventanaIniciar = new VentanaIniciar();
        ventanaIniciar.modificarVisible(true);

        ventanaIniciar.obtenerBotonIniciar().addActionListener(e -> {
            String cedula = ventanaIniciar.obtenerCampoCedula().getText();
            String contrasena = new String(ventanaIniciar.obtenerCampoContrasena().getPassword());

            // Validación de campos vacíos
            if (cedula.isEmpty() || contrasena.isEmpty()) {
                JOptionPane.showMessageDialog(ventanaIniciar, "Por favor, ingrese sus credenciales.");
                return;
            }

            if (gestorDatos.autenticarMedico(cedula, contrasena)) {
                ventanaIniciar.dispose();
                mostrarVentanaMenu();
            } else {
                JOptionPane.showMessageDialog(ventanaIniciar, "Credenciales inválidas. Intente de nuevo.");
            }
        });

        ventanaIniciar.obtenerBotonRegistrar().addActionListener(e -> {
            ventanaIniciar.dispose();
            mostrarVentanaRegistroMedico();
        });
    }
}