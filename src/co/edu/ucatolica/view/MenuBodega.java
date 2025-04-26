package co.edu.ucatolica.view;

import co.edu.ucatolica.facade.SistemaEnvioFacade;
import co.edu.ucatolica.model.Caja;
import co.edu.ucatolica.model.Lista;

import java.util.Scanner;

/**
 * Clase MenuBodega para mostrar y ordenar cajas en bodegas por zona.
 */
public class MenuBodega {

    private final SistemaEnvioFacade sistema;
    private final Scanner scanner;

    public MenuBodega(SistemaEnvioFacade sistema) {
        this.sistema = sistema;
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        String opcion;
        do {
            System.out.println("\n--- MEN� BODEGA ---");
            System.out.println("1. Mostrar cajas en una bodega");
            System.out.println("2. Ordenar cajas por distancia (Selecci�n)");
            System.out.println("0. Volver al men� principal");
            System.out.print("Seleccione una opci�n: ");
            opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    mostrarCajasEnBodega();
                    break;
                case "2":
                    ordenarCajasPorDistancia();
                    break;
                case "0":
                    break;
                default:
                    System.out.println("Opci�n inv�lida.");
            }
        } while (!opcion.equals("0"));
    }

    private void mostrarCajasEnBodega() {
        System.out.print("Ingrese la zona (C/N/S/E/O): ");
        String zona = scanner.nextLine().toUpperCase();
        Lista<Caja> bodega = sistema.getBodega(zona);
        System.out.println("\nCajas en la bodega " + zona + ":");
        for (Caja caja : bodega) {
            System.out.println(caja);
        }
    }

    private void ordenarCajasPorDistancia() {
        System.out.print("Ingrese la zona a ordenar (C/N/S/E/O): ");
        String zona = scanner.nextLine().toUpperCase();
        Lista<Caja> bodega = sistema.getBodega(zona);
        for (int i = 0; i < bodega.tama�o() - 1; i++) {
            for (int j = i + 1; j < bodega.tama�o(); j++) {
                Caja ci = bodega.iterator().next();
                Caja cj = bodega.iterator().next();
                if (ci.getPesoVolumetrico() < cj.getPesoVolumetrico()) {
                    
                }
            }
        }
        System.out.println("Cajas ordenadas por distancia (en implementación).");
    }
}
