public class Ejercicio9 {
    //Crea un metodo que compruebe si una matriz pasada por parámetro es simétrica en
    //función del eje X. Es decir, la matriz
    //1 3 5 6
    //4 2 0 8
    //4 2 0 8
    //1 3 5 6
    //es simétrica en función de su eje X, porque si invirtiésemos el orden en el que leemos las
    //filas, la matriz se vería igual.
    //Pero la matriz
    //1 4 6
    //2 1 3
    //no es simétrica, pues no cumple dicha propiedad.
    public static boolean simetrica(int[][] matriz){
        boolean igual = false;
        for (int i = 0; i <= matriz.length/2; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if(matriz[i][j] != matriz[matriz.length - 1 - i][j] ){
                   break;
                }
                igual = true;
                break;
            }
        }
        return igual;
    }

    static void main(String[] args) {
        int[][] matriz = {{2,3,4},{5,6,7},{5,6,7},{2,3,4}};
        if(simetrica(matriz)){
            System.out.println("Las matrices son simetricas");
        }else{
            System.out.println("Las matrices no son simetricas");
        }
    }

}
