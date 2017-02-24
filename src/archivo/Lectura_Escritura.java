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
import datos.Lista;

/**
 *
 * @author Mateo Arboleda
 */
public class Lectura_Escritura {

    Lista<Contraseña> listEstudiante;

    public Lectura_Escritura() {
        listEstudiante = new Lista<Contraseña>();
    }

    public void cargarContraseña() {
        try {
            BufferedReader lector = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream("src/archivo/contraseñas")));
            String linea = lector.readLine();

            while (linea != null) {
                if (!linea.startsWith("#")) {
                    StringTokenizer tokenizer = new StringTokenizer(linea, ";");
                    String nombre = tokenizer.nextToken();
                    String descripcion = tokenizer.nextToken();
                    String contrasena = tokenizer.nextToken();
                    String flag = tokenizer.nextToken();
                 //   Contraseña contra = new Contraseña(nombre, descripcion, contrasena, flag);
                   // listEstudiante.add(contra);
                }
                linea = lector.readLine();
            }
            lector.close();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void Escribir(String nombre, String descripción, String contraseña, String flag) throws IOException {

        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new FileWriter("src/archivo/contraseñas", true));
            out.write("\n"+nombre+";"+descripción+";"+contraseña+";"+flag);
        } catch (Exception e) {
    // error processing code   
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

}
