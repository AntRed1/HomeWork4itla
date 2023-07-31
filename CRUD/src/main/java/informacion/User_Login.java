package informacion;

public class User_Login {

    // Atributos de la clase, mediante estas variables las personas podran iniciar sesion//
    private int id_user;
    private String nomb_user;
    private String password;

    public User_Login() {
    }

    public User_Login(String nomb_user) {
        this.nomb_user = nomb_user;
    }

    public User_Login(String nomb_user, String password) {
        this.nomb_user = nomb_user;
        this.password = password;
    }

    public User_Login(int id_user, String nomb_user, String password) {
        this.id_user = id_user;
        this.nomb_user = nomb_user;
        this.password = password;
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
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Login{" + "id_user=" + id_user + ", nomb_user=" + nomb_user + ", password=" + password + '}';
    }

}
