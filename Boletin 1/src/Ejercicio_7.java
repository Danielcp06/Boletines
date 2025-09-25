import java.util.Scanner;

public class Ejercicio_7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dime cuantos numeros me vas a decir");
        int num = sc.nextInt();
        while (num <= 1) {
            System.out.println("Tiene que ser un numero positivo");
            num = sc.nextInt();
        }


    }
}
