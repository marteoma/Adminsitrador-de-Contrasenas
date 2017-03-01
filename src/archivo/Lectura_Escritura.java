/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivo;

import java.io.BufferedReader;
import java.io.*;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;
import datos.Contraseña;
import graficos.MainFrame;

/**
 *
 * @author Mateo Arboleda
 */
public class Lectura_Escritura {

    /**
     * Lee las contraseñas del archivo
     */
    public static void cargarContraseña() {
        try {
            BufferedReader lector = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream("src/archivo/contraseñas")));
            String linea = lector.readLine();

            while (linea != null) {
                StringTokenizer tokenizer = new StringTokenizer(linea, ";");
                String nombre = tokenizer.nextToken();
                String descripcion = tokenizer.nextToken();
                String contrasena = tokenizer.nextToken();
                String flag = tokenizer.nextToken();
                Contraseña contra = new Contraseña(nombre, descripcion, contrasena, flag.charAt(0));
                MainFrame.contraseñas.add(contra);
                linea = lector.readLine();
            }
            lector.close();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error inesperado");
        }
    }

    /**
     * Escribe una nueva contraseña en el archivo
     * @param nombre Nombre de la contraseña nueva
     * @param descripción Descripción
     * @param contraseña Contraseña nueva
     * @param flag identificador
     * @throws IOException Se arroja cuando hay un problema con el archivo
     */
    public static void Escribir(String nombre, String descripción, String contraseña, char flag) throws IOException {

        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new FileWriter("src/archivo/contraseñas", true));
            out.write("\n" + nombre + ";" + descripción + ";" + contraseña + ";" + flag);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error inesperado");
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    /**
     * Edita una contraseña en el archvio     
     * @param editable La contraseña que será editada
     * @param nueva La contraseña como queda editada
     */
    public static void editar(Contraseña editable, Contraseña nueva) {
        try {
            File fichero = new File("src/archivo/contraseñas");
            BufferedReader reader = new BufferedReader(new FileReader(fichero));
                        
            StringBuilder texto = new StringBuilder();
            String linea = reader.readLine();
            while(linea != null){
                if(editable.toString().equals(linea)){
                    texto.append(nueva.toString()).append("\n");
                }else{
                    texto.append(linea).append("\n");
                }
                linea = reader.readLine();
            }
            texto.deleteCharAt(texto.length()-1);
            reader.close();
            fichero.delete();
            fichero = new File("src/archivo/contraseñas");
            fichero.createNewFile();
            
            BufferedWriter writer = new BufferedWriter(new FileWriter(fichero.getPath(), true));
            writer.write(texto.toString());
            writer.close();
            
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error inesperado");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error inesperado");
        }
    }

    /**
     * Elimina una contraseña del programa 
     * @param borrar Contraseña que será borrada
     */
    public static void eliminar(Contraseña borrar) {
        try {
            File fichero = new File("src/archivo/contraseñas");
            BufferedReader reader = new BufferedReader(new FileReader(fichero));
                        
            StringBuilder texto = new StringBuilder();
            String linea = reader.readLine();
            while(linea != null){
                if(!borrar.toString().equals(linea)){
                    texto.append(linea).append("\n");
                }
                linea = reader.readLine();
            }
            reader.close();
            fichero.delete();
            fichero = new File("src/archivo/contraseñas");
            fichero.createNewFile();
            
            BufferedWriter writer = new BufferedWriter(new FileWriter(fichero.getPath(), true));
            writer.write(texto.toString());
            writer.close();
           
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error inesperado");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error inesperado");
        }
    }
}
