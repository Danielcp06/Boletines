public class Ejercicio1 {
    //Crea un metodo que compruebe si en una matriz hay algún valor negativo, y devuelva un
    //valor booleano.
    static void main(String[] args) {
        //Creamos la matriz y le damos valor
        int a[][] = {{2,4,-6,7,-1},{12,4,7,8,0},{-3,5,1,6,8},{12,-34,2,7,5}};


        boolean resultado = false;

        //recorremos la matriz por filas
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (a[i][j] < 0) {
                    resultado = true;
                    break;
                }
                if (resultado){
                    break;
                }

            }

        }


        System.out.println(resultado);



    }
}
