import java.util.Arrays;

public class Ejercicio11 {

    public static int[] elementosComunes(int[] array1, int[] array2) {
        // Crear un array temporal del tamaño del más pequeño
        int[] temporal = new int[Math.min(array1.length, array2.length)];
        int auxiliar = 0;

        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array2.length; j++) {
                if (array1[i] == array2[j]) {
                    // Verificar que no esté repetido en el resultado
                    boolean repetido = false;
                    for (int k = 0; k < auxiliar; k++) {
                        if (temporal[k] == array1[i]) {
                            repetido = true;
                            break;
                        }
                    }
                    if (!repetido) {
                        temporal[auxiliar++] = array1[i];
                    }
                }
            }
        }

        // Crear el array final con el tamaño exacto
        int[] resultado = new int[auxiliar];
        for (int i = 0; i < auxiliar; i++) {
            resultado[i] = temporal[i];
        }

        return resultado;
    }

    public static void main(String[] args) {
        int[] array1 = {0, 1, 1, 2, 0, 3, 4, 5, 3, 6, 6, 0, 7, 8, 8, 9, 11, 11, 11};
        int[] array2 = {1, 2, 2, 3, 1, 4, 5, 6, 4, 7, 7, 1, 8, 9, 9, 10, 10, 10, 10};

        int[] arraycomunes = elementosComunes(array1, array2);

        System.out.println("El primer array es " + Arrays.toString(array1));
        System.out.println("El segundo array es " + Arrays.toString(array2));
        System.out.println("Los elementos comunes sin repetir son: " + Arrays.toString(arraycomunes));
    }
}
