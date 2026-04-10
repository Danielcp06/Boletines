public class Persona {
    private String nombre;
    private String DNI;
    private int telefono;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public Persona(String nombre, String DNI, int telefono) {
        this.nombre = nombre;
        this.DNI = DNI;
        this.telefono = telefono;
    }
}
