public class Ejercicio4 {
    //Crea un metodo que reciba una matriz e imprima, en una sola línea, los elementos de la
    //misma, leídos por filas, empezando por los últimos índices:
    //1 3 5 --> La salida es: 7 2 0 5 3 1
    //0 2 7
    static void main(String[] args) {
        int matriz [][] = {{-7,2,1},{2,4,5}};

        for (int i = matriz.length - 1; i >= 0 ; i--) {
            for (int j = matriz[i].length - 1; j >= 0 ; j--) {
                System.out.print(matriz[i][j] + " ");
            }

        }

    }
}
