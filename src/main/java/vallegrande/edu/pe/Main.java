package vallegrande.edu.pe;

import javax.swing.SwingUtilities;
import vallegrande.edu.pe.view.FrmBienvenida;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            // ===== PRIMERA PANTALLA =====
            FrmBienvenida bienvenida = new FrmBienvenida();

            // Centrar pantalla
            bienvenida.setLocationRelativeTo(null);

            // Mostrar ventana
            bienvenida.setVisible(true);
        });
    }
}