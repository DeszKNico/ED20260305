package jcolonia.daw2025.tablasmvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Clase que representa una vista general de menú en consola. Permite mostrar un
 * título, una lista de opciones y pedir al usuario que seleccione una opción
 * mediante teclado.
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
	 * Inicializador estático que crea el Scanner para la entrada estándar. Se
	 * ejecuta una sola vez cuando se carga la clase.
	 */
	static {
		scIn = new Scanner(System.in);
	}

	/**
	 * Constructor de la vista.
	 * 
	 * @param titulo   título que se mostrará en el menú
	 * @param opciones lista de opciones disponibles
	 */
	public VistaGeneral(String titulo, List<String> opciones) {
		this.titulo = titulo;
		// Copiar la lista para evitar efectos externos
		this.opciones = new ArrayList<>(opciones);
	}

	/**
	 * Muestra un título principal similar a un H1.
	 * Se imprime en mayúsculas y con una línea superior e inferior.
	 * 
	 * @param texto título a mostrar
	 */
	public static void mostrarTitulo1(String texto) {
	    String t = texto.toUpperCase();
	    int longitud = t.length() + 4;

	    System.out.println();

	    for (int i = 0; i < longitud; i++) {
	        System.out.print("=");
	    }
	    System.out.println();

	    System.out.printf("  %s%n", t);

	    for (int i = 0; i < longitud; i++) {
	        System.out.print("=");
	    }
	    System.out.println();
	}
	
	/**
	 * Muestra un subtítulo similar a un H2.
	 * 
	 * @param texto subtítulo a mostrar
	 */
	public static void mostrarTitulo2(String texto) {
	    System.out.println();
	    System.out.printf("%s%n", texto);

	    for (int i = 0; i < texto.length(); i++) {
	        System.out.print("-");
	    }
	    System.out.println();
	}
	/**
	 * Muestra todas las opciones del menú numeradas. También añade la opción 0 para
	 * salir.
	 */
	public void mostrarOpciones() {
		for (int i = 0; i < opciones.size(); i++) {
			System.out.printf("%d. %s%n", i + 1, opciones.get(i));
		}
		System.out.println("0. Salir");
	}

	/**
	 * Solicita al usuario que introduzca un número correspondiente a una opción del
	 * menú.
	 * 
	 * Valida que el número esté dentro del rango permitido. Si la entrada no es
	 * válida se vuelve a pedir.
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
	 * Muestra un texto cualquiera en consola.
	 * 
	 * @param texto mensaje que se desea mostrar
	 */
	public void mostrarTexto(String texto) {
		System.out.println(texto);
	}

	/**
	 * Muestra un mensaje de aviso en la consola. Se utiliza para informar al
	 * usuario de eventos como errores, confirmaciones o avisos del sistema.
	 * 
	 * @param texto mensaje que se desea mostrar al usuario
	 */
	public static void mostrarAviso(String texto) {
		System.out.println();
		System.out.println(texto);
	}

	/**
	 * Muestra en pantalla la tabla de multiplicar correspondiente al número
	 * almacenado en el objeto {@link TablaMultiplicar}.
	 * 
	 * La tabla se imprime desde 1 hasta 10 con el formato: número x multiplicador =
	 * resultado.
	 * 
	 * @param tabla objeto que contiene el número de la tabla a mostrar
	 */
	public static void mostrarTabla(TablaMultiplicar tabla) {
		int numero = tabla.getNumero();

		for (int i = 1; i <= 10; i++) {
			System.out.printf("%d x %d = %d%n", numero, i, numero * i);
		}
	}

	/**
	 * Solicita al usuario que introduzca un número por teclado.
	 * 
	 * El método muestra un mensaje indicativo y valida que la entrada sea un número
	 * entero. Si el valor introducido no es válido, vuelve a pedir el número hasta
	 * que lo sea.
	 * 
	 * @param mensaje texto que se mostrará al usuario para pedir el número
	 * @return número entero introducido por el usuario
	 */
	public static int pedirNumero(String mensaje) {
		int numero;

		System.out.print(mensaje + ": ");

		while (!scIn.hasNextInt()) {
			System.out.println("Número no válido.");
			scIn.next();
			System.out.print(mensaje + ": ");
		}

		numero = scIn.nextInt();
		return numero;
	}

	/**
	 * Pausa la ejecución hasta que el usuario pulse ENTER.
	 * 
	 * @param texto mensaje que se muestra antes de la pausa
	 */
	public static void pausa(String texto) {
		System.out.println(texto);
		scIn.nextLine();
		scIn.nextLine();
	}

	/**
	 * Pide al usuario una confirmación (sí o no).
	 * 
	 * @param texto mensaje de confirmación
	 * @return true si responde 's', false si responde 'n'
	 */
	public static boolean pedirConfirmacion(String texto) {
		System.out.print(texto + " (s/n): ");
		String respuesta = scIn.next();

		return respuesta.equalsIgnoreCase("s");
	}

	/**
	 * Muestra una lista de textos numerada.
	 * 
	 * @param lista lista de textos a mostrar
	 */
	public static void mostrarLista(List<String> lista) {
		for (int i = 0; i < lista.size(); i++) {
			System.out.printf("%d. %s%n", i + 1, lista.get(i));
		}
	}

}
