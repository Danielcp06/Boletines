import java.util.Scanner;

public class Bucle_while {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dime un numero");
        int numero = sc.nextInt();
        int divisor = 2;

        while (divisor <= numero / 2 && numero % divisor != 0) {
            divisor++;
        }
        if (numero % divisor == 0) {
            System.out.println("El primer divisor de " + numero + " es " + divisor);
        } else {
            System.out.println("El primer divisor de " + numero + " es " + numero);
        }


    }
}

