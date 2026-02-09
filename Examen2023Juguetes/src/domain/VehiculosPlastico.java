package domain;

public class VehiculosPlastico extends JuguetesPlastico {

    private int numRuedas;

    public VehiculosPlastico(String nombre, String marca, TipoPlastico tipoPlastico, int numRuedas) {
        super(nombre, marca, tipoPlastico);
        this.numRuedas = numRuedas;
    }


}
