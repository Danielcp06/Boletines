import java.util.Scanner;

public class Ejercicio_2 {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dime un numero y te digo su inversa");
        int num = sc.nextInt();
        int num2 = num;
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
        if (num2 == invertido) {
            System.out.println("El numero es capicua");
        } else {
            System.out.println("El numero no es capicua");
        }
        sc.close();

    }
}
