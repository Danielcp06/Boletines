package domain;

import exceptions.ValorNoValidoException;

public class Colega extends Invitados implements Regalable{

    public Colega(String nombre, int hambre, int aburrimiento) throws ValorNoValidoException {
        if(hambre < 50 || hambre > 70){
            throw new ValorNoValidoException("Los valores del hambre no estan bien");
        }
        super(nombre, hambre, aburrimiento);
    }


    @Override
    public Regalo regalar() {
        int random = (int) (Math.random() * 2);
        return switch (random){
          case 0 -> Regalo.JUGUETES;
          default -> Regalo.DINERO;
        };
    }
}
