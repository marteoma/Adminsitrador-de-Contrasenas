package datos;

/**
 *
 * @author Carlos Asprilla
 */
public class Contraseña {
    // ATRIBUTOS/////////////////
    private String nombre;
    private String contraseña;
    private String descripcion;
    private char flag;
    
    
    //////////// METODOS///////////
    
    
    public Contraseña(String nom , String descrip, String contra, char fla){
        nombre = nom;
        contraseña = contra;
        descripcion = descrip;
        flag = fla;         
    }
    
    /**
     * Constructor vacío
     */
    public Contraseña(){}

    /**
     * Constructor de copia
     * @param copiar Contraseña que se copiará
     */
    public Contraseña(Contraseña copiar){
        nombre = copiar.getNombre();
        descripcion = copiar.getDescripcion();
        contraseña = copiar.getContraseña();
        flag = copiar.getFlag();
    }
    
    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the contraseña
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * @param contraseña the contraseña to set
     * @return La contraseña después del cambio
     */
    public Contraseña setContraseña(String contraseña) {
        this.contraseña = contraseña;
        return this;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the flag
     */
    public char getFlag() {
        return flag;
    }

    /**
     * @param flag the flag to set
     */
    public void setFlag(char flag) {
        this.flag = flag;
    }
    
    @Override
     public String toString() {
        return nombre + ";" +
                descripcion + ";" +
                contraseña + ";" +
                flag;
    }
     
     @Override
     public boolean equals(Object contraseña){
         if(contraseña instanceof Contraseña){
             return (((Contraseña) contraseña).getContraseña().equals(this.contraseña) &&
                     ((Contraseña) contraseña).getDescripcion().equals(this.descripcion) &&
                     ((Contraseña) contraseña).getNombre().equals(this.nombre) &&
                     ((Contraseña) contraseña).getFlag() == this.flag);
         }
         return false;
     }
}
