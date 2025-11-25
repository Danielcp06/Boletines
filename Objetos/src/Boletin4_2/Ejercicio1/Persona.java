package Boletin4_2.Ejercicio1;


import java.time.LocalDate;

public class Persona {
    private int DNI;
    private String NOMBRE;
    private LocalDate FECHANACIMIENTO;
    private char SEXO;
    private float PESO;
    private float ALTURA;

    public Persona(String nombre, int dni, char sexo, float peso, LocalDate fechaNacimiento, float altura){
        DNI = dni;
        NOMBRE = nombre;
        PESO = peso;
        SEXO = sexo;
        FECHANACIMIENTO = fechaNacimiento;
        ALTURA = altura;
    }
}
