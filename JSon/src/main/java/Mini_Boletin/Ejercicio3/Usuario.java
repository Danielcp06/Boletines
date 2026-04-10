package Mini_Boletin.Ejercicio3;

public class Usuario {
    private String username;
    private transient String passwd;
    private String email;
    private Direccion direccion;

    public Usuario(String username, String passwd, String email, Direccion direccion) {
        this.username = username;
        this.passwd = passwd;
        this.email = email;
        this.direccion = direccion;
    }

    public String getUsername() {
        return username;
    }

    public String getPasswd() {
        return passwd;
    }

    public String getEmail() {
        return email;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    @Override
    public String toString() {
        return "Usuario:\n" +
                "username='" + username + "',\n" +
                "passwd='" + passwd + "',\n" +
                "email='" + email + "',\n" +
                "direccion=" + direccion;
    }
}
