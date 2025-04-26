package co.edu.ucatolica.model;

import java.util.Iterator;

/**
 * Clase Lista<T> que actúa como una lista genérica independiente,
 * basada internamente en GenericResizingStack<T> usando el modo LIST.
 * Cumple con los requisitos de ser: Genérica, Iterable, Redimensionable y No loitering.
 */
public class Lista<T> implements Iterable<T> {

    private GenericResizingStack<T> estructuraInterna;

    /**
     * Constructor por defecto que inicializa la lista con modo LIST.
     */
    public Lista() {
        estructuraInterna = new GenericResizingStack<>(GenericResizingStack.LIST);
    }

    /**
     * Inserta un nuevo elemento al final de la lista.
     * @param item Elemento a insertar
     */
    public void agregar(T item) {
        estructuraInterna.push(item);
    }

    /**
     * Elimina el último elemento de la lista.
     * @return Elemento eliminado
     * @throws java.util.NoSuchElementException si la lista está vacía
     */
    public T eliminarUltimo() {
        return estructuraInterna.pop();
    }

    /**
     * Consulta el último elemento de la lista sin eliminarlo.
     * @return Último elemento
     * @throws java.util.NoSuchElementException si la lista está vacía
     */
    public T verUltimo() {
        return estructuraInterna.peek();
    }

    /**
     * Devuelve el número de elementos en la lista.
     * @return Tamaño de la lista
     */
    public int tama�o() {
        return estructuraInterna.size();
    }

    /**
     * Verifica si la lista está vacía.
     * @return true si está vacía, false si contiene elementos
     */
    public boolean estaVacia() {
        return estructuraInterna.isEmpty();
    }

    /**
     * Permite recorrer la lista con un iterador (soporte para for-each).
     * @return Iterador de la lista
     */
    @Override
    public Iterator<T> iterator() {
        return estructuraInterna.iterator();
    }

    /**
     * Representación en cadena del contenido de la lista.
     * @return Cadena con los elementos de la lista
     */
    @Override
    public String toString() {
        return estructuraInterna.toString();
    }
}
