package domain;

public class Persona {
    private final int idPersona;
    private static int contadorPersonas;

    static {
        System.out.println("Ejecucion bloque estatico");
        ++Persona.contadorPersonas;
        //idPersona = 10;
    }

    {//se ejecuta antes del constructor de la clase
        System.out.println("Ejecucion bloque no estatico");
        this.idPersona = Persona.contadorPersonas++;
    }

    public Persona(){
        System.out.println("Ejecucion del constructor");
    }

    public int getIdPersona() {
        return idPersona;
    }
}
