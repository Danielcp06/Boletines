package Mini_Boletin.Ejercicio4;

import java.time.LocalDate;

public class Evento {
    private String nombre;
    private LocalDate fecha;

    public Evento(String nombre, LocalDate fecha) {
        this.nombre = nombre;
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "nombre='" + nombre + '\'' +
                ", fecha=" + fecha +
                '}';
    }
}
