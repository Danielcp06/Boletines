public class Ejercicio7 {
    //Crea un metodo que reciba dos matrices, y compruebe si son exactamente iguales.
    public static boolean comparacionMatrices(int matriz1[][], int matriz2[][]) {
        boolean iguales = false;
        String stringMatriz1 = " ";
        String stringMatriz2 = " ";
        for (int i = 0; i < matriz1.length; i++) {
            for (int j = 0; j < matriz1[i].length; j++) {
                stringMatriz1 += matriz1[i][j] + " ";
            }
        }
        for (int i = 0; i < matriz2.length; i++) {
            for (int j = 0; j < matriz2[i].length; j++) {
                stringMatriz2 += matriz2[i][j] + " ";
            }
        }
        return stringMatriz1.equals(stringMatriz2);
    }

    static void main(String[] args) {
        int matriz1[][] = {{-7, 2, 1}, {3, 4, 5}};
        int matriz2[][] = {{-7, 2, 1}, {3, 4, 5}};
        System.out.print(comparacionMatrices(matriz1, matriz2));
    }
}
