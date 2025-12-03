package Boletin4_3.Ejercicio1;

import Boletin4_3.Ejercicio1.CartasException.CartaException;

public class Carta {
    private String palo;
    private int num;

    public Carta(int num, String palo) {
        this.num = num;
        this.palo = palo;
    }

    public String getPalo() {
        return palo;
    }

    public void setPalo(String palo) throws CartaException {
        if(!palo.equalsIgnoreCase("picas") && !palo.equalsIgnoreCase("corazones") && !palo.equalsIgnoreCase("treboles") && !palo.equalsIgnoreCase("diamantes")){
            throw new CartaException("Error: ese no es un palo de esta baraja este solo tiene: picas, corazones, diamantes y treboles");
        }
        this.palo = palo;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) throws CartaException {
        if (num < 1 || num > 12){
            throw new CartaException("Error: El numero de la carta van del 1 al 12");
        }
        this.num = num;
    }
}
