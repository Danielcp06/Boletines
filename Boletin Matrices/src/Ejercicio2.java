public class Ejercicio2 {
    //Crea un metodo que sume todas las posiciones de una matriz y devuelva dicho número.
    static void main(String[] args) {
        int matriz [][] = {{1,2,45},{1,5,3},{1,65,4}};

        System.out.println(sumaMatriz(matriz));
    }
    public static int sumaMatriz(int[][] matriz){
        int suma = 0;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                suma += matriz[i][j];
            }

        }
        return suma;
    }
}
