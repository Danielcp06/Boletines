import java.util.Scanner;

public class Ejercicio_8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dime el numero de la x^2");
        int numx2 = sc.nextInt();
        while (numx2 == 0) {
            System.out.println("El numero tiene que ser distinto de 0");
            numx2 = sc.nextInt();
        }
        System.out.println("Dime el numero de la x");
        int numx = sc.nextInt();
        while (numx == 0) {
            System.out.println("El numero tiene que ser distinto de 0");
            numx = sc.nextInt();
        }
        System.out.println("Dime un numero");
        int num = sc.nextInt();
        while (num == 0) {
            System.out.println("El numero tiene que ser distinto de 0");
            num = sc.nextInt();
        }
        System.out.println("Su ecuacion es: " + numx2 + "x^2 " + numx + "x " + num);
        int solucion = 0;
        solucion = num ^ 2 - 4 * numx2 * num;
        if (solucion > 0) {
            System.out.println("La ecuacion tiene 2 soluciones");
        } else if (solucion == 0) {
            System.out.println("La ecuacion tiene 1 solucion");
        } else {
            System.out.println("La ecuacion no tiene solucion");
        }
    }


}


