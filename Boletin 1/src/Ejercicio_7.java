import java.util.Scanner;

public class Ejercicio_7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dime cuantos numeros me vas a decir");
        int num = sc.nextInt();
        while (num <= 1) {
            System.out.println("Tiene que ser un numero mayor que uno");
            num = sc.nextInt();
        }

        int suma = 0;
        for (int i = 0; i < num; i++) {
            System.out.printf("Introduce el número %d: ", i);
            suma += sc.nextInt();
        }

        System.out.println("La media es " + suma / num);
        sc.close();
    }

}
