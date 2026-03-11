package jcolonia.daw2025.tablasmvc;

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
    private String[] opciones;

    /**
     * Constructor del menú.
     * 
     * @param titulo título que se mostrará en el menú
     * @param opciones lista de opciones disponibles
     */
    public VistaMenu(String titulo, String[] opciones) {
        this.titulo = titulo;
        this.opciones = opciones;
    }

    /**
     * Muestra el título y las opciones del menú.
     */
    public void mostrarOpciones() {

        System.out.println();
        System.out.println(titulo);

        for(int i = 0; i < titulo.length(); i++){
            System.out.print("-");
        }
        System.out.println();

        for(int i = 0; i < opciones.length; i++){
            System.out.printf("%d. %s%n", i+1, opciones[i]);
        }

        System.out.println("0. Salir");
    }

    /**
     * Solicita al usuario que seleccione una opción del menú.
     * 
     * @return número de la opción seleccionada
     */
    public int pedirOpcion(){
        return VistaGeneral.pedirNumero("Elija una opción");
    }
}