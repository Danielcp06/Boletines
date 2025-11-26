package Boletin4_2.Ejercicio1;

import Boletin4_2.Ejercicio1.Excepciones.MiException;

import java.time.LocalDate;

public class Persona {

    private final int DNI;
    private final String NOMBRE;
    private final LocalDate FECHA_NACIMIENTO;
    private final char SEXO;
    private final float PESO;
    private final float ALTURA;

    public Persona(String nombre, int dni, char sexo, float peso, LocalDate fechaNacimiento, float altura) throws MiException {
        this.DNI = dni;
        this.NOMBRE = nombre;

        if (peso <= 0){
            throw new MiException("No puedes poner ese valor para el peso");
        }
        this.PESO = peso;

        this.SEXO = sexo;
        this.FECHA_NACIMIENTO = fechaNacimiento;
        this.ALTURA = altura;
    }

    public int getDNI() {
        return DNI;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public LocalDate getFECHA_NACIMIENTO() {
        return FECHA_NACIMIENTO;
    }

    public char getSEXO() {
        return SEXO;
    }

    public float getPESO() {
        return PESO;
    }

    public float getALTURA() {
        return ALTURA;
    }


    public char getLetraDNI() {
        char letraDNI = ' ';
        int calcularLetraDNI = this.DNI % 23;
        if (calcularLetraDNI == 0) letraDNI = 'T';
        else if (calcularLetraDNI == 1) letraDNI = 'R';
        else if (calcularLetraDNI == 2) letraDNI = 'W';
        else if (calcularLetraDNI == 3) letraDNI = 'A';
        else if (calcularLetraDNI == 4) letraDNI = 'G';
        else if (calcularLetraDNI == 5) letraDNI = 'M';
        else if (calcularLetraDNI == 6) letraDNI = 'Y';
        else if (calcularLetraDNI == 7) letraDNI = 'F';
        else if (calcularLetraDNI == 8) letraDNI = 'P';
        else if (calcularLetraDNI == 9) letraDNI = 'D';
        else if (calcularLetraDNI == 10) letraDNI = 'X';
        else if (calcularLetraDNI == 11) letraDNI = 'B';
        else if (calcularLetraDNI == 12) letraDNI = 'N';
        else if (calcularLetraDNI == 13) letraDNI = 'J';
        else if (calcularLetraDNI == 14) letraDNI = 'Z';
        else if (calcularLetraDNI == 15) letraDNI = 'S';
        else if (calcularLetraDNI == 16) letraDNI = 'Q';
        else if (calcularLetraDNI == 17) letraDNI = 'V';
        else if (calcularLetraDNI == 18) letraDNI = 'H';
        else if (calcularLetraDNI == 19) letraDNI = 'L';
        else if (calcularLetraDNI == 20) letraDNI = 'C';
        else if (calcularLetraDNI == 21) letraDNI = 'K';
        else if (calcularLetraDNI == 22) letraDNI = 'E';

        return letraDNI;
    }

    public float getIMC() {
        return PESO / (ALTURA * ALTURA);
    }
}
