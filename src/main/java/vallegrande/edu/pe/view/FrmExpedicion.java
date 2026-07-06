package vallegrande.edu.pe.view;

/*
 * ==========================================================
 * CLASE: FrmExpedicion
 * CAPA: VIEW
 * DESCRIPCIÓN:
 * Interfaz gráfica del sistema de gestión de expediciones.
 * ==========================================================
 */

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class FrmExpedicion extends JFrame {

    // ===== PANEL =====
    public JPanel panel;

    // ===== LABELS =====
    public JLabel lblCodigo, lblNombre, lblDiaIni, lblMesIni, lblAnioIni;
    public JLabel lblDiaFin, lblMesFin, lblAnioFin, lblSitio;

    // ===== CAMPOS =====
    public JTextField txtCodigo;
    public JTextField txtNombre;
    public JTextField txtSitio;

    // ===== COMBOBOX FECHA INICIO =====
    public JComboBox<String> cbDiaIni;
    public JComboBox<String> cbMesIni;
    public JComboBox<String> cbAnioIni;

    // ===== COMBOBOX FECHA FIN =====
    public JComboBox<String> cbDiaFin;
    public JComboBox<String> cbMesFin;
    public JComboBox<String> cbAnioFin;

    // ===== BOTONES =====
    public JButton btnGuardar, btnModificar, btnEliminar, btnLimpiar;

    // ===== TABLA =====
    public JTable tabla;
    public DefaultTableModel modelo;
    public JScrollPane scroll;

    public FrmExpedicion() {

        setTitle("Sistema de Expediciones");
        setSize(950, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        panel = new JPanel();
        panel.setLayout(null);
        add(panel);

        // ================= LABELS =================
        lblCodigo = new JLabel("Código:");
        lblCodigo.setBounds(20, 20, 100, 25);
        panel.add(lblCodigo);

        lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(20, 60, 100, 25);
        panel.add(lblNombre);

        lblDiaIni = new JLabel("Fecha Inicio:");
        lblDiaIni.setBounds(20, 100, 100, 25);
        panel.add(lblDiaIni);

        lblDiaFin = new JLabel("Fecha Fin:");
        lblDiaFin.setBounds(20, 160, 100, 25);
        panel.add(lblDiaFin);

        lblSitio = new JLabel("Sitio:");
        lblSitio.setBounds(20, 220, 100, 25);
        panel.add(lblSitio);

        // ================= CAMPOS =================
        txtCodigo = new JTextField();
        txtCodigo.setBounds(120, 20, 120, 25);
        panel.add(txtCodigo);

        txtNombre = new JTextField();
        txtNombre.setBounds(120, 60, 200, 25);
        panel.add(txtNombre);

        txtSitio = new JTextField();
        txtSitio.setBounds(120, 220, 200, 25);
        panel.add(txtSitio);

        // ================= FECHA INICIO =================
        cbDiaIni = new JComboBox<>();
        cbMesIni = new JComboBox<>();
        cbAnioIni = new JComboBox<>();

        for (int i = 1; i <= 31; i++) cbDiaIni.addItem(String.valueOf(i));

        String[] meses = {
                "Enero","Febrero","Marzo","Abril","Mayo","Junio",
                "Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"
        };

        for (String m : meses) cbMesIni.addItem(m);
        for (int i = 2000; i <= 2030; i++) cbAnioIni.addItem(String.valueOf(i));

        cbDiaIni.setBounds(120, 100, 80, 25);
        cbMesIni.setBounds(210, 100, 120, 25);
        cbAnioIni.setBounds(340, 100, 100, 25);

        panel.add(cbDiaIni);
        panel.add(cbMesIni);
        panel.add(cbAnioIni);

        // ================= FECHA FIN =================
        cbDiaFin = new JComboBox<>();
        cbMesFin = new JComboBox<>();
        cbAnioFin = new JComboBox<>();

        for (int i = 1; i <= 31; i++) cbDiaFin.addItem(String.valueOf(i));
        for (String m : meses) cbMesFin.addItem(m);
        for (int i = 2000; i <= 2030; i++) cbAnioFin.addItem(String.valueOf(i));

        cbDiaFin.setBounds(120, 160, 80, 25);
        cbMesFin.setBounds(210, 160, 120, 25);
        cbAnioFin.setBounds(340, 160, 100, 25);

        panel.add(cbDiaFin);
        panel.add(cbMesFin);
        panel.add(cbAnioFin);

        // ================= BOTONES =================
        btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(20, 270, 100, 30);
        panel.add(btnGuardar);

        btnModificar = new JButton("Modificar");
        btnModificar.setBounds(130, 270, 110, 30);
        panel.add(btnModificar);

        btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(250, 270, 110, 30);
        panel.add(btnEliminar);

        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setBounds(370, 270, 100, 30);
        panel.add(btnLimpiar);

        // ================= TABLA =================
        modelo = new DefaultTableModel();
        modelo.addColumn("Código");
        modelo.addColumn("Nombre");
        modelo.addColumn("F. Inicio");
        modelo.addColumn("F. Fin");
        modelo.addColumn("Sitio");

        tabla = new JTable(modelo);
        scroll = new JScrollPane(tabla);

        scroll.setBounds(20, 320, 880, 200);
        panel.add(scroll);
    }
}