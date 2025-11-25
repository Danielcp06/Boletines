package Boletin4_2.Ejercicio1;

import java.time.LocalDate;

public class Persona {

    private int DNI;
    private String NOMBRE;
    private LocalDate FECHANACIMIENTO;
    private char SEXO;
    private float PESO;
    private float ALTURA;

    public Persona(String nombre, int dni, char sexo, float peso, LocalDate fechaNacimiento, float altura) {
        this.DNI = dni;
        this.NOMBRE = nombre;
        this.PESO = peso;
        this.SEXO = sexo;
        this.FECHANACIMIENTO = fechaNacimiento;
        this.ALTURA = altura;
    }

    public int getDNI() {
        return DNI;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public LocalDate getFECHANACIMIENTO() {
        return FECHANACIMIENTO;
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
        char LetraDNI = ' ';
        int calcularLetraDNI = this.DNI % 23;
        if (calcularLetraDNI == 0) LetraDNI = 'T';
        else if (calcularLetraDNI == 1) LetraDNI = 'R';
        else if (calcularLetraDNI == 2) LetraDNI = 'W';
        else if (calcularLetraDNI == 3) LetraDNI = 'A';
        else if (calcularLetraDNI == 4) LetraDNI = 'G';
        else if (calcularLetraDNI == 5) LetraDNI = 'M';
        else if (calcularLetraDNI == 6) LetraDNI = 'Y';
        else if (calcularLetraDNI == 7) LetraDNI = 'F';
        else if (calcularLetraDNI == 8) LetraDNI = 'P';
        else if (calcularLetraDNI == 9) LetraDNI = 'D';
        else if (calcularLetraDNI == 10) LetraDNI = 'X';
        else if (calcularLetraDNI == 11) LetraDNI = 'B';
        else if (calcularLetraDNI == 12) LetraDNI = 'N';
        else if (calcularLetraDNI == 13) LetraDNI = 'J';
        else if (calcularLetraDNI == 14) LetraDNI = 'Z';
        else if (calcularLetraDNI == 15) LetraDNI = 'S';
        else if (calcularLetraDNI == 16) LetraDNI = 'Q';
        else if (calcularLetraDNI == 17) LetraDNI = 'V';
        else if (calcularLetraDNI == 18) LetraDNI = 'H';
        else if (calcularLetraDNI == 19) LetraDNI = 'L';
        else if (calcularLetraDNI == 20) LetraDNI = 'C';
        else if (calcularLetraDNI == 21) LetraDNI = 'K';
        else if (calcularLetraDNI == 22) LetraDNI = 'E';

        return LetraDNI;
    }

    public float getIMC() {
        return PESO / (ALTURA * ALTURA);
    }
}
