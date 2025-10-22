import java.util.Arrays;

public class Ejercicio3 {
    public static void main(String[] args) {
        int cant = MiEntradaSalida.leerEnteroPositivo("Introduce cuantos numeros va a introducir en la lista: ", false);
        int[] numeros = new int[cant];
        double media;
        double suma = 0;
        int mayor = Integer.MIN_VALUE;
        int menor = Integer.MAX_VALUE;
        int temporal;
        int cantMayor=0;
        int cantMenor=0;
        //Rellenar el array
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = MiEntradaSalida.leerEntero("Introduce tu " + (i + 1) + "º número: ");
        }
        //Comprobar el mayor y el menor
        for (int numero : numeros) {
            temporal=numero;
            if (temporal>mayor ){
                mayor=temporal;
            }
            else if (temporal<menor){
                menor=temporal;
            }

        }
        //Sumar la cantidad de veces que aparece el mayor o el menor
        for (int n1 : numeros){

            if (n1==mayor){
                cantMayor++;
            }
            else if (n1==menor){
                cantMenor++;
            }
        }
        //Hacer la suma para la media
        for (int numero : numeros) {
            suma += numero;
        }
        media = suma / numeros.length;
        System.out.println("El número mayor de la lista es el "+mayor+" y aparece "+cantMayor+" veces");
        System.out.println("El número menor de la lista es el "+menor+" y aparece "+cantMenor+" veces");
        System.out.println("La media es " + media);
    }
}