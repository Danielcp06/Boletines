package Boletin1.Ejercicio3;

import Boletin1.Ejercicio3.personajesException.Exception;

public class Mago extends Personaje {
    private String[] hechizos;

    public Mago(String nombre, String[] raza, int fuerza, int inteligencia, int vida, int vida_Actual) throws Exception {
        super(nombre, raza, fuerza, inteligencia, vida, vida_Actual);
        this.hechizos = new String[4];
    }

    @Override
    public void setFuerza(int fuerza) throws Exception {
        if (fuerza > 15) {
            throw new Exception("Error: La fuerza de los magos no puede ser superior a 15");
        }

    }

    @Override
    public void setInteligencia(int inteligencia) throws Exception {
        if (inteligencia < 17) {
            throw new Exception("Error: La inteligencia de un mago no puede ser inferior a 17");
        }
    }

    public void aprendeHechizo(String hechizo) throws Exception {
        for (int i = 0; i < hechizos.length; i++) {
            if (hechizos[i] == null){
                hechizos[i] = hechizo;
            }
        }
        throw new Exception("Error: Ya no se pueden aprender mas hechizos");
    }

    public void lanzaHechizo (Personaje p, String hechizo){
        boolean hechizosEncontrado = false;
        for (int i = 0; i < hechizos.length && !hechizosEncontrado; i++) {
            if(hechizos[i].equalsIgnoreCase(hechizo)){

                hechizosEncontrado = true;
            }
        }
    }

}
