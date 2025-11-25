package Boletin4_1.Ejercicio3;

/*
Realizar una programa en Java que sirva para simular una máquina de café.
La máquina tiene varios depósitos:
 Un depósito de café con capacidad para 50 dosis.
 Un depósito de leche con capacidad para 50 dosis.
 Un depósito de vasos con capacidad para 80 vasos.
También dispone de monedero con una cantidad de euros. Cuando se cree una
nueva máquina se hará con un monedero inicial y con los depósitos llenos. El café
cuesta 1 euro, la leche 0.8 euros y el café con leche 1.5 euros. Al servir cada
bebida debe descontarse una dosis de los depósitos correspondientes, un vaso y
añadir al monedero lo recaudado.
Debe implementarse un menú con 5 opciones:
1. Servir café solo (1 euro)
2. Servir leche (0,8 euros)
3. Servir café con leche (1,5 euros)
4. Consultar estado máquina. Aparecen los datos de los depósitos y
del monedero
5. Apagar máquina y salir
Cuando se sirva una bebida habrá que solicitar el dinero que va a introducir el
usuario. Si introduce una cantidad inferior al precio o no hay existencias debe
informarse con el error correspondiente. También debe producirse un error si la
máquina no tiene cambio de esa cantidad. Si puede dar cambio informará con el
mensaje “Recoge tu cambio de XX euros”.
La clase Maquina debe disponer al menos de los siguientes métodos.
 Metodo para llenar depósitos. No pueden llenarse los depósitos por
separado.
 Metodo para vaciar monedero.
 Metodo para consultar el estado de la máquina.
 Metodo para servir café sólo, leche o café con leche. Este metodo mostrará
los mensajes de error correspondientes o el mensaje "Producto servido".
*/

import Boletin4_1.Ejercicio3.Exception.MiException;

public class Maquina {
    private static final int MAXIMOCAFE = 50;
    private static final int MAXIMOLECHE = 50;
    private static final int MAXIMOVASOS = 80;

    public static final double PRECIO_CAFE = 1;
    public static final double PRECIO_LECHE = 0.8;
    public static final double PRECIO_CAFE_LECHE = 1.5;

    private int dosisCafeRestantes;
    private int dosisLecheRestantes;
    private int vasosRestantes;
    private double monedero;

    public Maquina(double monedero) throws MiException {
        this.dosisCafeRestantes = MAXIMOCAFE;
        this.dosisLecheRestantes = MAXIMOLECHE;
        this.vasosRestantes = MAXIMOVASOS;
        setMonedero(monedero);
    }

    public int getDosisCafeRestantes() {
        return dosisCafeRestantes;
    }

    private void setDosisCafeRestantes(int dosisCafeRestantes) {
        this.dosisCafeRestantes = dosisCafeRestantes;
    }

    public int getDosisLecheRestantes() {
        return dosisLecheRestantes;
    }

    private void setDosisLecheRestantes(int dosisLecheRestantes) {
        this.dosisLecheRestantes = dosisLecheRestantes;
    }

    public int getVasosRestantes() {
        return vasosRestantes;
    }

    private void setVasosRestantes(int vasosRestantes) {
        this.vasosRestantes = vasosRestantes;
    }

    public double getMonedero() {
        return monedero;
    }

    private void setMonedero(double monedero) throws MiException {
        if (monedero < 0){
            throw new MiException("No puedes poner cantidades negativas en el monedero");
        }
        this.monedero = monedero;
    }

    public double servirCafe(double dineroIntroducido) throws MiException {
        double cambio = comprobarCambio(dineroIntroducido, PRECIO_CAFE);
        if(dosisCafeRestantes == 0 || vasosRestantes == 0){
            throw new MiException("No podemos darle su pedido");
        }

        monedero += PRECIO_CAFE;
        vasosRestantes --;
        dosisCafeRestantes --;

        return cambio;
    }

    public double servirLeche(double dineroIntroducido) throws MiException {
        double cambio = comprobarCambio(dineroIntroducido, PRECIO_LECHE);
        if(dosisLecheRestantes == 0 || vasosRestantes == 0){
            throw new MiException("No podemos darle su pedido");
        }

        monedero += PRECIO_LECHE;
        vasosRestantes --;
        dosisLecheRestantes --;

        return cambio;
    }

    public double servirCafeLeche(double dineroIntroducido) throws MiException {
        double cambio = comprobarCambio(dineroIntroducido, PRECIO_CAFE_LECHE);
        if(dosisLecheRestantes == 0 || vasosRestantes == 0 || dosisCafeRestantes == 0){
            throw new MiException("No podemos darle su pedido");
        }

        monedero += PRECIO_CAFE_LECHE;
        vasosRestantes --;
        dosisLecheRestantes --;
        dosisCafeRestantes --;

        return cambio;
    }

    public String estadoMaquina() {
        return toString();
    }

    @Override
    public String toString() {
        return "Cafetera:\n" +
                "quedan " + dosisCafeRestantes + " de cafe" +
                ", de leche " + dosisLecheRestantes +
                ", " + vasosRestantes + " vasos " +
                "y " + monedero + "€";
    }

    private double comprobarCambio(double dineroIntroducido, double precioProducto) throws MiException {
        if(dineroIntroducido < precioProducto){
            throw new MiException("No has introducido la suficiente cantidad de dinero");
        }

        if (dineroIntroducido - precioProducto > monedero){
            throw new MiException("No hay suficiente dinero en la maquina para darte el cambio");
        }

        return dineroIntroducido - precioProducto;
    }
}
