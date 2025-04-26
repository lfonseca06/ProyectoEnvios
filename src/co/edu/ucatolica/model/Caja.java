package co.edu.ucatolica.model;

/**
 * Clase Caja que representa un paquete físico con dimensiones y pesos.
 */
public class Caja {
    private double ancho;
    private double largo;
    private double alto;
    private double pesoNormal;

    public Caja(double ancho, double largo, double alto, double pesoNormal) {
        this.ancho = ancho;
        this.largo = largo;
        this.alto = alto;
        this.pesoNormal = pesoNormal;
    }

    public double getPesoVolumetrico() {
        return (ancho * largo * alto) / 5000.0;
    }

    public double getPesoNormal() {
        return pesoNormal;
    }

    public double getAncho() { return ancho; }
    public double getLargo() { return largo; }
    public double getAlto() { return alto; }

    @Override
    public String toString() {
        return "Caja [" + ancho + "x" + largo + "x" + alto + ", " + pesoNormal + "kg]";
    }
}
