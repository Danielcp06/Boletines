package Boletin4_2.Ejercicio2;

/*
Vamos a representar un ordenador mediante clases. Dicho ordenador estará
compuesto de diferentes clases:
a. Una placa base, que tiene:
        i. Una marca, cadena
        ii. Un chipset, cadena
        iii. Un socket, cadena
b. Un microprocesador, que tiene
        i. Una marca, cadena
        ii. Un modelo, cadena
        iii. Un número de núcleos, entero
        iv. Velocidad base (en GHz), float
        v. Un socket, cadena
c. Un disco duro, que tiene:
        i. Una marca, cadena
        ii. Tipo, que puede ser SSD o HD, cadena
        iii. Capacidad (en GB), entero
d. Tarjeta gráfica, que tiene:
        i. Una marca, cadena
        ii. Un modelo, cadena
        iii. Número de núcleos, entero
        iv. Velocidad (en GHz), float
        v. Cantidad de memoria (en GB), entero
Una placa base sólo será compatible con aquellos procesadores que tengan el
mismo Socket. La placa deberá contar con un metodo que indique si un procesador
es o no compatible con la misma.
Una vez montado, el equipo debe ser imprimible por pantalla, indicando todos los
datos de los componentes de los que está compuesto.
En caso de errores (de compatibilidad, de entrada, etc.) deben lanzarse y capturarse
las excepciones oportunas.
*/


import Boletin4_2.Ejercicio2.OrdenadorException.OrdenadorExceciones;




public class Principal {
    public static void main(String[] args) throws InterruptedException {
        DiscoDuro discoDuro = null;
        MicroProcesador microprocesador = null;
        PlacaBase placaBase = null;
        TarjetaGrafica tarjetaGrafica = null;

        System.out.println("¡Bienvenido al commprobador de piezas para tu nuevo ordenador!\n");
        System.out.println("Vamos a empezar con la Placa Base.");
        placaBase = crearPlacaBase();
        System.out.println("¡Muy bien! Ahora vamos con el Microprocesador. \n");
        microprocesador = crearMicroProcesador();
        System.out.println("¡Genial! Vamos ahora con la tarjeta gráfica. \n");
        tarjetaGrafica = crearTarjetaGrafica();
        System.out.println("¡Perfecto! Vamos con lo ultimo, el disco duro. \n");
        discoDuro = crearDiscoDuro();
        System.out.println("Vamos a hacer las comprobaciones necesarias. Espera un momento porfavor. \n");
        comprobar();
        try {
            placaBase.setMicroprocesador(microprocesador);
            System.out.println("\nTu ordenador esta listo. Asi ha quedado:");
            placaBase.componentes();
            System.out.println();
            microprocesador.componentes();
            System.out.println();
            tarjetaGrafica.componentes();
            System.out.println();
            discoDuro.componentes();

        } catch (OrdenadorExceciones e) {
            System.out.println(e.getMessage());
        }

    }


    public static PlacaBase crearPlacaBase(){
        String marca = MiEntradaSalida.MiEntradaSalida.leerLinea("Introduce la marca: \n");
        String chipset = MiEntradaSalida.MiEntradaSalida.leerLinea("Introduce el chipset: \n");
        String socket = MiEntradaSalida.MiEntradaSalida.leerLinea("Introduce el socket: \n");
        return new PlacaBase(marca,chipset,socket);
    }

    public static MicroProcesador crearMicroProcesador(){
        String marca = MiEntradaSalida.MiEntradaSalida.leerLinea("Introduce la marca: \n");
        String modelo = MiEntradaSalida.MiEntradaSalida.leerLinea("Introduce el modelo: \n");
        int numNucleos = MiEntradaSalida.MiEntradaSalida.leerEnteroPositivo("Introduce el numero de nucleos: ", false);
        float velBase = MiEntradaSalida.MiEntradaSalida.leerFloat("Introduce la velocidad base: ");
        String socket = MiEntradaSalida.MiEntradaSalida.leerLinea("Introduce el socket: \n");
        return new MicroProcesador(marca,modelo,numNucleos,velBase,socket);
    }

    public static TarjetaGrafica crearTarjetaGrafica(){
        String marca = MiEntradaSalida.MiEntradaSalida.leerLinea("Introduce la marca: \n");
        String modelo = MiEntradaSalida.MiEntradaSalida.leerLinea("Introduce el modelo: \n");
        int numNucleos = MiEntradaSalida.MiEntradaSalida.leerEnteroPositivo("Introduce el numero de nucleos: ",false);
        float velocidad = MiEntradaSalida.MiEntradaSalida.leerFloat("Introduce la velocidad: ");
        int capacidad = MiEntradaSalida.MiEntradaSalida.leerEntero("Introduce la capacidad en GB: ");
        return new TarjetaGrafica(marca,modelo,numNucleos,velocidad,capacidad);
    }

    public static DiscoDuro crearDiscoDuro(){
        String marca = MiEntradaSalida.MiEntradaSalida.leerLinea("Introduce la marca: \n");
        String tipo = MiEntradaSalida.MiEntradaSalida.leerLinea("Introduce el tipo: \n");
        int capacidad = MiEntradaSalida.MiEntradaSalida.leerEnteroPositivo("Introduce la capacidad del disco duro: ",false);
        return new DiscoDuro(marca,tipo,capacidad);
    }

    public static void comprobar() throws InterruptedException {
        int total = 50; // ancho de la barra

        for (int i = 0; i <= total; i++) {
            int porcentaje = (i * 100) / total;

            // Construir la barra con '=' para el progreso
            String barra = "[" +
                    "=".repeat(Math.max(0, i)) +
                    " ".repeat(Math.max(0, total - i)) +
                    "]";

            // Mostrar barra con porcentaje, usando \r para sobrescribir línea
            System.out.print("\r" + barra + " " + porcentaje + "%");

            Thread.sleep(100); // Simula tarea que toma tiempo
        }

        System.out.println("\nCarga completada.");

    }

}

