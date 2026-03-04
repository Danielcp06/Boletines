package Examen2023;

import java.util.List;
import java.util.Objects;

public class Equipo {
    private String nombre;
    private List<Jugadores> jugadores;

    public Equipo(String nombre, List<Jugadores> jugadores) {
        this.nombre = nombre;
        this.jugadores = jugadores;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Jugadores> getJugadores() {
        return jugadores;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Equipo equipo)) return false;
        return Objects.equals(nombre, equipo.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nombre);
    }
}
