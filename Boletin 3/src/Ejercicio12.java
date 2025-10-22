import java.util.Arrays;

public class Ejercicio12 {
    static void main() {
        int[] array = {5, 3, 4, 45, 1, 432, 54, 22, 6, 2, 88, 42};

        int auxiliar;
        boolean cambios = false;

        while (true) { // ciclo infinito
            cambios = false; // entra el falso
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    auxiliar = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = auxiliar;
                    cambios = true;
                }
            }
            if (!cambios) {
                break;

            }
        }
        for (int j = 0; j < array.length; j++) {
            System.out.println(array[j]);
        }
    }
}
