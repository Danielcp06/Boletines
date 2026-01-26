public class Principal {
    static void main() {
//        reto1_IndicesExplosivos();
//        reto2_ElObjetoCorrupto();
        reto3_ModificacionEnVivo();
    }

    public static void reto1_IndicesExplosivos() {
        int[] datos = {10, 20, 30, 40, 50};
        int suma = 0;

        for (int i = 0; i < datos.length; i++) {
            System.out.println("Procesando índice " + i);
            suma += datos[i];
        }
        System.out.println("Total: " + suma);
    }


    public static void reto2_ElObjetoCorrupto() {
        for (int i = 0; i < 1000; i++) {
            double valor = Math.random() * 100;


            if (i == 856) {
                System.out.println("Iteración crítica alcanzada...");
                // Aquí ocurriría el bug
            }
        }
    }

    /**
     * RETO 3: Alteración de Memoria (Criterio e)
     * Instrucciones: Pon un breakpoint en el primer IF.
     * En la pestaña Variables, cambia 'permisoAdmin' a true antes de que siga.
     */
    public static void reto3_ModificacionEnVivo() {
        boolean permisoAdmin = false;
        String usuario = "Alumno_Base";

        System.out.println("Login como: " + usuario);

        if (permisoAdmin) {
            System.out.println("¡ATENCIÓN! Acceso a funciones secretas desbloqueado.");
        } else {
            System.out.println("Error: No tienes permisos suficientes.");
        }
    }
}