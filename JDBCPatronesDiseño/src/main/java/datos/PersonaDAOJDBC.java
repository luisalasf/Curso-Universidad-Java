package datos;

import domain.PersonaDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//DAO Data access Object
public class PersonaDAOJDBC implements PersonaDAO {

    private Connection conexionTransaccional;

    private static final String SQL_SELECT = "SELECT idPersona, nombre, apellido, email, telefono FROM persona;";
    private static final String SQL_INSERT = "INSERT INTO persona (nombre, apellido, email, telefono) VALUES(?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE persona SET nombre = ?, apellido = ?, email = ?, telefono = ? WHERE idPersona = ?";
    private static final String SQL_DELETE = "DELETE FROM persona WHERE idPersona = ?";

    public PersonaDAOJDBC(){

    }

    public PersonaDAOJDBC(Connection conexionTransaccional){
        this.conexionTransaccional = conexionTransaccional;
    }

    public List<PersonaDTO> select () throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        PersonaDTO personaDTO = null;

        List<PersonaDTO> personaDTOS = new ArrayList<>();

        try {
            conn = conexionTransaccional == null ? Conexion.getConnection() : conexionTransaccional;
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()){
                int idPersona = rs.getInt("idPersona");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
                personaDTO = new PersonaDTO(idPersona,nombre,apellido,email,telefono);
                personaDTOS.add(personaDTO);
            }
        }finally {
            try {
                Conexion.close(rs);
                Conexion.close(stmt);
                if (this.conexionTransaccional == null){
                    Conexion.close(conn);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return personaDTOS;
    }

    public int insert(PersonaDTO personaDTO) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try{
            conn = conexionTransaccional == null ? Conexion.getConnection() : conexionTransaccional;
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, personaDTO.getNombre());
            stmt.setString(2, personaDTO.getApellido());
            stmt.setString(3, personaDTO.getEmail());
            stmt.setString(4, personaDTO.getTelefono());
            registros = stmt.executeUpdate();
        }finally {
            try {
                Conexion.close(stmt);
                if (this.conexionTransaccional == null){
                    Conexion.close(conn);
                }
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }
        return registros;
    }

    public int update(PersonaDTO personaDTO) throws SQLException {
        int registros = 0;

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = conexionTransaccional == null ? Conexion.getConnection() : conexionTransaccional;
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, personaDTO.getNombre());
            stmt.setString(2, personaDTO.getApellido());
            stmt.setString(3, personaDTO.getEmail());
            stmt.setString(4, personaDTO.getTelefono());
            stmt.setInt(5, personaDTO.getIdPersona());
            registros = stmt.executeUpdate();
        }finally {
            try {
                Conexion.close(stmt);
                if (this.conexionTransaccional == null){
                    Conexion.close(conn);
                }
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }
        return registros;
    }
    public int delete(int idPersona) throws SQLException {
        int registros = 0;

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = conexionTransaccional == null ? Conexion.getConnection() : conexionTransaccional;
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, idPersona);
            registros = stmt.executeUpdate();
        }finally {
            try {
                Conexion.close(stmt);
                if (this.conexionTransaccional == null){
                    Conexion.close(conn);
                }
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }
        return registros;
    }
}
