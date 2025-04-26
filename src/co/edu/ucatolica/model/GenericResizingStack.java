package co.edu.ucatolica.model;
//import cosas.Placa;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Estructura genérica, redimensionable e iterable.
 * Puede comportarse como una pila (LIFO), cola (FIFO) o lista dinámica.
 * Todo depende del "modo" en que se use.
 */
public class GenericResizingStack<Item> implements Iterable<Item> {

    private Item[] a;     // Arreglo que almacena los elementos
    private int count;    // Número de elementos almacenados
    private int head;     // Índice inicial del arreglo (solo usado en modo cola)
    private int mode;     // Modo de funcionamiento: STACK, QUEUE o LIST

    /** Constante para modo PILA (LIFO: último en entrar, primero en salir) */
    public static final int STACK = 0;
    /** Constante para modo COLA (FIFO: primero en entrar, primero en salir) */
    public static final int QUEUE = 1;
    /** Constante para modo LISTA (similar a pila, pero con posible iteración adicional) */
    public static final int LIST  = 2;
    
    
    /**
     * Constructor que inicializa la estructura con una capacidad inicial y modo específico.
     *
     * @param initialCapacity capacidad inicial del arreglo interno (debe ser positivo)
     * @param mode modo de operación (STACK, QUEUE o LIST)
     * @throws IllegalArgumentException si initialCapacity ≤ 0
     */
    public GenericResizingStack(int initialCapacity, int mode) {
        a = (Item[]) new Object[initialCapacity];
        this.count = 0;
        this.head = 0;
        this.mode = mode;
    }

    /**
     * Constructor que inicializa la estructura con capacidad por defecto (4) y modo específico.
     *
     * @param mode modo de operación (STACK, QUEUE o LIST)
     */
    public GenericResizingStack(int mode) {
        this(4, mode);
    }
    
    /**
     * Constructor por defecto (modo PILA y capacidad inicial 4).
     */
    public GenericResizingStack() {
        this(STACK);
    }
    

    /**
     * Cambia el modo de operación de la estructura.
     *
     * @param mode nuevo modo (STACK, QUEUE o LIST)
     * @throws IllegalArgumentException si el modo no es válido
     */
    public void setMode(int mode) {
        this.mode = mode;
    }

    /**
     * Añade un elemento a la estructura según el modo actual.
     *
     * @param item elemento a insertar (no puede ser {@code null})
     * @throws NullPointerException si {@code item} es {@code null}
     */
    public void push(Item item) {
        if (count == a.length) resize(2 * a.length); // Redimensionar si está llena

        // Calculamos la posición circular donde insertar el nuevo elemento
        int index = (head + count) % a.length;
        a[index] = item;
        count++;
    }

    /**
     * Elimina y devuelve un elemento según el modo actual.
     *
     * @return el elemento eliminado
     * @throws NoSuchElementException si la estructura está vacía
     */
    public Item pop() {
        if (isEmpty()) throw new NoSuchElementException("Estructura vacía");
        Item item;

        // Comportamiento tipo pila o lista: eliminar del final
        if (mode == STACK || mode == LIST) {
            int index = (head + count - 1) % a.length;
            item = a[index];
            a[index] = null; // no loitering
            count--;
        } else { // Comportamiento tipo cola: eliminar del principio
            item = a[head];
            a[head] = null; // no loitering
            head = (head + 1) % a.length;
            count--;
        }

        // Reducción del arreglo si está muy vacío
        if (count > 0 && count == a.length / 4) resize(a.length / 2);

        return item;
    }
    

    /**
     * Devuelve (sin eliminar) el siguiente elemento a ser retirado según el modo actual.
     *
     * @return el elemento en la cima (pila) o frente (cola)
     * @throws NoSuchElementException si la estructura está vacía
     */
    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Estructura vacía");

        // Según el modo, se mira el primero o el último
        if (mode == STACK || mode == LIST) {
            return a[(head + count - 1) % a.length];
        } else {
            return a[head];
        }
    }

    /**
     * Verifica si la estructura está vacía.
     *
     * @return {@code true} si no hay elementos, {@code false} en caso contrario
     */
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * Devuelve el número de elementos almacenados.
     *
     * @return cantidad de elementos
     */
    public int size() {
        return count;
    }

    /**
     * Redimensiona el arreglo interno para optimizar memoria.
     *
     * @param newCapacity nueva capacidad del arreglo
     * @throws IllegalArgumentException si newCapacity es menor que el tamaño actual
     */
    private void resize(int newCapacity) {
        Item[] temp = (Item[]) new Object[newCapacity];

        // Se copian los elementos en orden circular
        for (int i = 0; i < count; i++) {
            temp[i] = a[(head + i) % a.length];
        }

        a = temp;
        head = 0; // se reinicia el head
    }

    /**
     * Devuelve un iterador que recorre los elementos según el modo actual.
     *
     * @return un iterador personalizado (LIFO para pila, FIFO para cola)
     */
    @Override
    public Iterator<Item> iterator() {
        return new ModeIterator();
    }

    /**
     * Iterador interno que adapta su recorrido según el modo (LIFO o FIFO).
     */
    private class ModeIterator implements Iterator<Item> {
        private int i = 0;

        public boolean hasNext() {
            return i < count;
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();

            // Si es modo pila, recorre desde el final hacia el principio
            if (mode == STACK) {
                return a[(head + count - 1 - i++) % a.length];
            } else { // Cola o lista: recorre en orden normal
                return a[(head + i++) % a.length];
            }
        }
    }

    /**
     * Devuelve una representación en cadena de los elementos según el modo actual.
     *
     * @return cadena con los elementos formateados
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Estructura genérica (" +
            (mode == STACK ? "PILA" : mode == QUEUE ? "COLA" : "LISTA") + "):\n");

        for (Item item : this) {
            sb.append(item).append("\n");
        }

        return sb.toString();
    }
}

/**
 * OK Generica, Iterable,
 * OK Redimensionable, OK No loitering
 */
 //REALIZAR LA COLA, CON TODOS LOS MÉTODOS, GENERICA, CAPACIDAD VARIABLE, NO LOITERING Y QUE SEA ITERABLE
/*public class GenericResizingStack <Item>{
   private Item a[];
   private int count;
   
   public GenericResizingStack(int maxCap){
       a = (Item[])new Object[1];
       count = 0;
   }

    public GenericResizingStack() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
   
   public void push(Item item){
       if(count == a.length)
           resize(a.length*2);
       a[count++] = item;
   }
   
   public Item pop(){
       Item aux = a[--count];
       a[count] = null;
       if(count == a.length / 4 )
           resize(a.length/2);
       return aux;
   }
   
   public Item peak(){
       return a[count-1];
   }
   
   public boolean isEmpty(){
       return count == 0;
   }
   
   public int size(){
       return count;
   }
   
   private void resize(int maxCap){
       Item aux[] = (Item[])new Object [maxCap];
       for(int i=0; i<count ; i++){
           aux[i] = a[i];
       }
       a = aux;
   }
   
   @Override
   public String toString(){
       String salida = "";
       for(int i=0;i<count; i++){
           salida += a[i] + " \n";
       }
       return salida;
   }
   
   
}*/
