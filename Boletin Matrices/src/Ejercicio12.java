public class Ejercicio12 {
        // Crea un metodo que transforme una matriz CUADRADA (tienes que realizar dicha
        //comprobación) que recibe por parámetro, en otra, que debe ser su reflejo en diagonal (de
        //arriba a la izquierda a abajo a la derecha):
        //1 2 3 4 5 1 6 3 9 0
        //6 7 8 9 0 2 7 2 5 9
        //3 2 1 4 5 --> 3 8 1 8 8
        //9 5 8 6 7 4 9 4 6 5
        //0 9 8 5 4 5 0 5 7 4
        public static boolean matrizCuadradaTranspuesta(int[][] matriz) {
            if (matriz.length != matriz[0].length) {
                return false;
            }

            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[0].length; j++) {
                    System.out.print(matriz[j][i] + " ");
                }
                System.out.println();
            }
            return true;
        }
        public static void main(String[] args) {
            int[][] matriz1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
            int[][] matriz2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

            System.out.println("Matriz 1 transpuesta:");
            if (!matrizCuadradaTranspuesta(matriz1)) {
                System.out.println("La matriz no es cuadrada.");
            }

            System.out.println("Matriz 2 transpuesta:");
            if (!matrizCuadradaTranspuesta(matriz2)) {
                System.out.println("La matriz no es cuadrada.");
            }
        }
}

