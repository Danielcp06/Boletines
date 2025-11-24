package Ejercicio3;

import Ejercicio3.Exception.MiException;
import MiEntradaSalida.MiEntradaSalida;

import java.util.Scanner;

public class Principal {
    private static Scanner sc = new Scanner(System.in);
    static void main(String[] args) {
        boolean comprando = true;
        Maquina miMaquina;

        try {
            miMaquina = new Maquina(10);

        } catch (MiException e) {
            throw new RuntimeException(e);
        }

        while(comprando){
            String comando = MiEntradaSalida.leerLinea("Puedes comprar café solo(1€), leche sola(0,8€), café con leche(1,5€),\ntambién puedes consultar el estado de la maquina y salir\n");
            double dineroIntroducido;
            switch (comando.toLowerCase()){
                case "cafe solo":
                    dineroIntroducido = MiEntradaSalida.leerDecimal("Cuanto dinero vas a introducir\n");
                    try {
                        double cambio = miMaquina.servirCafe(dineroIntroducido);
                        System.out.println("Se le ha servido su café");
                        System.out.printf("Por favor, recoja su cambio (%.2f€)%n", cambio);
                    } catch (MiException e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case "leche sola":
                    dineroIntroducido = MiEntradaSalida.leerDecimal("Cuanto dinero vas a introducir\n");
                    try {
                        double cambio = miMaquina.servirLeche(dineroIntroducido);
                        System.out.println("Se le ha servido su leche");
                        System.out.printf("Por favor, recoja su cambio (%.2f€)%n", cambio);
                    } catch (MiException e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case "cafe con leche":
                    dineroIntroducido = MiEntradaSalida.leerDecimal("Cuanto dinero vas a introducir\n");
                    try {
                        double cambio = miMaquina.servirCafeLeche(dineroIntroducido);
                        System.out.println("Se le ha servido su café con leche");
                        System.out.printf("Por favor, recoja su cambio (%.2f€)%n", cambio);
                    } catch (MiException e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case "consultar":
                    String estado = miMaquina.estadoMaquina();
                    System.out.println(estado);
                     break;
                case "salir":
                    comprando = false;
                    break;
            }
        }
        System.out.println("Gracias por utilizar nuestros servicios");

    }
}
