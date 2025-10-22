public class Ejercicio1 {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6};
        int suma = 0;
        for (int i = 0; i < a.length; i += 2) {
            suma += a[i];
        }
        System.out.println("La suma de los pares es " + suma);

    }
}
