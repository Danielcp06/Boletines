package Examen2022;

import exceptions.ValorNoValidoException;

public class Escudo extends Cromos{
    private int añoFundacion;
    private int numJugadores;

    public Escudo(String identificador, String nombre, int añoFundacion, int numJugadores) {
        super(identificador, nombre);
        this.añoFundacion = añoFundacion;
        this.numJugadores = numJugadores;
    }


    public int getAñoFundacion() {
        return añoFundacion;
    }

    public int getNumJugadores() {
        return numJugadores;
    }

    public void setAñoFundacion(int añoFundacion) throws ValorNoValidoException {
        if(añoFundacion < 0){
            throw new ValorNoValidoException("El año no puede ser menor que 0");
        }
        this.añoFundacion = añoFundacion;
    }
}
