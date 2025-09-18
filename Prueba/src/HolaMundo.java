import java.util.Scanner;

public class HolaMundo {
    public static void main(String[] args) {
        System.out.println("Introduce tu nombre");

        Scanner sc = new Scanner(System.in);

        String nombre = sc.nextLine();

        System.out.println("Hola " + nombre);
    }
}