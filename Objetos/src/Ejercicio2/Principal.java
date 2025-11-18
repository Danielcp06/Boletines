package Ejercicio2;

import java.util.Scanner;

public class Principal {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("¿Qué quieres hacer?");
        System.out.println(Cuenta.textoOpciones[Cuenta.verOpciones]);
        String opcion = sc.nextLine();

    }
}
