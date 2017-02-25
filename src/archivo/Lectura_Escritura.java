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

    public static void Escribir(String nombre, String descripción, String contraseña, char flag) throws IOException {

        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new FileWriter("src/archivo/contraseñas", true));
            out.write("\n"+nombre+";"+descripción+";"+contraseña+";"+flag);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error inesperado");
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }
}
