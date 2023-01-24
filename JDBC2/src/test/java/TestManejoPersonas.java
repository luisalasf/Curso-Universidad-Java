import datos.Conexion;
import datos.PersonaDAO;
import domain.Persona;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TestManejoPersonas {
    public static void main(String[] args) {

        Connection conexion = null;

        try {
            conexion = Conexion.getConnection();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }
            PersonaDAO personaDAO = new PersonaDAO(conexion);

            Persona persona = new Persona();
            persona.setIdPersona(1);
            persona.setNombre("Naomi");
            persona.setApellido("Torres");
            persona.setEmail("naomiTorres@mail.com");
            persona.setTelefono("51972343218786");
            personaDAO.actualizar(persona);


            Persona personaNueva = new Persona();
            personaNueva.setNombre("Carlos");
//            personaNueva.setApellido("Ramirez99999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999");
            personaNueva.setApellido("Ramirez");
            personaNueva.setEmail("carlitosRamirez@mail.com");
            personaNueva.setTelefono("7465456465");
            personaDAO.insertar(personaNueva);

            conexion.commit();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
            try {
                System.out.println("xdxdxd rollback");
                conexion.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
    }
}