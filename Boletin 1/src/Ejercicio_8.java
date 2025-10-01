import java.util.Scanner;

public class Ejercicio_8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce un numero: ");
        double num = sc.nextInt();

        double menor = num;

        boolean continuar = true;

        while (continuar) {
            System.out.println("Deseas introducir mas numeros (S/N) ");
            String respuesta = sc.next().toUpperCase();

            if (respuesta.equals("S")) {
                System.out.print("Introduce un numero: ");
                num = sc.nextDouble();

                if (num < menor) {
                    menor = num;
                }
            } else if (respuesta.equals("N")) {
                continuar = false;
            } else {
                System.out.println("La respuesta debe ser S o N ");
            }
        }

        System.out.println("El numero menor introducido es: " + menor);
        sc.close();
    }
}



