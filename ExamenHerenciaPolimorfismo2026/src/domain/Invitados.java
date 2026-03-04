package domain;

import exceptions.ValorNoValidoException;

public class Invitados {
    private String nombre;
    private int hambre;
    private int aburrimiento;

    /**
     * contructor de la clase padre del cual todos sus hijos tendran estas variables
     * @param nombre
     * @param hambre
     * @param aburrimiento
     * @throws ValorNoValidoException
     */
    public Invitados(String nombre, int hambre, int aburrimiento) throws ValorNoValidoException {
        this.nombre = nombre;
        setHambre(hambre);
        setAburrimiento(aburrimiento);
    }

    /**
     * setter para que el hambre no sea menor a 0 ni mayor que 100
     * @param hambre
     * @throws ValorNoValidoException si es menor que 0 o mayor a 100 lanzar una exception
     */
    public void setHambre(int hambre) throws ValorNoValidoException {
        if(hambre < 0 || hambre > 100){
            throw new ValorNoValidoException("Los valores del hambre no estan bien");
        }
    }

    /**
     * comprobamos que los valores estan dentro de nuestros valores
     * @param aburrimiento
     * @throws ValorNoValidoException si no estan dentro lanzamos una exception
     */
    public void setAburrimiento(int aburrimiento) throws ValorNoValidoException {
        if(aburrimiento < 0 || aburrimiento > 100){
            throw new ValorNoValidoException("Los valores del aburrimiento no estan bien");
        }
    }

    public int getHambre() {
        return hambre;
    }

    public int getAburrimiento() {
        return aburrimiento;
    }

    public void aburrirse(int aburrimiento){
        this.aburrimiento += aburrimiento;
    }
    public void pasarHambre(int hambre){
        this.hambre += hambre;
    }
    public void comer(int hambre){
        this.hambre -= hambre;
    }
    public void divertirse(int aburrimiento){
        this.aburrimiento -= aburrimiento;
    }
}
