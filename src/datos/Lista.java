/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

/**
 *
 * @author Mateo Arboleda
 */
public class Lista<T> implements Predecesor<T>,InterfaceLista<T> {

    ////////////////////////////////////////////////////////////
    // Atributos
    ///////////////////////////////////////////////////////////
    private Nodo<T> primero;
    private int tamaño;
    ////////////////////////////////////////////////////////////
    // Metodos 
    ///////////////////////////////////////////////////////////

     public boolean equals(Object list) {
        if(list instanceof Lista) {
        Lista<T> lista = (Lista) list;
        Nodo<T> aux1 = primero;
        Nodo<T> aux2 = lista.getSiguiente();
        if(size() == lista.size()) {
            for(int i = 0; i < size(); i++){
                if(aux1.getItem().equals(aux2.getItem())) {
                    aux1= aux1.getSiguiente();
                    aux2= aux2.getSiguiente();
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
    
    
    public String ToString() {

        String str = "";
        Nodo<T> iterador = primero;

        while (iterador != null) {

            str = str + iterador.getItem() + "\n";
            iterador = iterador.getSiguiente();

        }

        return str;
    }
    
    public Nodo<T> getSiguiente() {
        return primero;
    }

    @Override
    public void setSiguiente(Nodo<T> item) {
        primero = item;
    }
    


    public boolean isEmpty() {
        return tamaño == 0;
    }
public void add( T item){
     if(isEmpty()) {
            Nodo<T> elemento = new Nodo<T>();
            elemento.setItem(item);
            primero = elemento;
        } else {
            Nodo<T> elemento1 = new Nodo<T>();
            elemento1.setItem(item);
            Nodo<T> auxiliar;
            auxiliar = primero;

            while (auxiliar.getSiguiente() != null) {
                auxiliar = auxiliar.getSiguiente();
            }

            auxiliar.setSiguiente(elemento1);
                }
        
}
    public T remove(int indice){
        
        Predecesor<T> previo = this;
        Nodo<T> nodo = primero;
        
        for(int i = 0; i < indice; i++) {
            
            previo = nodo;
            nodo = nodo.getSiguiente();
        }
        //En este punto el nodo apunta al item que van a eliminar y previo apunta al anterior
        //Del que van a eliminar
        previo.setSiguiente(nodo.getSiguiente());
        return nodo.getItem();
    }

   
   
    @Override
    public int size() {
        return tamaño;
    }

    @Override
   public T get(int indice){
        
        if(indice < 0 || indice > size()) {
            return null;
        }
        Nodo<T> aux = primero;
        
        for(int i=0; i< indice; i++){
            aux = aux.getSiguiente();
        }
      return aux.getItem();
    }

    @Override
    public void set(T objeto, int indice) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    public void Editar (Contraseña objeaEditar, String nombre , String contraseña, String descripcion , char flag){
        
      
        
      
        Nodo<T> nodo = primero;
        
        while(nodo != null) {
            
            if(nodo.getItem().equals(objeaEditar)) {
              
                if( nodo.getItem() instanceof Contraseña){
               
                   objeaEditar.setContraseña(contraseña);
                   objeaEditar.setDescripcion(descripcion);
                    objeaEditar.setNombre(nombre);
                    objeaEditar.setFlag(flag);
                }
            }
             nodo = nodo.getSiguiente();
        
    }
    
}
}

