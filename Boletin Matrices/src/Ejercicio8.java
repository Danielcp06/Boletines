public class Ejercicio8 {
    //Crea un metodo que reciba dos matrices, que deben ser de igual tamaño, y sume el
    //contenido de las posiciones en una tercera matriz, que será la que devuelva:
    //| 1 2| + | 4 1| = | 5 3|
    //| 4 6| | 1 0| | 5 6|
    public static int[][] sumaMatrices(int[][] matriz1, int[][] matriz2) {
        int matriz3[][] = new int[matriz1.length][matriz2[0].length];
        if (Ejercicio7.comparacionMatrices(matriz1, matriz2)) {

            for (int i = 0; i < matriz1.length; i++) {
                for (int j = 0; j < matriz1[i].length; j++) {
                    matriz3[i][j] += matriz1[i][j] + matriz2[i][j];
                }
            }
        }

        return matriz3;
    }
    public static String escribirMatriz(int[][] matriz){

        return "";
    }

    static void main(String[] args) {
        int matriz1[][] = {{7, 2, 1}, {3, 4, 5}};
        int matriz2[][] = {{7, 2, 1}, {3, 4, 5}};
        System.out.println(sumaMatrices(matriz1, matriz2));
    }
}
