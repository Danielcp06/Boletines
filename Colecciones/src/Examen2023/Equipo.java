package Examen2023;

import Examen2023.exceptions.FutbolException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Equipo {
    private String nombre;
    private List<Jugadores> jugadores;

    public Equipo(String nombre) {
        this.nombre = nombre;
        this.jugadores = new ArrayList<>();
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

    public void addJugador(Jugadores j) throws FutbolException {
        if (!j.getNombre().isEmpty() && !this.jugadores.contains(j) ){
            this.jugadores.add(j);
        }else{
            throw new FutbolException("El jugador no tiene nombre o ya esta en la liga ");
        }

    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Nombre = '").append(nombre).append('\n');
        sb.append("jugadores = ");

        sb.append(jugadores.stream().map(Jugadores::toString).collect(Collectors.joining(",")));
        return sb.toString();
    }
}
