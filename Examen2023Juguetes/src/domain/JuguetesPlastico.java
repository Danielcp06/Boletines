package domain;

public class JuguetesPlastico extends Juguetes{
    private TipoPlastico tipoPlastico;

    public JuguetesPlastico(String nombre, String marca, TipoPlastico tipoPlastico) {
        super(nombre, marca);
        this.tipoPlastico = tipoPlastico;
    }
}
