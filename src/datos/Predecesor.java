/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

/**
 * Interface para simplificar los metodos de la lista
 * @author s212e8
 */
public interface Predecesor<T> {
    
    public void setSiguiente(Nodo<T> item);
    
    public Nodo<T> getSiguiente();
}
