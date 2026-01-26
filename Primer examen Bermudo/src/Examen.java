import java.util.Scanner;

public class Examen {
    public static final int[][] MATRIZ = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {1, 2, 3, 4},
            {5, 6, 7, 8},
    };
    public static final String[][] MATRIZTAPADA = {
            {"?", "?", "?", "?"},
            {"?", "?", "?", "?"},
            {"?", "?", "?", "?"},
            {"?", "?", "?", "?"},
    };

    private static Scanner sc = new Scanner(System.in); //Escaner privado para protegerlo

    static void main(String[] args) {
        System.out.println("Bienvenido al juego de las parejas. Destapa todas las parejas en\n" +
                "menos de 6 intentos y gana!\n");
        recorrerMatriz(MATRIZ);
        int vidas = 6;
        int contadorVidas = 0;
        System.out.printf("Te quedan %d  \n", vidas);

        boolean jugando = true;
        while (jugando) {
            int fila1 = MiEntradaSalida.solicitarEnteroEnRango("Introduce la primera fila (del 0 al 3): ", 0, 3);
            int columna1 = MiEntradaSalida.solicitarEnteroEnRango("Dime la primera columna(del 0 al 3): ", 0, 3);

            int fila2 = MiEntradaSalida.solicitarEnteroEnRango("Introduce la segunda fila (del 0 al 3): ", 0, 3);
            int columna2 = MiEntradaSalida.solicitarEnteroEnRango("Dime la segunda columna(del 0 al 3): ", 0, 3);
            if (MATRIZ[fila1][columna1] == MATRIZ[fila2][columna2]) {
                System.out.println("Felicidades la pareja es correcta");

            } else{
                System.out.println("La pareja no es la correcta");
                contadorVidas = vidas - 1; //Restamos una vida si falla
            }
            if (contadorVidas == 0){
                System.out.println("Has perdido todas las vidas");
                jugando = false;
            }

        }
        System.out.println("Game over"); // Finaliza el juego

    }

    /*
     * Metodo para recorrer la matriz
     */
    public static void recorrerMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " "); //Imprimimos la matriz por pantalla
            }
            System.out.println();
        }

    }




}

