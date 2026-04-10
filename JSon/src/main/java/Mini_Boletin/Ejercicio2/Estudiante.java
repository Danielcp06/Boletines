package Mini_Boletin.Ejercicio2;

public class Estudiante {
    private String nombre;
    private String curso;
    private double notaMedia;

    public Estudiante(String nombre, String curso, double notaMedia) {
        this.nombre = nombre;
        this.curso = curso;
        this.notaMedia = notaMedia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCurso() {
        return curso;
    }

    public double getNotaMedia() {
        return notaMedia;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "nombre='" + nombre + '\'' +
                ", curso='" + curso + '\'' +
                ", notaMedia=" + notaMedia +
                '}';
    }
}
