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
            System.out.println("\n--- MENÚ CAMIÓN ---");
            System.out.println("1. Mostrar cajas en camión");
            System.out.println("2. Despachar camión");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
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
                    System.out.println("Opción inválida.");
            }
        } while (!opcion.equals("0"));
    }

    private void mostrarCajasEnCamion() {
        System.out.print("Ingrese la zona del camión(C/N/S/E/O): ");
        String zona = scanner.nextLine().toUpperCase();
        Pila<Caja> camion = sistema.getCamion(zona);
        System.out.println("\nCajas en el camión " + zona + ":");
        for (Caja caja : camion) {
            System.out.println(caja);
        }
    }

    private void despacharCamion() {
        System.out.print("Ingrese la zona del camión a despachar (C/N/S/E/O): ");
        String zona = scanner.nextLine().toUpperCase();
        Pila<Caja> camion = sistema.getCamion(zona);
        if (camion.estaVacia()) {
            System.out.println("El camión está vací­o. No se puede despachar.");
        } else {
            System.out.println("\n--- Despachando camión " + zona + " ---");
            while (!camion.estaVacia()) {
                Caja caja = camion.desapilar();
                System.out.println("Entregada: " + caja);
            }
        }
    }
}
