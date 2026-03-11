package jcolonia.daw2025.tablasmvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Clase que representa una vista general de menú en consola.
 * Permite mostrar un título, una lista de opciones y pedir al usuario
 * que seleccione una opción mediante teclado.
 * 
 * Forma parte de una posible arquitectura MVC, actuando como la capa de vista.
 */
public class VistaGeneral {

    /** Título que se mostrará en el menú */
    private String titulo;

    /** Lista de opciones del menú */
    private List<String> opciones;

    /** Scanner compartido para leer datos desde teclado */
    private static Scanner scIn;

    /**
     * Inicializador estático que crea el Scanner para la entrada estándar.
     * Se ejecuta una sola vez cuando se carga la clase.
     */
    static {
        scIn = new Scanner(System.in);
    }

    /**
     * Constructor de la vista.
     * 
     * @param titulo título que se mostrará en el menú
     * @param opciones lista de opciones disponibles
     */
    public VistaGeneral(String titulo, List<String> opciones) {
        this.titulo = titulo;
        // Copiar la lista para evitar efectos externos
        this.opciones = new ArrayList<>(opciones);
    }

    /**
     * Muestra el título del menú en consola.
     * También dibuja una línea de guiones debajo del título.
     */
    public void mostrarTitulo() {
        System.out.printf("%s%n", titulo);
        for (int i = 0; i < titulo.length(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    /**
     * Muestra todas las opciones del menú numeradas.
     * También añade la opción 0 para salir.
     */
    public void mostrarOpciones() {
        for (int i = 0; i < opciones.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, opciones.get(i));
        }
        System.out.println("0. Salir");
    }

    /**
     * Solicita al usuario que introduzca un número correspondiente
     * a una opción del menú.
     * 
     * Valida que el número esté dentro del rango permitido.
     * Si la entrada no es válida se vuelve a pedir.
     * 
     * @return número de opción elegido por el usuario
     */
    public int pedirNumero() {
        int opcion = -1;

        while (opcion < 0 || opcion > opciones.size()) {
            System.out.printf("Escribe una opción (0-%d): ", opciones.size());

            if (scIn.hasNextInt()) {
                opcion = scIn.nextInt();
            } else {
                System.out.println("No válido");
                scIn.next(); // consumir la entrada no válida
            }
        }

        return opcion;
    }
    
    /**
     * Muestra un mensaje de aviso por pantalla.
     * 
     * @param texto mensaje a mostrar
     */
    public static void mostrarAviso(String texto) {
        System.out.println(texto);
    }
    
    /**
     * Solicita al usuario que introduzca un número.
     * 
     * @param mensaje mensaje que se mostrará al usuario
     * @return número introducido
     */
    public static int pedirNumero(String mensaje) {
        System.out.print(mensaje + ": ");

        while (!scIn.hasNextInt()) {
            System.out.println("No válido");
            scIn.next();
            System.out.print(mensaje + ": ");
        }

        return scIn.nextInt();
    }
    
    /**
     * Muestra por pantalla una tabla de multiplicar.
     * 
     * @param tabla tabla a mostrar
     */
    public static void mostrarTabla(TablaMultiplicar tabla) {
        System.out.println(tabla.toString());
    }

    /**
     * Muestra un texto cualquiera en consola.
     * 
     * @param texto mensaje que se desea mostrar
     */
    public void mostrarTexto(String texto) {
        System.out.println(texto);
    }
}
