package app;

import domain.*;
import exceptions.*;
import java.util.Random;

public class MainAlumnos {
    private static final int ROPA_MAX = 4;

    public static void main(String[] args)  {
        System.out.println("--- ¡COMIENZA EL CUMPLE DE LOLO! ---");

        try {
            // TODO 1: Crea un Array de Invitados de tamaño 10.
            Invitados[] invitados = {
                    new Familiar("Mama", 40, 15),
                    new Familiar("Papa", 55, 20),
                    new Familiar("Abuela", 31, 70),
                    new Colega("Ruben", 60, 45),
                    new Colega("Moises", 70,10),
                    new Colega("Carlos",50,22),
                    new Gorron("Bermudo",90,32)
            };

            // TODO 2: Rellena las primeras posiciones:
            // - 3 Familiares (con nombres y stats aleatorios)
            // - 3 Colegas (con nombres y stats aleatorios)
            // - 1 Gorrón
            // PISTA: Usa un contador para saber en qué posición del array insertas.


            int ronda = 1;
            boolean fiestaSigue = true;
            boolean yaSeAbrieronRegalos = false;

            // Bucle de la fiesta (máximo 10 rondas)
            while (fiestaSigue && ronda <= 10) {
                System.out.println("\n--- RONDA " + ronda + " ---");
                Evento eventoActual = obtenerEventoAleatorio();

                // Evitamos que se abran regalos dos veces
                while (eventoActual == Evento.APERTRURA_REGALOS && yaSeAbrieronRegalos) {
                    eventoActual = obtenerEventoAleatorio();
                }

                System.out.println("Evento: " + eventoActual);

                // TODO 3: Recorre el array de invitados
                    for (int i = 0; i < invitados.length; i++) {
                        if(eventoActual == Evento.CORTE_TARTA){
                            invitados[i].comer(20);
                        } else if (eventoActual == Evento.BAILE) {
                            invitados[i].divertirse(30);
                        } else if (eventoActual == Evento.MUSICA_ALTA) {
                            invitados[i].divertirse(30);
                        } else if (eventoActual == Evento.MUSICA_BAJA) {
                            invitados[i].aburrirse(30);
                        } else if (eventoActual == Evento.PIÑATA) {
                            invitados[i].divertirse(20);
                            invitados[i].comer(10);
                        } else if (eventoActual == Evento.CHARLITA_COLOQUIAL) {
                            invitados[i].divertirse(20);
                        }

                    }
                // 1. Cuidado con las posiciones null del array.
                // 2. Verifica si el invitado sigue en la fiesta.
                // 3. Haz que reaccione al evento (gestiona las excepciones).
                // 4. Si es APERTURA_REGALOS y el invitado es regalador:
                //    - Pide el regalo (imprímelo por pantalla).


                // TODO 4: Chequeo de fin de fiesta
                // - Si se han regalado 4 prendas de ropa -> Mensaje de decepción.
                // - Si no queda nadie en la fiesta -> Fin con mensaje.

                ronda++;
            }
            System.out.println("--- FIN DE LA FIESTA ---");
        }catch (ValorNoValidoException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Metodo el cual nos da un evento aleatorio para que pase en cada ronda
     * @return devolvemos uno de los eventos
     */
    private static Evento obtenerEventoAleatorio() {
        int random = (int)(Math.random() * 7);
        return switch (random) {
            case 0  -> Evento.APERTRURA_REGALOS;
            case 1 -> Evento. MUSICA_ALTA;
            case 2 -> Evento.MUSICA_BAJA;
            case 3 -> Evento.CHARLITA_COLOQUIAL;
            case 4 -> Evento.BAILE;
            case 5 -> Evento.CORTE_TARTA;
            default -> Evento.PIÑATA;
        };


        // TODO 5: Obtener un evento aleatorio

    }

    //TODO: metodo reaccionar




}
