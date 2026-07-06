package vallegrande.edu.pe.model;
/*
 * ==========================================================
 * CLASE: Expedicion
 * CAPA: Modelo (Model)
 * DESCRIPCIÓN:
 * Representa una expedición arqueológica dentro del sistema.
 * Almacena toda la información de una expedición.
 * ==========================================================
 */
public class Expedicion {

    // Atributos
    private int codigo;
    private String nombre;
    private String fechaInicio;
    private String fechaFin;
    private String sitioArqueologico;

    // Constructor vacío
    public Expedicion() {
    }

    // Constructor con parámetros
    public Expedicion(int codigo, String nombre, String fechaInicio, String fechaFin, String sitioArqueologico) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.sitioArqueologico = sitioArqueologico;
    }

    // Getters y Setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getSitioArqueologico() {
        return sitioArqueologico;
    }

    public void setSitioArqueologico(String sitioArqueologico) {
        this.sitioArqueologico = sitioArqueologico;
    }

    @Override
    public String toString() {
        return "Expedicion{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", fechaInicio='" + fechaInicio + '\'' +
                ", fechaFin='" + fechaFin + '\'' +
                ", sitioArqueologico='" + sitioArqueologico + '\'' +
                '}';
    }
}