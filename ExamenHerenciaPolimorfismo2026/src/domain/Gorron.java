package domain;

import exceptions.ValorNoValidoException;

public class Gorron extends Invitados{

    public Gorron(String nombre, int hambre, int aburrimiento) throws ValorNoValidoException {
        hambre = 90;
        super(nombre, hambre, aburrimiento);
    }


}
