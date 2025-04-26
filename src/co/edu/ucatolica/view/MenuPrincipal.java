package co.edu.ucatolica.view;

import co.edu.ucatolica.controller.ControladorPrincipal;

/**
 * Clase MenuPrincipal que actúa como entrada visual al sistema desde consola.
 */
public class MenuPrincipal {
    public static void main(String[] args) {
        ControladorPrincipal controlador = new ControladorPrincipal();
        controlador.iniciar();
    }
}
