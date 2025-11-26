package Boletin4_1.Ejercicio3;

import Boletin4_1.Ejercicio3.Exception.MiException;
import MiEntradaSalida.MiEntradaSalida;

import java.util.Scanner;

public class Principal {
    static void main(String[] args) {
        boolean comprando = true;
        Maquina miMaquina = null;
        while(miMaquina == null){
            try {
                miMaquina = new Maquina(10);

            } catch (MiException e) {
                System.out.println(e.getMessage());
            }
        }


        while(comprando){
            String mensaje = "Puedes comprar café solo %.2f, leche sola %.2f y el café con leche %.2f,\ntambién puedes consultar el estado de la maquina y salir\n".formatted(Maquina.PRECIO_CAFE, Maquina.PRECIO_LECHE,Maquina.PRECIO_CAFE_LECHE);
            String comando = MiEntradaSalida.leerLinea(mensaje);
            double dineroIntroducido;
            switch (comando.toLowerCase()){
                case "cafe solo":
                    dineroIntroducido = MiEntradaSalida.leerDouble("Cuanto dinero vas a introducir\n");
                    try {
                        double cambio = miMaquina.servirCafe(dineroIntroducido);
                        System.out.println("Se le ha servido su café");
                        System.out.printf("Por favor, recoja su cambio (%.2f€)%n", cambio);
                    } catch (MiException e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case "leche sola":
                    dineroIntroducido = MiEntradaSalida.leerDouble("Cuanto dinero vas a introducir\n");
                    try {
                        double cambio = miMaquina.servirLeche(dineroIntroducido);
                        System.out.println("Se le ha servido su leche");
                        System.out.printf("Por favor, recoja su cambio (%.2f€)%n", cambio);
                    } catch (MiException e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case "cafe con leche":
                    dineroIntroducido = MiEntradaSalida.leerDouble("Cuanto dinero vas a introducir\n");
                    try {
                        double cambio = miMaquina.servirCafeLeche(dineroIntroducido);
                        System.out.println("Se le ha servido su café con leche");
                        System.out.printf("Por favor, recoja su cambio (%.2f€)%n", cambio);
                    } catch (MiException e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case "consultar":
                    System.out.println(miMaquina.estadoMaquina());
                     break;
                case "salir":
                    comprando = false;
                    break;
            }
        }
        System.out.println("Gracias por utilizar nuestros servicios");

    }
}
