package informacion.conexion;

import informacion.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQL_Metodos extends User_Signup {

    // Atributos Sentencias SQL //
    private static final String SQL_INSERT = "INSERT INTO informacion_usuarios(Nomb_User, Password, Nombres, Apellidos, Telefono, Email) VALUES(?, ?, ?, ?, ?, ?)";
    private static final String SQL_SELECT = "SELECT ID_User,Nomb_User, Password, Nombres,Apellidos,Telefono, Email FROM informacion_usuarios";
    private static final String SQL_DELETE = "DELETE FROM informacion_usuarios WHERE ID_User = ?";

    // Atributos //
    private static final String base = "Logins";
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/" + base
            + "?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORDS = "@Emulador1";
    private Connection con = null;

    public Connection getConnection() throws SQLException {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORDS);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace(System.out);
        }
        return con;

    }

    // Metodos para Cerrar las conexiones, cuando se finalice la accion que se desee
    // hacer//
    public static void close(ResultSet rs) throws SQLException {
        rs.close();
    }

    public static void close(Statement smtm) throws SQLException {
        smtm.close();
    }

    public static void close(PreparedStatement smtm) throws SQLException {
        smtm.close();
    }

    public static void close(Connection conn) throws SQLException {
        conn.close();
    }

    // Metodo para registrar//
    public boolean registrar(User_Signup user) throws SQLException {

        PreparedStatement ps = null;
        Connection con = getConnection();
        try {
            ps = con.prepareStatement(SQL_INSERT);
            ps.setString(1, user.getNomb_user());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getNombres());
            ps.setString(4, user.getApellidos());
            ps.setString(5, user.getTelefono());
            ps.setString(6, user.getEmail());
            ps.execute();
            return true;

        } catch (SQLException ex) {

            ex.printStackTrace(System.out);
        } finally {
            close(ps);
        }

        return false;
    }

    // Metodo para Seleccionar todos los Registros de la tabla
    // informacion_usuarios//
    public List<User_Signup> seleccionar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        User_Signup user = null;
        List<User_Signup> users = new ArrayList<>();

        try {

            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {

                int id_User = rs.getInt("ID_User");
                String nomb_User = rs.getString("Nomb_User");
                String nombres = rs.getString("Nombres");
                String password = rs.getString("Password");
                String apellidos = rs.getString("Apellidos");
                String telefono = rs.getString("Telefono");
                String email = rs.getString("Email");
                user = new User_Signup(id_User, nomb_User, password, nombres, apellidos, telefono, email);

                users.add(user);

            }

        } catch (SQLException ex) {

            ex.printStackTrace(System.out);

        }
        return users;
    }

    public boolean eliminar(User_Signup user) throws SQLException {

        PreparedStatement ps = null;
        Connection con = getConnection();
        try {
            ps = con.prepareStatement(SQL_DELETE);
            ps.setInt(1, user.getId_user());
            ps.execute();
            return true;

        } catch (SQLException ex) {

            ex.printStackTrace(System.out);
            return false;
        } finally {

            con.close();
        }

    }

    public boolean modificar(User_Signup mod) throws SQLException {
        Connection cn = getConnection();
        PreparedStatement ps = null;

        String sql = "UPDATE informacion_usuarios SET Nomb_User = ?, Password = ?, Nombres = ?, Apellidos = ?, Telefono = ?, Emai = ? WHERE ID_User = ?";

        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, mod.getNomb_user());
            ps.setString(2, mod.getPassword());
            ps.setString(3, mod.getNombres());
            ps.setString(4, mod.getApellidos());
            ps.setString(5, mod.getTelefono());
            ps.setString(6, mod.getEmail());
            ps.setInt(7, mod.getId_user());
            ps.executeUpdate();
            cn.close();

            return true;

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);

            return false;
        }
    }

}
