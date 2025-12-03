package Boletin4_2.Ejercicio8;



public class Equipo {
    private String nombre;
    private int partidosGanados;

    public Equipo(String nombre) {
        this.nombre = nombre;
        this.partidosGanados = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPartidosGanados() {
        return partidosGanados;
    }

    public void incrementarGanados() {
        partidosGanados++;
    }

    @Override
    public String toString() {
        return "Equipo: " + nombre + " | Partidos ganados: " + partidosGanados;
    }
}

