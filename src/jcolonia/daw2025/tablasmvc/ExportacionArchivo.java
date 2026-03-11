package jcolonia.daw2025.tablasmvc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * Clase encargada de exportar información a un archivo de texto.
 */
public class ExportacionArchivo {

    /** Referencia al archivo donde se guardarán los datos */
    private Path refArchivo;

    /**
     * Constructor que recibe la ruta del archivo.
     * 
     * @param rutaArchivo ruta o nombre del archivo
     */
    public ExportacionArchivo(String rutaArchivo) {
        refArchivo = Path.of(rutaArchivo);
    }

    /**
     * Guarda una lista de líneas en el archivo indicado.
     * 
     * @param contenidos lista de textos que se escribirán en el archivo
     */
    public void guardar(List<String> contenidos) {
        try {
            Files.write(refArchivo, contenidos);
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo.");
        }
    }
}