package test;

public class TestAutoboxingUnboxing {
    /* clase envolvente
        int - Integer
        long - Long
        float - Float
        double - Double
        boolean - Boolean
        char - Character
        short - Short
        byte - Byte
     */

    public static void main(String[] args) {
        Integer entero = 10;

        System.out.println(entero);
        System.out.println(entero.toString());
        int entero2 = entero; //unboxing- se extrae la literal
        System.out.println(entero2);
    }
}
