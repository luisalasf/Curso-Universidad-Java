import datos.PersonaDAO;
import domain.Persona;

import java.util.List;

public class TestManejoPersonas {
    public static void main(String[] args) {
        PersonaDAO personaDao = new PersonaDAO();

        //Insertando objeto de tipo persona
        //Persona personaNueva = new Persona("Carlos", "Esparza", "cesparza@mail.com", "55654987897");
        //personaDao.insertar(personaNueva);
        /*Persona personaLuis = new Persona(5, "Luis", "Salas", "luispiyu@mail.com", "564987465");
        personaDao.actualizar(personaLuis);*/

        personaDao.delete(5);
        List<Persona> personas = personaDao.seleccionar();

        personas.stream().map(persona -> "Persona = " + persona).forEach(System.out::println);


    }
}
