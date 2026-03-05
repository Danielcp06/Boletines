package Examen2023;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Objects;

public class Jugadores implements Comparable<Jugadores>{
    private String nombre;
    private int edad;
    private LocalDate fechaNacimiento;
    private Demarcacion demarcacion;
    private String pais;

    public Jugadores(String nombre, Demarcacion demarcacion, LocalDate fechaNacimiento, String pais) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.demarcacion = demarcacion;
        this.pais = pais;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public int edadJugador(){
        LocalDate fechaActual = LocalDate.now();
        Period periodo = Period.between(fechaNacimiento, fechaActual);
        return periodo.getYears();
    }



    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Jugadores jugadores)) return false;
        return Objects.equals(nombre, jugadores.nombre) && Objects.equals(fechaNacimiento, jugadores.fechaNacimiento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, fechaNacimiento);
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(nombre).append(": ").append(fechaNacimiento).append(". ")
                .append(demarcacion).append(" (").append(pais)
                .append(") ").append(System.lineSeparator());
        return sb.toString();
    }

    @Override
    public int compareTo(Jugadores o) {
        return this.nombre.compareTo(o.nombre);
    }
}
