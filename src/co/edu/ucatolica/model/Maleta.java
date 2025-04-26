package co.edu.ucatolica.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Clase Maleta para registrar estadísticas de los envíos por zona.
 * Almacena: peso total por zona, cantidad de cajas, total facturado.
 */
public class Maleta {
    private Map<String, Double> pesoPorZona;
    private Map<String, Integer> cajasPorZona;
    private Map<String, Double> totalFacturadoPorZona;

    public Maleta() {
        pesoPorZona = new HashMap<>();
        cajasPorZona = new HashMap<>();
        totalFacturadoPorZona = new HashMap<>();
    }

    /**
     * Registra una nueva guía en la maleta y actualiza las estadísticas por zona.
     * @param zona Zona de destino (C, N, S, E, O)
     * @param peso Peso facturado del envío
     * @param costo Costo del envío
     */
    public void registrarEnvio(String zona, double peso, double costo) {
        pesoPorZona.put(zona, pesoPorZona.getOrDefault(zona, 0.0) + peso);
        cajasPorZona.put(zona, cajasPorZona.getOrDefault(zona, 0) + 1);
        totalFacturadoPorZona.put(zona, totalFacturadoPorZona.getOrDefault(zona, 0.0) + costo);
    }

    public double getPesoPorZona(String zona) {
        return pesoPorZona.getOrDefault(zona, 0.0);
    }

    public int getCantidadCajas(String zona) {
        return cajasPorZona.getOrDefault(zona, 0);
    }

    public double getTotalFacturado(String zona) {
        return totalFacturadoPorZona.getOrDefault(zona, 0.0);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("--- Estadísticas por Zona ---\n");
        for (String zona : pesoPorZona.keySet()) {
            sb.append("Zona ").append(zona).append(": ")
              .append(cajasPorZona.get(zona)).append(" cajas, ")
              .append(pesoPorZona.get(zona)).append(" kg, $")
              .append(totalFacturadoPorZona.get(zona)).append("\n");
        }
        return sb.toString();
    }
}
