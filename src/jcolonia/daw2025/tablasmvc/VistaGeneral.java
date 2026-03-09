package jcolonia.daw2025.tablasmvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VistaGeneral {

    private String titulo;
    private List<String> opciones;
    private static Scanner scIn;

    static {
        scIn = new Scanner(System.in);
    }

    public VistaGeneral(String titulo, List<String> opciones) {
        this.titulo = titulo;
        // Copiar la lista para evitar efectos externos
        this.opciones = new ArrayList<>(opciones);
    }

    public void mostrarTitulo() {
        System.out.printf("%s%n", titulo);
        for (int i = 0; i < titulo.length(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void mostrarOpciones() {
        for (int i = 0; i < opciones.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, opciones.get(i));
        }
        System.out.println("0. Salir");
    }

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

    public void mostrarTexto(String texto) {
        System.out.println(texto);
    }
}