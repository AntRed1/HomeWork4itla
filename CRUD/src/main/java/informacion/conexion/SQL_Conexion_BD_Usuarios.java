package informacion.conexion;

import informacion.*;
import static informacion.conexion.SQL_Metodos.close;
import java.sql.*;

public class SQL_Conexion_BD_Usuarios {

    private static final String base2 = "Logins";
    private static final String JDBC_URL2 = "jdbc:mysql://localhost:3306/" + base2 + "?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORDS = "@Emulador1";
    private static final String SQL_WHERE = "SELECT count(ID_User) FROM usuarios WHERE Nomb_User = ?";

    private Connection con2 = null;

    public Connection getConnection() throws SQLException {

        try {

            Class.forName("com.mysql.jdbc.Driver");
            con2 = DriverManager.getConnection(JDBC_URL2, JDBC_USER, JDBC_PASSWORDS);

        } catch (ClassNotFoundException ex) {
            ex.printStackTrace(System.out);
        }
        return con2;

    }

    public int buscar_user(String user_login) throws SQLException {

        PreparedStatement stmt = null;
        ResultSet rs = null;
        Connection con2 = getConnection();

        try {

            stmt = con2.prepareStatement(SQL_WHERE);
            stmt.setString(1, user_login);
            rs = stmt.executeQuery();

            if (rs.next()) {

                return rs.getInt(1);

            }
            return 1;

        } catch (SQLException e) {

            e.printStackTrace(System.out);
            return 1;

        } finally {// al finalizar se cerraran las conexiones//
            try {
                close(rs);
                close(stmt);
                close(con2);
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }
    }

}
