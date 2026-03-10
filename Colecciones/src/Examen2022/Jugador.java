package Examen2022;

import exceptions.ValorNoValidoException;

public class Jugador extends Cromos{
    private String equipo;
    private int altura;

    public Jugador(String identificador, String nombre, String equipo, int altura) {
        super(identificador, nombre);
        this.equipo = equipo;
        this.altura = altura;
    }

    public String getEquipo() {
        return equipo;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) throws ValorNoValidoException {
        if(altura < 140 || altura > 210){
            throw new ValorNoValidoException("La altura introducida es incorrecta");
        }
        this.altura = altura;
    }
}
