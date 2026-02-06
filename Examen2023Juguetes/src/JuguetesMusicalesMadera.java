public class JuguetesMusicalesMadera extends JuguetesMadera{
    private int edadMinima;

    public JuguetesMusicalesMadera(String nombre, String marca, String paisOrigenMadera, int anoTala, int edadMinima) {
        super(nombre, marca, paisOrigenMadera, anoTala);
        this.edadMinima = edadMinima;
    }
}
