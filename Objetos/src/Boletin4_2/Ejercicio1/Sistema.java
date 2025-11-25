package Boletin4_2.Ejercicio1;

import java.time.LocalDate;
import java.util.Scanner;

/*
Crea una clase Persona, cuyos atributos son:
a. Nombre, cadena
b. Fecha de nacimiento (utiliza la clase LocalDate de la librería Java.time, o
representa por variables separadas)
c. DNI (sin letra), entero
d. Sexo, carácter
e. Altura, float
f. Peso, float
Debe tener unos métodos:
a. getters y setters que consideres oportunos.
b. getLetraDni, que devuelva la letra del dni. No acepta parámetros.
c. getIMC, que devuelve el índice de masa corporal. No acepta parámetros. La
fórmula es: peso (kg) / [estatura (m)]
2
 */
public class Sistema {

    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Dime tu nombre");
        String nombre = scanner.nextLine();

        System.out.println("Dime tu dni sin la letra");
        int dni = scanner.nextInt();

        System.out.println("Dime tu sexo (H o M)");
        char sexo = scanner.nextLine().charAt(1);
        while(sexo != 'M' || sexo != 'F'){
            System.out.println("Tiene que ser H o M");
            sexo = scanner.nextLine().charAt(1);
        }

        System.out.println("Dime tu peso");
        int peso = scanner.nextInt();

        System.out.println("Dime en que año has nacido");
        int año = scanner.nextInt();
        System.out.println("Dime que mes");
        int mes = scanner.nextInt();

        System.out.println("Y el dia");
        int dia = scanner.nextInt();

        System.out.println("Ahora dime tu altura");
        float altura = scanner.nextFloat();

        Persona jose = new Persona(nombre, dni, sexo, peso, LocalDate.of(año, mes, dia),altura);
    }


}
