package test;

import domain.Persona;

public class TestForEach {
    public static void main(String[] args) {
        Persona personas[] = {new Persona("Luis"), new Persona("Paco"), new Persona("Juan")};

        for (Persona persona : personas) {
            System.out.println(persona);
        }


    }
}
