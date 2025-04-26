package co.edu.ucatolica.view;

import co.edu.ucatolica.facade.SistemaEnvioFacade;
import co.edu.ucatolica.model.Maleta;

import java.util.Scanner;

/**
 * Clase MenuEstadisticas para consultar estadÃ­sticas por zona desde la maleta.
 */
public class MenuEstadisticas {

    private final SistemaEnvioFacade sistema;
    private final Scanner scanner;

    public MenuEstadisticas(SistemaEnvioFacade sistema) {
        this.sistema = sistema;
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        String opcion;
        do {
            System.out.println("\n--- MENÚ ESTADÍSTICAS ---");
            System.out.println("1. Ver estadí­sticas por zona");
            System.out.println("2. Ver resumen completo");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    verPorZona();
                    break;
                case "2":
                    System.out.println(sistema.getMaleta());
                    break;
                case "0":
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (!opcion.equals("0"));
    }

    private void verPorZona() {
        System.out.print("Ingrese la zona (C/N/S/E/O): ");
        String zona = scanner.nextLine().toUpperCase();
        Maleta maleta = sistema.getMaleta();
        System.out.println("Zona " + zona + ":");
        System.out.println("Cajas enviadas: " + maleta.getCantidadCajas(zona));
        System.out.println("Peso total: " + maleta.getPesoPorZona(zona) + " kg");
        System.out.println("Total facturado: $" + maleta.getTotalFacturado(zona));
    }
}
