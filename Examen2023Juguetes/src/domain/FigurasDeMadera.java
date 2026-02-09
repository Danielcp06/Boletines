package domain;

import Excepciones.JuguetesException;
import Interfaz.Apilable;

public class FigurasDeMadera extends JuguetesMadera implements Apilable {
    private String color;
    private int numeroDeLados;

    public FigurasDeMadera(String nombre, String marca, String paisOrigenMadera, int anoTala, String color, int numeroDeLados) {
        super(nombre, marca, paisOrigenMadera, anoTala);
        this.color = color;
        this.numeroDeLados = numeroDeLados;
    }


    @Override
    public boolean apilar(Juguetes juguete) throws JuguetesException {
        if (juguete != null){
            if (juguete instanceof FigurasDeMadera){
                return true;
            }
        }
        throw new JuguetesException("Falta algun objeto para combinar");
    }
}
