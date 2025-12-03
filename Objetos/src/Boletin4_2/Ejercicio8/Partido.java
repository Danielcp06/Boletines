package Boletin4_2.Ejercicio8;


public class Partido {
    private int jornada;
    private Equipo local;
    private Equipo visitante;

    private Integer golesLocal;
    private Integer golesVisitante;
    private Character quiniela;

    public Partido(int jornada, Equipo local, Equipo visitante) throws Exception {
        if (jornada < 1 || jornada > 38)
            throw new Exception("La jornada debe estar entre 1 y 38");

        if (local.getNombre().equalsIgnoreCase(visitante.getNombre()))
            throw new Exception("Los equipos deben ser diferentes");

        this.jornada = jornada;
        this.local = local;
        this.visitante = visitante;
        this.golesLocal = null;
        this.golesVisitante = null;
        this.quiniela = null;
    }

    public void ponerResultado(String resultado) throws Exception {
        if (!resultado.matches("\\d+-\\d+"))
            throw new Exception("Formato incorrecto. Debe ser n-m");

        String[] partes = resultado.split("-");
        int gl = Integer.parseInt(partes[0]);
        int gv = Integer.parseInt(partes[1]);

        if (gl < 0 || gv < 0)
            throw new Exception("Los goles no pueden ser negativos");

        this.golesLocal = gl;
        this.golesVisitante = gv;

        if (gl > gv) {
            quiniela = '1';
            local.incrementarGanados();
        } else if (gl < gv) {
            quiniela = '2';
            visitante.incrementarGanados();
        } else {
            quiniela = 'X';
        }
    }

    @Override
    public String toString() {
        if (golesLocal == null)
            return "Partido entre equipo local " + local.getNombre() +
                    " y equipo visitante " + visitante.getNombre() +
                    " todavía no se ha jugado";

        return "Partido entre equipo local " + local.getNombre() +
                "y el equipo visitante " + visitante.getNombre() +
                "jugado en el estadio (dato inventado) de la ciudad (dato inventado)\n " +
                "ha finalizado con " + golesLocal + " goles de equipo local y \n " +
                golesVisitante + " goles de equipo visitante.\n " +
                "Resultado quiniela= " + quiniela;
    }
}

