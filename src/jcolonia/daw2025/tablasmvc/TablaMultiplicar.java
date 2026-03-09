package jcolonia.daw2025.tablasmvc;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa una tabla de multiplicar para un número específico.
 * Genera y almacena las líneas de la tabla para mostrar o exportar.
 */
public class TablaMultiplicar {

    /** Número base de la tabla de multiplicar. */
    private int número;

    /** Lista que almacena cada línea de la tabla como texto. */
    private List<String> listaTextos;

    /**
     * Constructor que inicializa la tabla para un número dado.
     * @param número Número para el cual se genera la tabla de multiplicar.
     */
    public TablaMultiplicar(int número) {
        this.número = número;
        listaTextos = new ArrayList<>();
    }

    /**
     * Genera la tabla de multiplicar del número base.
     * Cada línea tiene formato "número x i = resultado" para i = 1 a 10.
     * Limpia la lista anterior antes de generar la nueva tabla.
     */
    public void generarTabla() {
        listaTextos.clear();
        for (int i = 1; i <= 10; i++) {
            int resultado = número * i;
            // Construimos la línea con formato
            String linea = String.format("%d x %d = %d", número, i, resultado);
            listaTextos.add(linea);
        }
    }

    /**
     * Devuelve la lista de líneas de la tabla para su exportación.
     * @return Lista de cadenas con la tabla generada, lista para exportar.
     */
    public List<String> toListaExportación() {
        return listaTextos;
    }

    /**
     * Devuelve la lista de líneas de la tabla para mostrar en pantalla.
     * Actualmente es la misma que para exportación.
     * @return Lista de cadenas con la tabla generada, lista para mostrar.
     */
    public List<String> toListaPantalla() {
        return listaTextos;
    }

    /**
     * Representación en texto completo de la tabla de multiplicar,
     * con cada línea separada por salto de línea.
     * @return Texto con la tabla de multiplicar completa.
     */
    @Override
    public String toString() {
        StringBuilder texto = new StringBuilder();
        for (String linea : listaTextos) {
            texto.append(linea).append("\n");
        }
        return texto.toString();
    }
}