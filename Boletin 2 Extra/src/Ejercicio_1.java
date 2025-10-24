import java.util.Scanner;

public class Ejercicio_1 {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dime un numero y te digo su inversa");
        int num = sc.nextInt();
        while (num < 0) {
            System.out.println("El numero tiene que ser positivo");
            num = sc.nextInt();
        }
        int invertido = 0;
        int resto;
        while (num > 0) {
            resto = num % 10;
            invertido = invertido * 10 + resto;
            num /= 10;
        }
        System.out.println("El numero invertido es " + invertido);
        sc.close();

    }

}
