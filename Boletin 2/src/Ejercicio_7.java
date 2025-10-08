import java.util.Scanner;

public class Ejercicio_7 {
    /**
     * Realizar un programa que solicite dos números enteros mayores que 0, que
     * calcule el máximo común divisor entre ellos mediante el algoritmo de
     * Euclides y que muestre por pantalla el resultado.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dime dos numeros mayores a 0");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        while (num1 < 0 ){
            System.out.println("El primer numero introducido tiene que ser mayor a cero");
            num1 = sc.nextInt();
        }
        while (num2 < 0 ){
            System.out.println("El segundo numero introducido tiene que ser mayor a cero");
            num2 = sc.nextInt();
        }
        while (num2!=0){
            int temporal = num2;
            num2=num1%num2;
            num1=temporal;

        }
        System.out.println("El máximo común dividor es el "+ num1);
    }
}
