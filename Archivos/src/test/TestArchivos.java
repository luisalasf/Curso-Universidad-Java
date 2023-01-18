package test;

import domain.Archivo;

import java.io.IOException;

public class TestArchivos {
    public static void main(String[] args) throws IOException {
        String nombre = "MiPrimerArchivo.txt";
        /*Archivo.crearArchivo(nombre);
        Archivo.escribirArchivo(nombre, "Mi primera linea de contenido dentro del archivo xd");
        Archivo.agregarContenido(nombre, "Este es contenido adicional ");*/
        Archivo.leerArchivo(nombre);
    }
}
