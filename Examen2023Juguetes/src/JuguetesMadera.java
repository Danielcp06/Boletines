public class JuguetesMadera extends Juguetes{
    private String paisOrigenMadera;
    private int anoTala;

    public JuguetesMadera(String nombre, String marca, String paisOrigenMadera, int anoTala) {
        super(nombre, marca);
        this.paisOrigenMadera = paisOrigenMadera;
        this.anoTala = anoTala;
    }
}
