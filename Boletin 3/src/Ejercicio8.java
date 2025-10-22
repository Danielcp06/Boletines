import java.util.Scanner;

public class Ejercicio8 {
    public static int posicionArray(int buscar) {
        int[] numeros = {7, 4, 3, 1, 9, 5, 6, 8, 2, 10};

        boolean encontrado = false;

        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == buscar) {
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dime un numero para ver si esta en mi lista");
        int numero = sc.nextInt();
        int pos = posicionArray(numero);
        if(pos == -1){
            System.out.println("El numero no esta en mi lista");
        }else{
            System.out.printf("The number is on my list %d in the position", pos);
        }

    }
}