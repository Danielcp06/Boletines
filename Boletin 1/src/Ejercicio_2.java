import java.util.Scanner;

public class Ejercicio_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dime un numero para decirte la tabla de multiplicar(Del 1 al 10)");
        int numero = sc.nextInt();
        for (int i = 0; i <= 10; i++) {
            System.out.println(numero + "*" + i + "=" + numero * i);

        }

        sc.close();


    }
}
