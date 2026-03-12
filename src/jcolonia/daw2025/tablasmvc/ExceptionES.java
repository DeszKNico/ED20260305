package jcolonia.daw2025.tablasmvc;

/**
 * Clase personalizada de excepción que extiende de {@link Exception}.
 * <p>
 * Se utiliza para representar errores específicos relacionados con
 * operaciones de entrada/salida (E/S) o cualquier otra situación
 * particular definida por la aplicación.
 * </p>
 * <p>
 * Proporciona un constructor que acepta un mensaje descriptivo
 * del error, que puede ser recuperado posteriormente con
 * {@link Throwable#getMessage()}.
 * </p>
 * 
 * @author Nicolas Escobar
 * @version 1.0
 */
public class ExceptionES extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Construye una nueva excepción con un mensaje detallado.
     *
     * @param mensaje Descripción del error que explica la causa de la excepción.
     */
    public ExceptionES(String mensaje) {
        super(mensaje);
    }
}