package Interfaz;

import Excepciones.JuguetesException;
import domain.Juguetes;

public interface Apilable {
    boolean apilar (Juguetes juguete) throws JuguetesException;
}
