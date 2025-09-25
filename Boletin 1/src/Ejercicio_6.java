import java.util.Scanner;

public class Ejercicio_6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dime un numero");
        int numero1 = sc.nextInt();
        System.out.println("Dime otro numero");
        int numero2 = sc.nextInt();
        int calc = 0;

        for (int i = 0; i < numero2; i++) {
            calc += numero1;
        }

        System.out.println(calc);

    }
}
