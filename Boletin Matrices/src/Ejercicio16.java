public class Ejercicio16 {
        // Crea un metodo que compruebe, sobre una matriz de enteros, cuántas casillas
        //adyacentes tienen valores pares. Se considera adyacente todas las posiciones
        //colindantes, incluidas las diagonales. En el siguiente ejemplo, el 7 (en rojo) tiene 4
        //casillas colindantes con números pares. El resultado se deberá guardar en otra matriz,
        //que contendrá dichos números. Para este ejercicio, consideraremos que el 0 es par.
        //1 2 3 4 5 1 2 3 2 2
        //6 7 8 9 0 2 4 4 4 2
        //3 2 1 4 5 → 2 3 5 4 3
        //9 5 8 6 7 2 4 4 4 3
        //0 9 8 5 4 0 3 2 4 1

        public static int[][] contarParesPegados(int[][] matriz) {

            int[][] resultado = new int[matriz.length][matriz[0].length];

            int[] dirrx = {-1, -1, -1, 0, 0, 1, 1, 1};
            int[] dirry = {-1, 0, 1, -1, 1, -1, 0, 1};

            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[0].length; j++) {
                    int contadorPares = 0;

                    for (int k = 0; k < 8; k++) {
                        int nuevoX = i + dirrx[k];
                        int nuevoY = j + dirry[k];

                        // Verificar si el vecino está dentro de los límites de la matriz
                        if (nuevoX >= 0 && nuevoX < matriz.length && nuevoY >= 0 && nuevoY < matriz[0].length) {
                            if (matriz[nuevoX][nuevoY] % 2 == 0) {
                                contadorPares++;
                            }
                        }
                    }

                    resultado[i][j] = contadorPares;
                }
            }

            return resultado;
        }
        public static void main(String[] args) {
            int[][] matriz = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

            int[][] resultado = contarParesPegados(matriz);

            // Imprimir la matriz resultado
            for (int i = 0; i < resultado.length; i++) {
                for (int j = 0; j < resultado[i].length; j++) {
                    System.out.print(resultado[i][j] + " ");
                }
                System.out.println();
            }
        }

}
