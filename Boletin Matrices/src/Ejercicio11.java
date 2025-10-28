public class Ejercicio11 {
    // Crea un metodo que reciba dos matrices, y compruebe si son matrices inversas, es decir,
    //si tienen los mismos valores en los índices inversos:
    //5 8 9 0 2 3 7 1
    //4 7 5 2 y 2 5 7 4
    //1 7 3 2 0 9 8 5
    public static boolean comparacionMatrices(int matriz1[][], int matriz2[][]) {
        boolean igual = false;
        String stringMatriz1 = " ";
        String stringMatriz2 = " ";
        for (int i = 0; i < matriz1.length; i++) {
            for (int j = 0; j < matriz1[i].length; j++) {
                stringMatriz1 += matriz1[i][j] + " ";
            }
        }
        for (int i = 0; i < matriz2.length; i++) {
            for (int j = 0; j < matriz2[i].length; j++) {
                stringMatriz2 += matriz2[matriz2.length - 1 - i][matriz2[i].length - 1 - j] + " ";
            }
        }
        return stringMatriz1.equals(stringMatriz2);
    }

    static void main(String[] args) {
        int matriz1[][] = {{-7, 2, 1}, {3, 4, 5}};
        int matriz2[][] = {{5, 4, 3}, {1, 2, -7}};
        System.out.print(comparacionMatrices(matriz1, matriz2));
    }
}
