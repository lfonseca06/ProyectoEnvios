package co.edu.ucatolica.model;

/**
 * Clase Cliente que representa los datos de un cliente que realiza envíos.
 */
public class Cliente {
    private String nombre;
    private String id;
    private String telefono;
    private String direccion;
    private String email;

    public Cliente(String nombre, String id, String telefono, String direccion, String email) {
        this.nombre = nombre;
        this.id = id;
        this.telefono = telefono;
        this.direccion = direccion;
        this.email = email;
    }

    public String getZonaDestino() {
        if (direccion == null) return "";
        if (direccion.toLowerCase().startsWith("centro")) return "C";
        if (direccion.toLowerCase().startsWith("norte")) return "N";
        if (direccion.toLowerCase().startsWith("sur")) return "S";
        if (direccion.toLowerCase().startsWith("oriente")) return "E";
        if (direccion.toLowerCase().startsWith("occidente")) return "O";
        return "X"; // Zona desconocida
    }

    public String getNombre() { return nombre; }
    public String getId() { return id; }
    public String getTelefono() { return telefono; }
    public String getDireccion() { return direccion; }
    public String getEmail() { return email; }

    @Override
    public String toString() {
        return nombre + " (" + id + ") - " + direccion;
    }
}
