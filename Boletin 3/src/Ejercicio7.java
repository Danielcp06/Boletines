import java.util.Arrays;

public class Ejercicio7 {
    public static void main(String[] args) {
        int[] numeros = new int[MiEntradaSalida.generaAleatorio(10)];
        for (int i = 0; i < numeros.length; i++) {
            numeros[i]=MiEntradaSalida.generaAleatorio(numeros.length);
        }
        int consulta = MiEntradaSalida.leerEntero("Introduzca el numero que desea conocer si esta en la lista: ");
        if (contieneElemento(numeros, consulta)){
            System.out.println("En la lista "+ Arrays.toString(numeros)+" aparece el numero "+ consulta);
        }
        else
            System.out.println("En la lista "+ Arrays.toString(numeros)+" no aparece el numero "+ consulta);
    }
    public static boolean contieneElemento(int[] lista, int consulta){
        boolean contenido = false;
        for (int n : lista){
            if ( consulta == n){
                contenido = true;
                break;
            }
        }
        return contenido;
    }
}