package Examen2023;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Objects;

public class Jugadores {
    private String nombre;
    private LocalDate fechaNacimiento;
    private Demarcacion demarcacion;
    private String pais;

    public Jugadores(String nombre, LocalDate fechaNacimiento, Demarcacion demarcacion, String pais) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.demarcacion = demarcacion;
        this.pais = pais;
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
}
