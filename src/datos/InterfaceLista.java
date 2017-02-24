/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

/**
 * Al implementarla da a la clase las capacidades de una lista
 * @author s212e8
 */
public interface InterfaceLista<T> {
    
    public void add(T item);
    
    public boolean isEmpty();
    
    public T get(int indice);
    
    public void set(T objeto, int indice);
    
    public int size();
    
    public void remove(String contraseña);
}
