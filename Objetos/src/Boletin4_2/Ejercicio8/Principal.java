package Boletin4_2.Ejercicio8;


public class Principal {
    public static void main(String[] args) {
        Equipo e1 = new Equipo("Barcelona");
        Equipo e2 = new Equipo("Real Madrid");

        // Intento 1: colocar resultado 2-1
        try {
            Partido p1 = new Partido(1, e1, e2);
            p1.ponerResultado("2-1");
            System.out.println(p1);
        } catch (Exception ex) {
            System.out.println("Error en el primer partido: " + ex.getMessage());
        }

        Partido p2 = null;
        Partido p3 = null;

        boolean hechos = false;

        while (!hechos) {
            try {
                p2 = new Partido(2, e1, e2);
                p2.ponerResultado("0-0");

                p3 = new Partido(3, e1, e2);
                p3.ponerResultado("1-2");

                hechos = true;

            } catch (Exception ex) {
                System.out.println("Error creando partidos, reintentando… " + ex.getMessage());
            }
        }

        // Mostrar información
        System.out.println("\n--- Información de los partidos ---");
        System.out.println(p2);
        System.out.println(p3);

        System.out.println("\n--- Información de los equipos ---");
        System.out.println(e1);
        System.out.println(e2);
    }
}
