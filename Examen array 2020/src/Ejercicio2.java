public class Ejercicio2 {
    final static int[][] JARDIN = {
            {1, 0, 0, 0, 1, 0, 0, 0, 2, 1, 1, 0, 0, 5, 0},
            {0, 2, 0, 5, 0, 0, 3, 0, 1, 0, 0, 0, 1, 0, 0},
            {3, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 2, 4},
            {0, 0, 2, 0, 0, 0, 0, 0, 2, 1, 3, 0, 0, 0, 1},
            {0, 0, 1, 0, 0, 0, 3, 0, 1, 0, 0, 0, 0, 0, 3},
            {4, 3, 0, 0, 0, 2, 1, 0, 0, 0, 0, 5, 0, 0, 0},
            {1, 2, 0, 5, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 2},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1},
            {3, 0, 0, 0, 0, 0, 2, 1, 4, 0, 0, 0, 1, 0, 0},
            {2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 3, 0},
            {0, 0, 5, 1, 0, 0, 0, 5, 0, 3, 0, 0, 1, 0, 0},
            {1, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 5, 2, 4, 0},
            {0, 0, 1, 3, 0, 0, 1, 0, 0, 1, 0, 0, 1, 3, 0},
            {0, 1, 2, 1, 0, 0, 0, 0, 0, 2, 3, 1, 0, 0, 1},
            {1, 3, 4, 0, 0, 5, 0, 0, 1, 0, 0, 0, 0, 4, 2}
    };
    public static final int SEMILLA = 1;
    public static final int AGUA = 2;
    public static final int MALAHIERVA = 3;
    public static final int GUSANO = 4;
    public static final int ABEJA = 5;


    static void main(String[] args) {
        recorerJardin(JARDIN);

    }
    public static void recorerJardin (int[][] jardin){
        for (int i = 0; i < jardin.length; i++) {
            for (int j = 0; j < jardin[i].length; j++) {
                if (jardin[i][j] == SEMILLA && florece(jardin, i, j)){
                    System.out.printf("La flor de la posición %d,%d florecerá\n", i, j);
                }
            }
        }

    }

    public static boolean florece(int[][] jardin, int fila, int columna){
        if (hayAgua(jardin, fila, columna) && hayaAbeja(jardin, fila, columna) && (!hayMalaHierva(jardin, fila, columna) || hayMalaHierva(jardin, fila, columna) && hayGusano(jardin, fila, columna))){
            return true;
        }
        else{
            return false;
        }

    }

    public static boolean hayAgua(int[][] matriz, int fila, int columna) {
        for (int i = fila - 1; i <= fila + 1 ; i++) {
            for (int j = columna - 1; j <= columna + 1 ; j++) {
                if (i == fila && j == columna) continue;
                if (i >= 0 && i < matriz.length && j >= 0 && j < matriz[0].length) {
                    if (matriz[i][j] == AGUA) return true;
                }

            }

        }
        return false;
    }
    public static boolean hayMalaHierva(int[][] matriz, int fila, int columna) {
        for (int i = fila - 1; i <= fila + 1 ; i++) {
            for (int j = columna - 1; j <= columna + 1 ; j++) {
                if (i == fila && j == columna) continue;
                if (i >= 0 && i < matriz.length && j >= 0 && j < matriz[0].length) {
                    if (matriz[i][j] == MALAHIERVA) return true;
                }

            }

        }
        return false;
    }
    public static boolean hayGusano(int[][] matriz, int fila, int columna) {
        for (int i = fila - 1; i <= fila + 1 ; i++) {
            for (int j = columna - 1; j <= columna + 1 ; j++) {
                if (i == fila && j == columna) continue;
                if (i >= 0 && i < matriz.length && j >= 0 && j < matriz[0].length) {
                    if (matriz[i][j] == GUSANO) return true;
                }

            }

        }
        return false;
    }
    public static boolean hayaAbeja(int[][] matriz, int fila, int columna) {
        for (int i = fila - 3; i <= fila + 3 ; i++) {
            for (int j = columna - 3; j <= columna + 3 ; j++) {
                if (i == fila && j == columna) continue;
                if (i >= 0 && i < matriz.length && j >= 0 && j < matriz[0].length) {
                    if (matriz[i][j] == ABEJA) return true;
                }

            }

        }
        return false;
    }



}
