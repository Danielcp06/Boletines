package Juego;

import java.util.Scanner;

public class JuegoRPG {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Guerrero heroe = new Guerrero("Aragorn", 100, 15);
        Orco enemigo = new Orco("Uruk-hai", 60, 10);

        System.out.println("--- INICIO DEL COMBATE ---");

        int turno = 1;

        System.out.println("Puedes atacar y curarte");
        while (heroe.estaVivo() && !enemigo.estaDerrotado()) {

            System.out.println("\n--- Turno " + turno + " ---");
            System.out.println("Vida Héroe: " + heroe.getVidaActual());
            System.out.println("Vida Enemigo: " + enemigo.getVida());
            System.out.println("¿Qué quieres hacer ahora?");
            String comando = sc.nextLine();

            switch (comando.toLowerCase()) {
                case "atacar":
                    int danoHeroe = heroe.atacar();
                    enemigo.recibirDano(danoHeroe);
                    break;
                case "curar":
                    heroe.curar();
                    break;
            }

            // Turno del Enemigo
            int danoEnemigo = enemigo.morder();
            heroe.recibirDano(danoEnemigo);

            turno++;

            try { Thread.sleep(100); } catch (InterruptedException e) { }
        }

        System.out.println("--- FIN DEL COMBATE ---");

        if (heroe.estaVivo()) {
            System.out.println("¡El héroe ha ganado!");
        } else {
            System.out.println("El héroe ha caído...");
        }
    }
}