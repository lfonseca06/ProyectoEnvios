package co.edu.ucatolica.model;


/**
 * Clase GuiaEnvio que representa la guía generada al recibir una caja.
 */
public class GuiaEnvio {
    private String idCaja;
    private String direccionDestino;
    private double pesoFacturado;
    private int distanciaAprox;
    private double costoEnvio;

    public GuiaEnvio(String idCaja, String direccionDestino, double pesoFacturado, int distanciaAprox) {
        this.idCaja = idCaja;
        this.direccionDestino = direccionDestino;
        this.pesoFacturado = pesoFacturado;
        this.distanciaAprox = distanciaAprox;
        this.costoEnvio = pesoFacturado * 3; // 3 USD por kg
    }

    public String getIdCaja() { return idCaja; }
    public String getDireccionDestino() { return direccionDestino; }
    public double getPesoFacturado() { return pesoFacturado; }
    public int getDistanciaAprox() { return distanciaAprox; }
    public double getCostoEnvio() { return costoEnvio; }

    @Override
    public String toString() {
        return "Guía " + idCaja + " -> " + direccionDestino + ", Peso: " + pesoFacturado + "kg, Costo: $" + costoEnvio;
    }
}
