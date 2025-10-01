import java.util.Scanner;

public class Ejercicio_10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = 0;

        do {
            System.out.println("Introduce un número entero positivo");
            num = sc.nextInt();
            if (num < 0) {
                System.out.println("El numero debe ser positivo o cero >:(");
            }
        } while (num < 0);
        int factorial = 1;
        for (int i = 1; i <= num; i++) {
            factorial = factorial * i;
        }
        System.out.println("El factorial de " + num + " es " + factorial);


    }
}
