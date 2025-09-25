import java.util.Scanner;

public class Ejercicio_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dime numeros");
        int num = sc.nextInt();
        int contador = 0;
        while (num >= 0){
            System.out.println("Dime otro numero(Dime uno negativo para terminar)");
            contador++;
            num = sc.nextInt();
        }
        System.out.println("Has escrito tu numero " + contador + "  veces");
        sc.close();

    }
}
