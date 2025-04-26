package co.edu.ucatolica.model;

import java.util.Iterator;

/**
 * Clase Pila<T> basada en GenericResizingStack<T> en modo STACK.
 * Cumple con: Genérica, Redimensionable, Iterable y No loitering.
 */
public class Pila<T> implements Iterable<T> {

    private GenericResizingStack<T> estructuraInterna;

    /**
     * Constructor que inicializa la pila en modo STACK.
     */
    public Pila() {
        estructuraInterna = new GenericResizingStack<>(GenericResizingStack.STACK);
    }

    /**
     * Apila un nuevo elemento (lo agrega en la cima).
     * @param item Elemento a apilar
     */
    public void apilar(T item) {
        estructuraInterna.push(item);
    }

    /**
     * Desapila el elemento de la cima.
     * @return Elemento eliminado
     */
    public T desapilar() {
        return estructuraInterna.pop();
    }

    /**
     * Consulta el elemento de la cima sin eliminarlo.
     * @return Elemento en la cima
     */
    public T verCima() {
        return estructuraInterna.peek();
    }

    /**
     * Verifica si la pila está vacía.
     * @return true si vacía, false si contiene elementos
     */
    public boolean estaVacia() {
        return estructuraInterna.isEmpty();
    }

    /**
     * Devuelve el número de elementos en la pila.
     * @return Tamaño de la pila
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
