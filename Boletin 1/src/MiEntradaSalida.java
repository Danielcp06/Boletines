import java.util.Scanner;

public class MiEntradaSalida {
    private static Scanner sc = new Scanner(System.in);

    /**
     * Lee un entero mostrando el mensaje pasado como parametro
     *
     * @param mensaje El mensaje a mostrar
     * @return el entero leido por teclado
     */


    public static int leerEntero(String mensaje) {
        System.out.println("Introduce un numero: ");
        return sc.nextInt();
    }

    public static int leerEnteroPositivo(String mensaje) {
        System.out.println(mensaje);
        int a = sc.nextInt();
        while (a <= 0) {
            System.out.println("El numero tiene q ser positivo");
            a = sc.nextInt();
        }
        return a;
    }

    public static void main(String[] args) {
        int a = MiEntradaSalida.leerEnteroPositivo("Introduce un numero");
        System.out.printf("El numero introducido es %d", a);
    }


}
