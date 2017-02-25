/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

/**
 * Clase autoreferenciada para construir una lista de estudiantes
 * Encapsular un objeto de la lista
 * T => tipo variale que se esfecifica al momento de la creaciòn
 * @author Manuela Villa Paredes
 */
public class Nodo<T> implements Predecesor<T> {
    
    /**Referencia al Estudiante*/
    private T item;
    
    /** Referencia a si mismo => Autoreferenciada*/
    private Nodo<T> siguiente;

    
    ////////////////////////////////////////////////////////////
    // Metodos Get y Set
    ///////////////////////////////////////////////////////////

    public Nodo (T elemento) {
        item = elemento;
    }
    /**
     * @return the item
     */
    public T getItem() {
        return item;
    }

    /**
     * @param item the item to set
     */
    public void setItem(T item) {
        this.item = item;
    }

    /**
     * @return the siguiente
     */
  
    @Override
    public Nodo<T> getSiguiente() {
        return siguiente;
    }

    /**
     * @param siguiente the siguiente to set
     */
    @Override
    public void setSiguiente(Nodo<T> siguiente) {
        this.siguiente = siguiente;
    }

   
}
