import java.sql.*;

public class TestMySqlJDBC {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test2?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        try {
            //Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection(url, "root", "root");
            Statement instruccion = conexion.createStatement(); // conector, implementacion
            String sql = "SELECT idPersona, nombre, apellido, email, telefono FROM persona";
            ResultSet resultado = instruccion.executeQuery(sql);

            while (resultado.next()){
                System.out.print("idPersona: " + resultado.getInt("idPersona"));
                System.out.print(" nombre: " + resultado.getString("nombre"));
                System.out.print(" apellido: " + resultado.getString("apellido"));
                System.out.print(" email: " + resultado.getString("email"));
                System.out.println(" telefono: " + resultado.getString("telefono"));
            }

            resultado.close();
            instruccion.close();
            conexion.close();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }
}
