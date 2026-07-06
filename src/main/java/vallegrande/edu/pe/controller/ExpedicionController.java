package vallegrande.edu.pe.controller;

import vallegrande.edu.pe.model.Expedicion;
import vallegrande.edu.pe.model.ExpedicionDAO;
import vallegrande.edu.pe.view.FrmExpedicion;

import javax.swing.*;

public class ExpedicionController {

    private FrmExpedicion vista;
    private ExpedicionDAO dao;

    public ExpedicionController(FrmExpedicion vista) {
        this.vista = vista;
        this.dao = new ExpedicionDAO();

        eventos();
    }

    // ================= INICIAR =================
    public void iniciar() {
        vista.setTitle("Sistema de Gestión de Expediciones");
        vista.setLocationRelativeTo(null);
    }

    // ================= EVENTOS =================
    private void eventos() {

        vista.btnGuardar.addActionListener(e -> guardar());
        vista.btnLimpiar.addActionListener(e -> limpiar());
    }

    // ================= VALIDAR CÓDIGO DUPLICADO =================
    private boolean codigoExiste(String codigo) {

        for (int i = 0; i < vista.modelo.getRowCount(); i++) {
            String codigoTabla = vista.modelo.getValueAt(i, 0).toString();

            if (codigoTabla.equals(codigo)) {
                return true;
            }
        }
        return false;
    }

    // ================= FORMATEAR FECHA =================
    private String formatearFecha(JComboBox<String> dia,
                                  JComboBox<String> mes,
                                  JComboBox<String> anio) {

        int d = Integer.parseInt(dia.getSelectedItem().toString());
        int m = mes.getSelectedIndex() + 1;
        String a = anio.getSelectedItem().toString();

        return a + "-" +
                String.format("%02d", m) + "-" +
                String.format("%02d", d);
    }

    // ================= GUARDAR =================
    private void guardar() {

        String codigo = vista.txtCodigo.getText().trim();
        String nombre = vista.txtNombre.getText().trim();
        String sitio = vista.txtSitio.getText().trim();

        // ===== VALIDACIONES =====
        if (codigo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese el código");
            return;
        }

        if (!codigo.matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "El código solo debe contener números");
            return;
        }

        if (codigoExiste(codigo)) {
            JOptionPane.showMessageDialog(null, "El código ya existe");
            return;
        }

        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese el nombre");
            return;
        }

        if (!nombre.matches("[a-zA-Z ]+")) {
            JOptionPane.showMessageDialog(null, "El nombre solo debe contener letras");
            return;
        }

        if (sitio.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese el sitio");
            return;
        }

        if (!sitio.matches("[a-zA-Z ]+")) {
            JOptionPane.showMessageDialog(null, "El sitio solo debe contener letras");
            return;
        }

        // ===== FECHAS CORRECTAS (MYSQL) =====
        String fechaInicio = formatearFecha(
                vista.cbDiaIni,
                vista.cbMesIni,
                vista.cbAnioIni
        );

        String fechaFin = formatearFecha(
                vista.cbDiaFin,
                vista.cbMesFin,
                vista.cbAnioFin
        );

        // ===== OBJETO =====
        Expedicion obj = new Expedicion(
                Integer.parseInt(codigo),
                nombre,
                fechaInicio,
                fechaFin,
                sitio
        );

        // ===== GUARDAR EN BD =====
        boolean ok = dao.guardar(obj);
        if (ok) {
            vista.modelo.addRow(new Object[]{
                    codigo,
                    nombre,
                    fechaInicio,
                    fechaFin,
                    sitio
            });

            JOptionPane.showMessageDialog(null,
                    "Expedición registrada correctamente");

            limpiar();

        } else {
            JOptionPane.showMessageDialog(null,
                    "Error al guardar en la base de datos");
        }
    }
    // ================= LIMPIAR =================
    private void limpiar() {
        vista.txtCodigo.setText("");
        vista.txtNombre.setText("");
        vista.txtSitio.setText("");
        vista.cbDiaIni.setSelectedIndex(0);
        vista.cbMesIni.setSelectedIndex(0);
        vista.cbAnioIni.setSelectedIndex(0);
        vista.cbDiaFin.setSelectedIndex(0);
        vista.cbMesFin.setSelectedIndex(0);
        vista.cbAnioFin.setSelectedIndex(0);
    }
}