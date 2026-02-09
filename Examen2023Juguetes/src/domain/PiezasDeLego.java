package domain;

import Excepciones.JuguetesException;
import Interfaz.Apilable;

public class PiezasDeLego extends JuguetesPlastico implements Apilable {
    private int longitud;
    private String color;

    public PiezasDeLego(String nombre, String marca, TipoPlastico tipoPlastico, int longitud, String color) {
        super(nombre, marca, tipoPlastico);
        this.longitud = longitud;
        this.color = color;
    }

    @Override
    public boolean apilar(Juguetes juguete) throws JuguetesException {
        if (juguete != null){
            if (juguete instanceof PiezasDeLego){
                return true;
            }
        }
        throw new JuguetesException("Falta algun objeto para combinar");
    }
}
