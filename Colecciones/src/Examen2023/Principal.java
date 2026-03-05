package Examen2023;

import Examen2023.exceptions.FutbolException;

import java.time.LocalDate;

public class Principal {

    public static void main(String[] args) throws FutbolException {

        Jugadores j1 = new Jugadores("Bermudiño", Demarcacion.DELANTERO, LocalDate.of(1985, 8, 24), "Brasil");
        Jugadores j2 = new Jugadores("Santana", Demarcacion.PORTERO, LocalDate.of(1970, 6, 22), "España");
        Jugadores j3 = new Jugadores("García", Demarcacion.DEFENSA, LocalDate.of(1990, 3, 10), "Argentina");
        Jugadores j4 = new Jugadores("Lopez", Demarcacion.CENTROCAMPISTA, LocalDate.of(1988, 11, 15), "Colombia");
        Jugadores j5 = new Jugadores("Perez", Demarcacion.DEFENSA, LocalDate.of(1992, 2, 8), "México");
        Jugadores j6 = new Jugadores("González", Demarcacion.DELANTERO, LocalDate.of(1995, 9, 1), "Perú");
        Jugadores j7 = new Jugadores("Hernández", Demarcacion.CENTROCAMPISTA, LocalDate.of(1987, 7, 14), "Chile");
        Jugadores j8 = new Jugadores("Martínez", Demarcacion.PORTERO, LocalDate.of(1983, 4, 28), "Uruguay");
        Jugadores j9 = new Jugadores("Castro", Demarcacion.DEFENSA, LocalDate.of(1994, 12, 20), "Venezuela");
        Jugadores j10 = new Jugadores("Ramírez", Demarcacion.CENTROCAMPISTA, LocalDate.of(1993, 5, 12), "Ecuador");
        Jugadores j11 = new Jugadores("Flores", Demarcacion.DELANTERO, LocalDate.of(1989, 10, 6), "Bolivia");
        Jugadores j12 = new Jugadores("Ruiz", Demarcacion.PORTERO, LocalDate.of(1981, 1, 18), "Paraguay");
        Jugadores j1bis = new Jugadores("Bermudiño", Demarcacion.CENTROCAMPISTA, LocalDate.of(1985, 8, 24), "Brasil");
        Jugadores j2bis = new Jugadores("Santana", Demarcacion.DEFENSA, LocalDate.of(1970, 6, 22), "España");
        Jugadores j3bis = new Jugadores("García", Demarcacion.PORTERO, LocalDate.of(1990, 3, 10), "Argentina");
        Jugadores j4bis = new Jugadores("Lopez", Demarcacion.CENTROCAMPISTA, LocalDate.of(1988, 11, 15), "Colombia");
        Jugadores j5bis = new Jugadores("Perez", Demarcacion.DEFENSA, LocalDate.of(1992, 2, 8), "México");


        Equipo e1 = new Equipo("Real Betis Balompié");
        Equipo e2 = new Equipo("La Redondela Football Club");
        Equipo e3 = new Equipo("Isla United");
        Equipo e4 = new Equipo("Vacío de Munich");

        try {
            e1.addJugador(j1);
            e1.addJugador(j2);
            e1.addJugador(j3);
            e1.addJugador(j4);
            e1.addJugador(j5bis);
        }catch (FutbolException e){
            System.out.println(e.getMessage());
        }

        System.out.println(e1);
        try {
            e2.addJugador(j3);
            e2.addJugador(j6);
            e2.addJugador(j7);
            e2.addJugador(j8);
            e2.addJugador(j9);
        }catch (FutbolException e){
            System.out.println(e.getMessage());
        }

        System.out.println(e2);
        try {
            e3.addJugador(j4);
            e3.addJugador(j5);
            e3.addJugador(j10);
            e3.addJugador(j11);
            e3.addJugador(j12);
        }catch (FutbolException e){
            System.out.println(e.getMessage());
        }

        System.out.println(e3);
        try {
            //Las siguientes líneas no deberían añadir al Jugadores
            e1.addJugador(j1bis);
            e2.addJugador(j3);
            e2.addJugador(j3bis);
            e3.addJugador(j4bis);
        }catch (FutbolException e){
            System.out.println(e.getMessage());
        }

        System.out.println(e1);

        Equipo e5 = new Equipo("Borrame FC");
        try {
            e5.addJugador(j1bis);
            e5.addJugador(j2bis);
            e5.addJugador(j3bis);
            e5.addJugador(j4bis);
            e5.addJugador(j5bis);
        }catch (FutbolException e){
            System.out.println(e.getMessage());
        }

        Liga Liga = new Liga("Liga Miravent");
        try {
            //Consulta que debe fallar, pues no hay equipos en la liga
            System.out.printf("Media de edad de la liga: %.2f\n", Liga.mediaDeEdad());
        }catch (FutbolException e){
            System.out.println(e.getMessage());
        }
        System.out.println("##########");

        try {
            Liga.añadirEquipo(e1);
            Liga.añadirEquipo(e2);
            Liga.añadirEquipo(e3);
            Liga.añadirEquipo(e5);

            //Esta línea no puede funcionar
            Liga.añadirEquipo(e4);
        } catch (FutbolException e) {
            System.err.println(e.getMessage());
        }

        System.out.println("##########");
        //Visualicemos la liga hasta ahora
        System.out.println(Liga);
        System.out.println("##############");

        // Esto debe fallar
        Equipo e6 = new Equipo("FC Sin liga");
        try {
            e6.addJugador(j1);
            Liga.eliminarEquipo(e6);
        } catch (FutbolException e) {
            System.err.println(e.getMessage());
        }
        System.out.println("##########");
        //Esto debe eliminar el equipo
        try {
            Liga.eliminarEquipo(e5);
        } catch (FutbolException e) {
            System.err.println(e.getMessage());
        }

        System.out.println(Liga);
        System.out.println("############");
        System.out.println("Visualicemos ahora los jugadores en común de los equipos 1 y 3");

        try {
            for (Jugadores j : Liga.mostrarJugadoresEnComun(e1, e3)) {
                System.out.println(j);
            }
        } catch (FutbolException e) {
            System.err.println(e.getMessage());
        }

        //Unión de los equipos 6 y 2
        System.out.println("############");
        System.out.println("Visualicemos ahora la unión de los equipos 6 y 2");

        try {
            Liga.añadirEquipo(e6);
            Liga.unirEquipos(e6, e2);
        } catch (FutbolException e) {
            System.err.println(e.getMessage());
        }

        System.out.println(e6);

        System.out.println();
        System.out.println("############");
        //Mostramos los jugadores ordenados por edad
        System.out.println("Jugadores ordenados por edad");
        Liga.jugadoresOrdenadosPorFechaNacimiento().forEach(System.out::println);

        System.out.println();
        System.out.println("############");
        //Mostramos los jugadores ordenados por edad
        System.out.println("Jugadores ordenados por nombre");
        Liga.jugadoresOrdenadosPorNombre().forEach(System.out::println);

        System.out.println();
        System.out.println("############");
        try {
            System.out.printf("Media de edad de la liga: %.2f\n", Liga.mediaDeEdad());
        }catch (FutbolException e){
            System.out.println(e.getMessage());
        }

    }


}

