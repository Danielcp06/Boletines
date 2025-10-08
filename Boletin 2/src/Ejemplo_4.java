import java.util.Random;
import java.util.Scanner;

public class Ejemplo_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dime un numero del 1 al 100, tienes 5 intentos para averiguar mi numero");
        int num = sc.nextInt();
        while (num<1 || num>100){
            System.out.println("El numero tiene que ser del 1 al 100");
            num = sc.nextInt();
        }
        Random r = new Random();
        int numale = r.nextInt(100);
        int contador = 0;

        while(num != numale){
            if (num < numale){
                System.out.println("Tu numero es menor que el numero en el que ha pensado el ordenador");
            }else {
                if (num > numale) {
                    System.out.println("Tu numero es mayor que el numero en el que ha pensado el ordenador");
                }
            }
            num = sc.nextInt();
            contador++;
            if (contador == 4){
                break;
            }
        }

        if (contador == 4){
            System.out.println("Has gastado el numero de intentos. El numero era " + numale);
        }else{
            if(num == numale){
                System.out.println("Has acertado el numero");
            }
        }


    }
}