package co.edu.ucatolica.facade;
import co.edu.ucatolica.model.*;

import java.util.Random;

/**
 * Fachada del sistema para centralizar las operaciones de envíos.
 */
public class SistemaEnvioFacade {

    private Cola<Caja> colaCajas;
    private Lista<Caja> bodegaCentro;
    private Lista<Caja> bodegaNorte;
    private Lista<Caja> bodegaSur;
    private Lista<Caja> bodegaOriente;
    private Lista<Caja> bodegaOccidente;
    private Pila<Caja> camionCentro;
    private Pila<Caja> camionNorte;
    private Pila<Caja> camionSur;
    private Pila<Caja> camionOriente;
    private Pila<Caja> camionOccidente;
    private Maleta maleta;
    private int contadorGuia;

    public SistemaEnvioFacade() {
        colaCajas = new Cola<>();
        bodegaCentro = new Lista<>();
        bodegaNorte = new Lista<>();
        bodegaSur = new Lista<>();
        bodegaOriente = new Lista<>();
        bodegaOccidente = new Lista<>();
        camionCentro = new Pila<>();
        camionNorte = new Pila<>();
        camionSur = new Pila<>();
        camionOriente = new Pila<>();
        camionOccidente = new Pila<>();
        maleta = new Maleta();
        contadorGuia = 1;
    }

    public void recibirCaja(Caja caja, Cliente cliente, int distancia) {
        String zona = cliente.getZonaDestino();
        String idGuia = zona + contadorGuia++;
        double pesoVol = caja.getPesoVolumetrico();
        double pesoFact = Math.max(pesoVol, caja.getPesoNormal());
        GuiaEnvio guia = new GuiaEnvio(idGuia, cliente.getDireccion(), pesoFact, distancia);
        maleta.registrarEnvio(zona, pesoFact, guia.getCostoEnvio());
        colaCajas.encolar(caja);
    }

    public Cola<Caja> getColaCajas() {
        return colaCajas;
    }

    public Lista<Caja> getBodega(String zona) {
        switch (zona) {
            case "C": return bodegaCentro;
            case "N": return bodegaNorte;
            case "S": return bodegaSur;
            case "E": return bodegaOriente;
            case "O": return bodegaOccidente;
            default: return new Lista<>();
        }
    }

    public Pila<Caja> getCamion(String zona) {
        switch (zona) {
            case "C": return camionCentro;
            case "N": return camionNorte;
            case "S": return camionSur;
            case "E": return camionOriente;
            case "O": return camionOccidente;
            default: return new Pila<>();
        }
    }

    public Maleta getMaleta() {
        return maleta;
    }
}
