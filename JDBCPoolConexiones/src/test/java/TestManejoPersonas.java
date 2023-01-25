import datos.Conexion;
import datos.PersonaDAO;
import datos.PersonaDAOJDBC;
import domain.PersonaDTO;

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

            PersonaDAO personaDAO = new PersonaDAOJDBC(conexion);

            List<PersonaDTO> personasDTO = personaDAO.select();

            for (PersonaDTO persona: personasDTO){
                System.out.println("Persona DTO: " + persona);
            }

            conexion.commit();
            System.out.println("Se ha hecho commit de la transacción");
        } catch (SQLException e) {
            e.printStackTrace(System.out);
            try {
                conexion.rollback();
                System.out.println("xdxdxd rollback");
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
    }
}