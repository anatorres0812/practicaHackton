package vallegrande.edu.pe.view;

/*
 * ==========================================================
 * CLASE: FrmBienvenida
 * CAPA: VIEW
 * DESCRIPCIÓN:
 * Pantalla de bienvenida del sistema de gestión de expediciones
 * con logo, botón de ingreso y diseño personalizado.
 * ==========================================================
 */

import vallegrande.edu.pe.controller.ExpedicionController;

import javax.swing.*;
import java.awt.*;

public class FrmBienvenida extends JFrame {

    private JLabel lblTitulo;
    private JLabel lblImagen;
    private JButton btnEntrar;

    public FrmBienvenida() {

        setTitle("Sistema de Gestión de Expediciones - Bienvenida");
        setSize(500, 420);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // ================= FONDO AZUL =================
        getContentPane().setBackground(Color.decode("#205082"));

        // ================= IMAGEN LOGO =================
        ImageIcon imagen = new ImageIcon(getClass().getResource("/logo.jpg"));

        Image img = imagen.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        ImageIcon iconoEscalado = new ImageIcon(img);

        lblImagen = new JLabel(iconoEscalado);
        lblImagen.setBounds(175, 40, 150, 150);
        add(lblImagen);

        // ================= TÍTULO =================
        lblTitulo = new JLabel("BIENVENIDOS AL SISTEMA DE EXPEDICIONES");
        lblTitulo.setBounds(0, 200, 500, 30);
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 14));
        lblTitulo.setForeground(Color.WHITE); // texto blanco
        add(lblTitulo);

        // ================= BOTÓN =================
        btnEntrar = new JButton("ENTRAR");
        btnEntrar.setBounds(190, 260, 120, 35);
        add(btnEntrar);

        // ACCIÓN BOTÓN
        btnEntrar.addActionListener(e -> {
            dispose();

            FrmExpedicion vista = new FrmExpedicion();
            ExpedicionController controlador = new ExpedicionController(vista);

            controlador.iniciar();
            vista.setVisible(true);
        });
    }
}