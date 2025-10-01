import java.util.Scanner;

public class Ejercicio_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dime un numero");
        int num = sc.nextInt();
        int contador = 0;
        while (num > 0){
            num = num/10;
            contador++;
        }
        System.out.println("Tu numero tiene " + contador + " cifras");

    }
}
