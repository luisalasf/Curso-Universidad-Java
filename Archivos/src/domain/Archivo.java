package domain;

import java.awt.print.PrinterException;
import java.io.*;

public class Archivo {
    public static void crearArchivo(String nombreArchivo){
        File archivo = new File(nombreArchivo);
        PrintWriter salida = null;
        try {
            salida = new PrintWriter(archivo);
            salida.close();
            System.out.println("Se ha creado el archivo xd");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void escribirArchivo(String nombreArchivo, String contenido){
        File archivo = new File(nombreArchivo);
        try{
            PrintWriter entrada = new PrintWriter(archivo);
            entrada.println(contenido);
            entrada.close();
            System.out.println("Se ha sobreescrito el contenido");
        }catch (FileNotFoundException ex){
            ex.printStackTrace(System.out);
        }
    }

    public static void agregarContenido(String nombreArchivo, String contenido) throws IOException {
        File archivo = new File(nombreArchivo);
        PrintWriter entrada = new PrintWriter(new FileWriter(archivo, true));
        entrada.println(contenido);
        entrada.close();
        System.out.println("Se ha agregado el contenido");
    }

    public static void leerArchivo(String nombre){
        File archivo = new File(nombre);
        try {
            BufferedReader salida = new BufferedReader(new FileReader(archivo));
            String linea = salida.readLine();
            while (linea != null){
                System.out.println("La linea leída es: " + linea);
                linea = salida.readLine();
            }
            salida.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
