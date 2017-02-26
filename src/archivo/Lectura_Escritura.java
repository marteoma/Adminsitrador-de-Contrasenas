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
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.rmi.log.ReliableLog;

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
     *
     * @param editable La contraseña que será editada
     * @param nueva La contraseña como queda editada
     */
    public static void editar(Contraseña editable, Contraseña nueva) {
        try {
            RandomAccessFile archivo = new RandomAccessFile("src/archivo/contraseñas", "rw");
            String linea = archivo.readLine();
            linea = new String(linea.getBytes("ISO-8859-1"), "UTF-8");
            long seek = 0;

            while (linea != null && !linea.contains(editable.toString())) {
                seek = archivo.getFilePointer();
                linea = archivo.readLine();
                if (linea != null) {
                    linea = new String(linea.getBytes("ISO-8859-1"), "UTF-8");
                }
            }

            if (linea != null) {
                int len = linea.length();
                byte[] arreglo = new byte[len];

                for (int i = 0; i < arreglo.length; i++) {
                    if (i < nueva.toString().length()) {
                        arreglo[i] = nueva.toString().getBytes()[i];
                    }
                }
                archivo.seek(seek);
                archivo.write(arreglo);
            }
            archivo.close();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error inesperado");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error inesperado");
        }
    }

    public static void eliminar(Contraseña borrar) {
        try {
            RandomAccessFile archivo = new RandomAccessFile("src/archivo/contraseñas", "rw");
            String linea = archivo.readLine();
            linea = new String(linea.getBytes("ISO-8859-1"), "UTF-8");
            long seek = 0;
            
            while (linea != null && !linea.contains(borrar.toString())) {
                seek = archivo.getFilePointer();
                linea = archivo.readLine();
                if (linea != null) {
                    linea = new String(linea.getBytes("ISO-8859-1"), "UTF-8");
                }
            }
            
            archivo.seek(seek-1);
            byte[] ceros = new byte[linea.length()+1];
            archivo.write(ceros);

        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error inesperado");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error inesperado");
        }
    }
}
