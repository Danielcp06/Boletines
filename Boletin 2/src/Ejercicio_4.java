import java.util.Scanner;

public class Ejercicio_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dime un numero del 1 al 100, tienes 5 intentos para averiguar mi numero");
        int num = sc.nextInt();
        while (num < 1 || num > 100) {
            System.out.println("El numero tiene que ser del 1 al 100");
            num = sc.nextInt();
        }
        int numale = generarAleatorio(1, 100);
        int contador = 0;

        while (num != numale) {
            if (num < numale) {
                System.out.println("Tu numero es menor que el numero en el que ha pensado el ordenador");
            } else {
                System.out.println("Tu numero es mayor que el numero en el que ha pensado el ordenador");

            }
            num = sc.nextInt();
            contador++;
            if (contador == 5) {
                break;
            }
        }

        if (contador == 5) {
            System.out.println("Has gastado el numero de intentos. El numero era " + numale);
        } else {
            if (num == numale) {
                System.out.println("Has acertado el numero");
            }
        }
    }

    public static int generarAleatorio(int max) {
        return (int) (Math.random() * max + 1);
    }

    public static int generarAleatorio(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }

}
