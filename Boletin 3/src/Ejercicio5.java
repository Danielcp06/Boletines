import java.util.Arrays;

public class Ejercicio5 {
    public static void main(String[] args) {
        int size = MiEntradaSalida.leerEnteroPositivo("Introduce el tamaño de tu lista: ", false);
        System.out.println(Arrays.toString(crearArrays(size)));
    }

    public static int[] crearArrays(int size) {
        int[] numeros = new int[size];
        for (int i = 0; i < size; i++) {
            numeros[i] = MiEntradaSalida.generaAleatorioEntre(0, 1000, true);
        }
        return numeros;
    }
}