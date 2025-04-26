package co.edu.ucatolica.model;

import java.util.Iterator;

/**
 * Clase Cola<T> basada en GenericResizingStack<T> en modo QUEUE.
 * Cumple con: Genérica, Redimensionable, Iterable y No loitering.
 */
public class Cola<T> implements Iterable<T> {

    private GenericResizingStack<T> estructuraInterna;

    /**
     * Constructor que inicializa la cola con modo QUEUE.
     */
    public Cola() {
        estructuraInterna = new GenericResizingStack<>(GenericResizingStack.QUEUE);
    }

    /**
     * Encola un nuevo elemento (lo agrega al final).
     * @param item Elemento a encolar
     */
    public void encolar(T item) {
        estructuraInterna.push(item);
    }

    /**
     * Desencola un elemento (elimina el del frente).
     * @return Elemento eliminado
     */
    public T desencolar() {
        return estructuraInterna.pop();
    }

    /**
     * Consulta el primer elemento sin eliminarlo.
     * @return Primer elemento
     */
    public T verFrente() {
        return estructuraInterna.peek();
    }

    /**
     * Verifica si la cola está vacía.
     * @return true si vacía, false en caso contrario
     */
    public boolean estaVacia() {
        return estructuraInterna.isEmpty();
    }

    /**
     * Devuelve el número de elementos en la cola.
     * @return Tamaño actual de la cola
     */
    public int tama�o() {
        return estructuraInterna.size();
    }

    @Override
    public Iterator<T> iterator() {
        return estructuraInterna.iterator();
    }

    @Override
    public String toString() {
        return estructuraInterna.toString();
    }
}
