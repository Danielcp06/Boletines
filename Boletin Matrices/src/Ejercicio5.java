public class Ejercicio5 {
    //Crea un metodo que reciba una matriz e imprima, en una sola línea, los elementos de la
    //misma, pero leídos por columnas:
    //1 3 5 --> La salida es: 1 0 3 2 5 7
    //0 2 7
    static void main(String[] args) {
        int matriz [][] = {{-7,2,1},{3,4,5}};
        String nums = " ";

        for (int j = 0; j < matriz[0].length; j++) {
            for (int i = 0; i < matriz.length; i++) {
                nums += matriz[i][j] + " ";

            }

        }
        System.out.println(nums);

    }
}
