public class FigurasDeMadera extends JuguetesMadera{
    private String color;
    private int numeroDeLados;

    public FigurasDeMadera(String nombre, String marca, String paisOrigenMadera, int anoTala, String color, int numeroDeLados) {
        super(nombre, marca, paisOrigenMadera, anoTala);
        this.color = color;
        this.numeroDeLados = numeroDeLados;
    }
}
