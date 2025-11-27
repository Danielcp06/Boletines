package Boletin4_2.Ejercicio5;

public class Main {
    public static void main(String[] args) {
        boolean activo = true;
        Linea[] lineas = new Linea[3];
        int contador = 0;
        System.out.println("Opciones:\n" +
                "Mover en el eje X \n" +
                "Mover en en eje Y \n" +
                "Comparar lineas \n" +
                "Crear linea \n" +
                "Salir\n");

        while (activo) {

            int linea;
            double distancia;
            String comando = MiEntradaSalida.MiEntradaSalida.leerLinea("¿Que desea hacer?\n");
            switch (comando.toLowerCase()) {
                case "mover en el ejex":
                    if (hayLineasCreadas(lineas)) {
                        MiEntradaSalida.MiEntradaSalida.mostrarOpcionesSinNulos("Opciones: \n",lineas);
                        linea=pedirLinea(lineas);
                        distancia = MiEntradaSalida.MiEntradaSalida.leerDouble("¿Cuanto lo quieres mover?");
                        lineas[linea].moverEjeX(distancia);
                        break;
                    } else {
                        System.out.println("No hay lineas creadas.\n");
                        break;
                    }
                case "mover en el ejey":
                    if (hayLineasCreadas(lineas)) {
                        MiEntradaSalida.MiEntradaSalida.mostrarOpcionesSinNulos("Opciones: \n",lineas);
                        linea=pedirLinea(lineas);
                        distancia = MiEntradaSalida.MiEntradaSalida.leerDouble("¿Cuanto lo quieres mover?");
                        lineas[linea].moverEjeY(distancia);
                        break;
                    } else {
                        System.out.println("No hay lineas creadas.\n");
                        break;
                    }
                case "crear linea":
                    int cantidad;
                    try {
                        cantidad = MiEntradaSalida.MiEntradaSalida.leerEnteroRango("¿Cuantas lineas quieres crear?", 1, lineas.length);
                        for (int i = 0; i < cantidad; i++) {
                            if (contador<lineas.length){
                                if (lineas[i] == null) {
                                    lineas[i] = crearLinea(i+1);
                                    contador++;
                                } else if (lineas[i] != null) {
                                    cantidad++;
                                }
                            } else {
                                System.out.println("No puedes crear mas lineas.\n");
                            }
                        }
                    } catch (MiEntradaSalida.MiEntradaSalidaException e) {
                        System.out.println(e.getMessage());
                    }
                case "comparar lineas":
                    if (contarLineasCreadas(lineas) >= 2) {
                        int pedirLinea1 = pedirLinea(lineas);
                        int pedirLinea2 = pedirLinea(lineas);
                        if (lineas[pedirLinea1].equals(lineas[pedirLinea2])) {
                            System.out.println("Las lineas son iguales.\n");
                            break;
                        } else {
                            System.out.println("Las lineas no son iguales\n");
                            break;
                        }
                    }
                    else {
                        System.out.println("No hay suficientes lineas");
                        break;
                    }
                case "salir":
                    activo = false;
                    break;
                default:
                    System.out.println("Opciones:\n" +
                            "Mover en el ejeX \n" +
                            "Mover en en ejeY \n" +
                            "Comparar lineas \n" +
                            "Crear linea \n" +
                            "Salir\n");
                    break;
            }
        }
    }
    public static Punto crearPunto(String mensaje) {
        System.out.println(mensaje);
        int x = MiEntradaSalida.MiEntradaSalida.leerEntero("Introduzca la coordenada x: ");
        int y = MiEntradaSalida.MiEntradaSalida.leerEntero("Introduzca la coordenada y: ");
        return new Punto(x, y);
    }

    public static Linea crearLinea(int indice) {
        System.out.println("\nLinea numero "+indice);
        Punto puntoA = crearPunto("Punto A");
        Punto puntoB = crearPunto("Punto B");
        return new Linea(puntoA, puntoB);
    }

    public static boolean hayLineasCreadas(Linea[] lineas) {
        for (int i = 0; i < lineas.length; i++) {
            if (lineas[i] != null) {
                return true;
            }

        }
        return false;
    }

    public static int pedirLinea(Linea[] lineas) {
        try {
            int linea = MiEntradaSalida.MiEntradaSalida.leerEnteroRango("¿Que linea quieres usar? (Introduce el numero): ", 1, lineas.length) - 1;
            return linea;
        } catch (MiEntradaSalida.MiEntradaSalidaException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    public static int contarLineasCreadas(Linea[] lineas) {
        int contador = 0;
        for (int i = 0; i < lineas.length; i++) {
            if (lineas[i] != null) {
                contador++;
            }
        }
        return contador;
    }
}