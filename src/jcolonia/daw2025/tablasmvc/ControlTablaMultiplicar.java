package jcolonia.daw2025.tablasmvc;

/**
 * Núcleo de aplicación de consola de texto con menús. Aplicación
 * de texto usando tablas de multiplicar infantiles clásicas. 
 */
public class ControlTablaMultiplicar {

    /** Formato tipo «printf» para el nombre del archivo de exportación. */
    public static final String FORMATO_RUTA_ARCHIVO_EXPORTACION =
        "tabla del %02d.txt";

    /** Opciones del menú principal */
    private static final String[] OPCIONES_MENU_PRINCIPAL = {
        "Mostrar tabla",
        "Cambiar tabla",
        "Exportar tabla",
        "Salir"
    };

    /** Tabla de multiplicar activa. */
    private TablaMultiplicar tabla;

    public ControlTablaMultiplicar(){
        init();
    }

    /**
     * Pide al usuario un número y prepara la primera tabla activa.
     */
    public void init(){
        cambiarTabla();
    }

    /**
     * Gestión del menú principal. Desde este menú
     * se ejecutan las opciones disponibles a elección del usuario.
     * A la salida del menú se finaliza el programa.
     */
    public void buclePrincipal(){
        VistaMenu menu;
        int opcion;

        menu = new VistaMenu("Tablas de multiplicar", OPCIONES_MENU_PRINCIPAL);

        do {
            menu.mostrarOpciones();
            opcion = menu.pedirOpcion();

            switch(opcion){
                case 1: // Mostrar tabla
                    mostrarTabla();
                    break;
                case 2: // Cambiar tabla
                    cambiarTabla();
                    break;
                case 3: // Exportar tabla
                    exportarTabla();
                    break;
                case 0: // Salir
                    break;
                default: // Opciones no implementadas
                    opcionNoDisponible();
                    break;
            }

        } while (opcion != 0);

        VistaGeneral.mostrarAviso("FIN");
    }

    /**
     * Muestra por pantalla -envía a la salida estándar-
     * los productos correspondientes a la tabla activa.
     */
    private void mostrarTabla(){
        VistaGeneral.mostrarTabla(tabla);
    }

    /**
     * Cambia la tabla activa por otra elegida por el usuario.
     */
    private void cambiarTabla(){
        int n;

        n = VistaGeneral.pedirNumero("Introduzca el número para la tabla");

        tabla = new TablaMultiplicar(n);
        tabla.generarTabla();
    }

    /**
     * Envía a un archivo
     * los productos correspondientes a la tabla activa.
     */
    private void exportarTabla(){
        boolean ok = tabla.exportar(String.format(FORMATO_RUTA_ARCHIVO_EXPORTACION, tabla.getNumero()));

        if(ok){
            VistaGeneral.mostrarAviso("Exportación completada correctamente.");
        } else {
            VistaGeneral.mostrarAviso("Error al exportar la tabla.");
        }
    }

    /**
     * Muestra un mensaje de aviso indicando que 
     * la opción elegida no está disponible.
     */
    private void opcionNoDisponible(){
        VistaGeneral.mostrarAviso("Opción no disponible");
    }

}