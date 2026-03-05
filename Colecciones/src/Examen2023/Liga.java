package Examen2023;

import Examen2023.exceptions.FutbolException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Liga {
    private String nombre;
    private List<Equipo> equipos;

    public Liga(String nombre) {
        this.nombre = nombre;
        this.equipos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public List<Equipo> getEquipos() {
        return equipos;
    }

    public void añadirEquipo(Equipo equipoAñadir) throws FutbolException {
        if (!equipoAñadir.getJugadores().isEmpty() && !this.equipos.contains(equipoAñadir) ){
            this.equipos.add(equipoAñadir);
        }else{
            throw new FutbolException("El equipo esta vacio o ya esta en la liga ");
        }
    }

    public void eliminarEquipo(Equipo equipoEliminar) throws FutbolException {
        if (this.equipos.contains(equipoEliminar)){
            this.equipos.remove(equipoEliminar);
        }else {
            throw new FutbolException("El equipo no se puede eliminar");
        }
    }

    public void unirEquipos (Equipo equipo1, Equipo equipo2) throws FutbolException {
        if(this.equipos.contains(equipo1) && this.equipos.contains(equipo2)){
            equipo1.getJugadores().addAll(equipo2.getJugadores());
            eliminarEquipo(equipo2);
        }else {
            throw new FutbolException("Alguno de los equipos no esta en la liga");
        }
    }

    public List<Jugadores> mostrarJugadoresEnComun(Equipo equipo1, Equipo equipo2) throws FutbolException {
        if (this.equipos.contains(equipo1) && this. equipos.contains(equipo2)){
            List<Jugadores> comunes = new ArrayList<>(equipo1.getJugadores());
            comunes.retainAll(equipo2.getJugadores());
            return comunes;
        }else {
            throw new FutbolException("Alguno de los equipos no esta en la liga");
        }
    }

    public Set<Jugadores> todosLosJugadores(){
        Set<Jugadores> todos = new HashSet<>();
        for (Equipo equipo : equipos){
            todos.addAll(equipo.getJugadores());
        }
        return todos;
    }

    public double mediaDeEdad() throws FutbolException{
        return todosLosJugadores().stream().mapToInt(Jugadores::edadJugador).average()
                .orElseThrow(() -> new FutbolException("asd"));
    }

    public List<Jugadores> jugadoresOrdenadosPorFechaNacimiento(){
        return todosLosJugadores().stream().sorted((j1,j2) -> j2.getEdad() - j1.getEdad()).toList();
    }

    public List<Jugadores> jugadoresOrdenadosPorNombre(){
        return todosLosJugadores().stream().sorted().toList();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Bienvenidos a " + nombre).append(System.lineSeparator());
        sb.append("Equipos: ").append(System.lineSeparator());
        for (Equipo e: equipos) {
            sb.append(e).append(System.lineSeparator());
        }

        return sb.toString();

    }
}
