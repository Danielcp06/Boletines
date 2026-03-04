package domain;

import app.MainAlumnos;
import exceptions.ValorNoValidoException;

public class Familiar extends Invitados implements Regalable{

    public Familiar(String nombre, int hambre, int aburrimiento) throws ValorNoValidoException {
        if(hambre < 30 || hambre > 60){
            throw new ValorNoValidoException("Los valores del hambre no estan bien");
        }
        super(nombre, hambre, aburrimiento);
    }




    @Override
    public Regalo regalar() {
        int random = (int) (Math.random() * 2);
        return switch (random){
          case 0 -> Regalo.DINERO;
          default -> Regalo.ROPA;
        };
    }


}
