import java.util.Scanner;

public class Ejercicio_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dime un numero base positivo");
        int numBase = sc.nextInt();
        while (numBase < 0){
            System.out.println("El numero tiene que ser positivo");
            numBase = sc.nextInt();
        }
        System.out.println("Dime ahora un exponente positivo");
        int numExp = sc.nextInt();
        while (numExp < 0){
            System.out.println("El numero tiene que ser positivo");
            numExp = sc.nextInt();
        }
       int potencia = 1;
        for (int i = 1; i <= numExp; i++) {
            potencia *= numBase;
        }
        System.out.println(potencia);


    sc.close();
    }
}
