package test;

import paquete1.Clase1;

public class TestModificadorAcceso {
    public static void main(String[] args) {
        Clase1 clase1 = new Clase1();
        System.out.println("Clase1 = " + clase1);
        System.out.println(clase1.atributoPublico);
        clase1.metodoPublico();
    }
}
