/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import archivo.Lectura_Escritura;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mateo Arboleda
 */
public class Lista<T> implements Predecesor<T>, InterfaceLista<T> {

    ////////////////////////////////////////////////////////////
    // Atributos
    ///////////////////////////////////////////////////////////
    private Nodo<T> primero;
    private int tamaño;
    ////////////////////////////////////////////////////////////
    // Metodos 
    ///////////////////////////////////////////////////////////

    @Override
    public boolean equals(Object list) {
        if (list instanceof Lista) {
            Lista<T> lista = (Lista) list;
            Nodo<T> aux1 = primero;
            Nodo<T> aux2 = lista.getSiguiente();
            if (size() == lista.size()) {
                for (int i = 0; i < size(); i++) {
                    if (aux1.getItem().equals(aux2.getItem())) {
                        aux1 = aux1.getSiguiente();
                        aux2 = aux2.getSiguiente();
                    } else {
                        return false;
                    }
                }
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public String toString() {

        String str = "";
        Nodo<T> iterador = primero;

        while (iterador != null) {

            str = str + iterador.getItem() + "\n";
            iterador = iterador.getSiguiente();

        }

        return str;
    }

    @Override
    public Nodo<T> getSiguiente() {
        return primero;
    }

    @Override
    public void setSiguiente(Nodo<T> item) {
        primero = item;
    }

    @Override
    public boolean isEmpty() {
        return tamaño == 0;
    }

    /**
     * Añade un objeto a la lista y al archivo
     * Este método se usa cuando se está añadiendo una nueva contraseña
     * @param item Objeto que se añade
     */
    public void addCompleto(T item) {

        Predecesor<T> ultimo = this;
        while (ultimo.getSiguiente() != null) {
            ultimo = ultimo.getSiguiente();
        }
        ultimo.setSiguiente(new Nodo<>(item));
        
        try {
            Lectura_Escritura.Escribir(((Contraseña) item).getNombre(),
                    ((Contraseña) item).getDescripcion(),
                    ((Contraseña) item).getContraseña(),
                    ((Contraseña) item).getFlag());
        } catch (IOException ex) {
            Logger.getLogger(Lista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Añada un objeto a la lsita
     * Este metodo es para llenar la lista con las conraseñas del archivo
     * @param item Objeto que se añade
     */
    @Override
    public void add(T item){
        Predecesor<T> ultimo = this;
        while (ultimo.getSiguiente() != null) {
            ultimo = ultimo.getSiguiente();
        }
        ultimo.setSiguiente(new Nodo<>(item));
    }

    @Override
    public void remove(String contraseña) {

        Predecesor<T> previo = this;
        Nodo<T> nodo = primero;

        for (int i = 0; i < tamaño; i++) {
            if(get(i) instanceof Contraseña){
                if(get(i).equals(contraseña)){
                    previo.setSiguiente(nodo.getSiguiente());
                }
                
                previo = nodo;
                nodo = nodo.getSiguiente();
            }
        }
    }

    @Override
    public int size() {
        return tamaño;
    }

    @Override
    public T get(int indice) {

        if (indice < 0 || indice > size()) {
            return null;
        }
        Nodo<T> aux = primero;

        for (int i = 0; i < indice; i++) {
            aux = aux.getSiguiente();
        }
        return aux.getItem();
    }

    @Override
    public void set(T objeto, int indice) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void Editar(T objeaEditar, String contraseña) {
        Nodo<T> nodo = primero;

        while (nodo != null) {
            if (nodo.getItem().equals(objeaEditar)) {
                Contraseña contraAcambiar = (Contraseña) nodo.getItem();
                contraAcambiar.setContraseña(contraseña);
            }            
            nodo = nodo.getSiguiente();
        }
    }
}
