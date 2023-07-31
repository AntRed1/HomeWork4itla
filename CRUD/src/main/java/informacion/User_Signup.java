package informacion;

public class User_Signup {

    // Atributos de la clase, mediante estas variables las personas podran registrarse//
    private int id_user;
    private String nomb_user;
    private String password;
    private String nombres;
    private String apellidos;
    private String telefono;
    private String email;

    public User_Signup() {
    }

    public User_Signup(int id_user, String nomb_user) {
        this.id_user = id_user;
        this.nomb_user = nomb_user;
    }

    public User_Signup(int id_user, String nomb_user, String password, String nombres, String apellidos, String telefono, String email) {
        this.id_user = id_user;
        this.nomb_user = nomb_user;
        this.password = password;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.email = email;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getNomb_user() {
        return nomb_user;
    }

    public void setNomb_user(String nomb_user) {
        this.nomb_user = nomb_user;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return id_user + "\t\t" + nomb_user + "\t\t" + password + "\t\t" + nombres + "\t\t" + apellidos + "\t\t" + telefono + "\t\t" + email;
    }

}
