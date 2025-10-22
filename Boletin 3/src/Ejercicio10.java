import java.util.Arrays;

public class Ejercicio10 {

    public static void main(String[] args) {

        int[] array = {0, 1, 1, 2, 0, 3, 4, 5, 3, 6, 6, 0, 7, 8, 8, 9, 11, 11, 11};

        System.out.println("el array es " + Arrays.toString(array));

        System.out.println("el array sin duplicados es " + Arrays.toString(eliminaDuplicados(array)));
    }

    private static int[] eliminaDuplicados(int[] array) {
        int[] arraySinDuplicados = new int[array.length];

        int posArraySinDuplicados = 0;

        boolean heTratadoElCero = false;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0 && !heTratadoElCero) {
                posArraySinDuplicados++;
                heTratadoElCero = true;
                continue;
            }
            if (!contieneElemento(arraySinDuplicados, array[i])) {
                arraySinDuplicados[posArraySinDuplicados++] = array[i];
            }
        }

        arraySinDuplicados = Arrays.copyOf(arraySinDuplicados, posArraySinDuplicados);

        return arraySinDuplicados;
    }

    private static boolean contieneElemento(int[] array, int elemento) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == elemento) {
                return true;
            }
        }
        return false;
    }
}