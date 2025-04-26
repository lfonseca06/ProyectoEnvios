package co.edu.ucatolica.view;

import co.edu.ucatolica.facade.SistemaEnvioFacade;
import co.edu.ucatolica.model.Caja;
import co.edu.ucatolica.model.Pila;

import java.util.Scanner;

/**
 * Clase MenuCamion para cargar y despachar camiones por zona.
 */
public class MenuCamion {

    private final SistemaEnvioFacade sistema;
    private final Scanner scanner;

    public MenuCamion(SistemaEnvioFacade sistema) {
        this.sistema = sistema;
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        String opcion;
        do {
            System.out.println("\n--- MEN� CAMI�N ---");
            System.out.println("1. Mostrar cajas en cami�n");
            System.out.println("2. Despachar cami�n");
            System.out.println("0. Volver al men� principal");
            System.out.print("Seleccione una opci�n: ");
            opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    mostrarCajasEnCamion();
                    break;
                case "2":
                    despacharCamion();
                    break;
                case "0":
                    break;
                default:
                    System.out.println("Opci�n inv�lida.");
            }
        } while (!opcion.equals("0"));
    }

    private void mostrarCajasEnCamion() {
        System.out.print("Ingrese la zona del cami�n(C/N/S/E/O): ");
        String zona = scanner.nextLine().toUpperCase();
        Pila<Caja> camion = sistema.getCamion(zona);
        System.out.println("\nCajas en el cami�n " + zona + ":");
        for (Caja caja : camion) {
            System.out.println(caja);
        }
    }

    private void despacharCamion() {
        System.out.print("Ingrese la zona del cami�n a despachar (C/N/S/E/O): ");
        String zona = scanner.nextLine().toUpperCase();
        Pila<Caja> camion = sistema.getCamion(zona);
        if (camion.estaVacia()) {
            System.out.println("El cami�n est� vac�o. No se puede despachar.");
        } else {
            System.out.println("\n--- Despachando cami�n " + zona + " ---");
            while (!camion.estaVacia()) {
                Caja caja = camion.desapilar();
                System.out.println("Entregada: " + caja);
            }
        }
    }
}
