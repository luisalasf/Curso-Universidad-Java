import datos.UsuarioDAO;
import domain.Usuario;

import java.util.List;

public class TestManejoUsuario {
    public static void main(String[] args) {
        UsuarioDAO usuarioDao = new UsuarioDAO();

        //Insertando objeto de tipo persona
        /*usuarioDao.insertar(new Usuario("Carlos", "passDeCarlitos"));
        usuarioDao.insertar(new Usuario("Juan", "passDeJuanitoJiji"));*/


        usuarioDao.actualizar(new Usuario(1, "Luis", "contraseñaDeSalitas"));
        /*usuarioDao.delete(3);
        usuarioDao.delete(4);*/

        List<Usuario> usuarios = usuarioDao.seleccionar();
        usuarios.stream().map(usuario -> "Usuario = " + usuario).forEach(System.out::println);
    }
}
