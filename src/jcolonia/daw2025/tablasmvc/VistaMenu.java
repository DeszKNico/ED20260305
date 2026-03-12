package jcolonia.daw2025.tablasmvc;

import java.util.Arrays;
import java.util.List;

/**
 * Clase encargada de mostrar un menú en consola.
 * 
 * Permite presentar una lista de opciones numeradas
 * y solicitar al usuario que seleccione una opción.
 */

public class VistaMenu {

    /** Título del menú */
    private String titulo;

    /** Lista de opciones disponibles */
    private List<String> opciones; // ahora usamos List

    /**
     * Constructor del menú.
     * 
     * @param titulo título que se mostrará en el menú
     * @param opciones lista de opciones disponibles como array
     */
    public VistaMenu(String titulo, String[] opciones) {
        this.titulo = titulo;
        // Convertimos el array a List usando Arrays.asList
        this.opciones = Arrays.asList(opciones);
    }

    /**
     * Muestra el título y las opciones del menú.
     */
    public void mostrarOpciones() {

        System.out.println();
        System.out.println(titulo);

        for (int i = 0; i < titulo.length(); i++) {
            System.out.print("-");
        }
        System.out.println();

        // Ahora recorremos la lista
        for (int i = 0; i < opciones.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, opciones.get(i));
        }

        System.out.println("0. Salir");    
    }

    /**
     * Solicita al usuario que seleccione una opción del menú.
     * 
     * @return número de la opción seleccionada
     */
    public int pedirOpcion() {
        return VistaGeneral.pedirNumero("Elija una opción");
    }
}