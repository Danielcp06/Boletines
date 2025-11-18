package Ejercicio2;

public class Cuenta {

    public static String[] textoOpciones = {
       "Tienes la opcion de mirar cuenta, ingresar dinero o retirar dinero"
    };

    public static int verOpciones = 0;

    public static void elegirOpciones(String opcion){
        while(haciendoTransferencias){
            switch (opcion.toLowerCase()){
                case "ingresar":
                   break;
                case "retirar":
                    break;
                case "mirar cuenta":

                    break;
                case "salir":
                    haciendoTransferencias = false;
                    break;
            }
        }
        System.out.println("Secion cerrada");
        return ;
    }

    private static boolean haciendoTransferencias = true;

    private static int ingresar;
}

