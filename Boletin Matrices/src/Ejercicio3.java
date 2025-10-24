public class Ejercicio3 {
    //Crea un metodo que reciba una matriz e imprima, en una sola línea, los elementos de la
    //misma, leídos por filas:
    //1 3 5 --> La salida es: 1 3 5 0 2 7
    //0 2 7
    static void main(String[] args) {
        int matriz [][] = {{-7,2,1},{2,4,5}};

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }

        }

    }
}
