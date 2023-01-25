package datos;

import domain.PersonaDTO;

import java.sql.SQLException;
import java.util.List;

public interface PersonaDAO {

    public List<PersonaDTO> select() throws SQLException;
    public int insert(PersonaDTO personaDTO) throws SQLException;
    public int update(PersonaDTO personaDTO) throws SQLException;
    public int delete(int idPersona) throws SQLException;

}
