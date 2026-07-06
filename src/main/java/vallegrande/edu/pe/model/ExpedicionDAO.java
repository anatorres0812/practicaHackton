package vallegrande.edu.pe.model;

/*
 * ==========================================================
 * CLASE: ExpedicionDAO
 * CAPA: Modelo (DAO)
 * DESCRIPCIÓN:
 * Contiene los métodos para realizar las operaciones CRUD
 * sobre la tabla Expedicion en la base de datos.
 * ==========================================================
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExpedicionDAO {

    private Conexion conexion = new Conexion();
    private Connection con;

    // Guardar una expedición
    public boolean guardar(Expedicion expedicion) {

        con = conexion.conectar();

        String sql = "INSERT INTO expedicion(codigo,nombre,fecha_inicio,fecha_fin,sitio) VALUES (?,?,?,?,?)";

        try {

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, String.valueOf(expedicion.getCodigo()));
            ps.setString(2, expedicion.getNombre());
            ps.setString(3, expedicion.getFechaInicio());
            ps.setString(4, expedicion.getFechaFin());
            ps.setString(5, expedicion.getSitioArqueologico());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // Listar todas las expediciones
    public List<Expedicion> listar() {

        con = conexion.conectar();

        List<Expedicion> lista = new ArrayList<>();

        // Aquí irá el código SQL SELECT

        return lista;
    }

    // Modificar una expedición
    public boolean actualizar(Expedicion expedicion) {

        con = conexion.conectar();

        // Aquí irá el código SQL UPDATE

        return false;
    }

    // Eliminar una expedición
    public boolean eliminar(int codigo) {

        con = conexion.conectar();

        // Aquí irá el código SQL DELETE

        return false;
    }

}