package co.edu.ucatolica.controller;

import co.edu.ucatolica.facade.SistemaEnvioFacade;
import co.edu.ucatolica.model.*;
import co.edu.ucatolica.view.*;

import java.util.Scanner;

/**
 * Clase ControladorPrincipal que orquesta el sistema desde consola.
 * Interactúa con la fachada para ejecutar operaciones.
 */
public class ControladorPrincipal {
    private MenuBodega menuBodega;
    private MenuCamion menuCamion;
    private MenuEstadisticas menuEstadisticas;
    private SistemaEnvioFacade sistema;
    private Scanner scanner;

    public ControladorPrincipal() {
        sistema = new SistemaEnvioFacade();
        scanner = new Scanner(System.in);
    }

    public void iniciar() {
        String opcion;
        do {
            mostrarMenuPrincipal();
            opcion = scanner.nextLine();
            switch (opcion) {
                case "1":
                    recibirCaja();
                    break;
                case "2":
                    mostrarCola();
                    break;
                case "3":
                    menuBodega.mostrarMenu();
                    break;
                case "4":
                    menuCamion.mostrarMenu();
                    break;
                case "5":
                    menuEstadisticas.mostrarMenu();
                    break;                
                case "6":
                    System.out.println(sistema.getMaleta());
                    break;
                case "0":
                    System.out.println("Gracias por usar el sistema.");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (!opcion.equals("0"));
    }

    private void mostrarMenuPrincipal() {
        System.out.println("\n--- MENÚ PRINCIPAL ---");
        System.out.println("1. Recibir Caja");
        System.out.println("2. Mostrar Cajas en Cola");
        System.out.println("3. Ver Estadísticas (Maleta)");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private void recibirCaja() {
        System.out.print("Nombre cliente: ");
        String nombre = scanner.nextLine();
        System.out.print("Cédula cliente: ");
        String id = scanner.nextLine();
        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine();
        System.out.print("Dirección (ej. norte calle 1): ");
        String direccion = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();

        Cliente cliente = new Cliente(nombre, id, telefono, direccion, email);

        System.out.print("Ancho caja (cm): ");
        double ancho = Double.parseDouble(scanner.nextLine());
        System.out.print("Largo caja (cm): ");
        double largo = Double.parseDouble(scanner.nextLine());
        System.out.print("Alto caja (cm): ");
        double alto = Double.parseDouble(scanner.nextLine());
        System.out.print("Peso normal (kg): ");
        double peso = Double.parseDouble(scanner.nextLine());

        Caja caja = new Caja(ancho, largo, alto, peso);

        System.out.print("Distancia aproximada al destino (km): ");
        int distancia = Integer.parseInt(scanner.nextLine());

        sistema.recibirCaja(caja, cliente, distancia);
        System.out.println("Caja recibida correctamente.\n");
    }

    private void mostrarCola() {
        System.out.println("\n--- Cajas en la cola ---");
        for (Caja c : sistema.getColaCajas()) {
            System.out.println(c);
        }
    }
}
