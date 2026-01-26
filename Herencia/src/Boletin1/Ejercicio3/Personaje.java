package Boletin1.Ejercicio3;

import Boletin1.Ejercicio3.personajesException.Exception;

public class Personaje {

    private String nombre;
    private String[] raza;
    private int fuerza;
    private int inteligencia;
    private int vida;
    private int vidaActual;

    public Personaje(String nombre, String[] raza, int fuerza, int inteligencia, int vida, int vidaActual) throws Exception {
        this.nombre = nombre;
        this.raza = raza;
        setFuerza(fuerza);
        setInteligencia(inteligencia);
        setVida(vida);
        setVidaActual(vida);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String[] getRaza() {
        return raza;
    }

    public void setRaza(String[] raza) {
        raza = new String[]{"humano", "elfo", "enano", "orco"};
        raza = this.raza;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) throws Exception {
        if (fuerza < 0 || fuerza > 20){
            throw new Exception("Error: La fuerza tiene que estar entre 0 y 20");
        }
    }

    public int getInteligencia() {

        return inteligencia;
    }

    public void setInteligencia(int inteligencia) throws Exception {
        if (inteligencia < 0 || inteligencia > 20){
            throw new Exception("Error: La inteligencia tiene que estar entre 0 y 20");
        }
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) throws Exception {
        if (vida < 0 || vida > 100){
            throw new Exception("Error: La vida tiene que estar entre 0 y 100");
        }
    }

    public int getVidaActual() {
        return vidaActual;
    }

    public void setVidaActual(int vidaActual) throws Exception {
        if (vidaActual < 0 || vidaActual > vida){
            throw new Exception("Error: La vida actual esta mal");
        }
    }

}
