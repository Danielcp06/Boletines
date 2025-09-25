import java.util.Scanner;

public class Ejercicio_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Cuantos numeros va a introducir?");
        int cantidadNumero = sc.nextInt();
        while (cantidadNumero == 0 || cantidadNumero < 0) {
            System.out.println("Introduce un numero valido");
            cantidadNumero = sc.nextInt();
        }

        for (int i = 0; i < cantidadNumero; i++) {
            System.out.println("Dime los numeros");
            int numero = sc.nextInt();
            if (numero % 2 == 0) {
                System.out.println("El numero " + numero + " es par");
            } else {
                System.out.println("El numero " + numero + " es impar");


            }

        }

        sc.close();
    }
}
