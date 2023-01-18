package test;

import domain.Persona;

public class TestBloquesInicializacion {

    public static void main(String[] args) {
        Persona persona = new Persona();
        System.out.println("idPersona1 = " + persona.getIdPersona());
        System.out.println();
        Persona persona2 = new Persona();
        System.out.println("idPersona2 = " + persona2.getIdPersona());
    }
}
