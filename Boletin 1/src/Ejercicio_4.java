import java.util.Scanner;

public class Ejercicio_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dime un numero");
        int numero = sc.nextInt();
        while (numero <= 0) {
            System.out.println("Tiene que ser un numero positivo");
            numero = sc.nextInt();
        }
        int suma = 0;
        for (int i = 1; i <= numero; i++) {
            suma += i;

        }
        System.out.println(suma);
        sc.close();
    }

}
