package Boletin4_2.Ejercicio1;

import Boletin4_2.Ejercicio1.Excepciones.MiException;

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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Dime tu nombre");
        String nombre = scanner.nextLine();

        System.out.println("Dime tu dni sin la letra");
        int dni = scanner.nextInt();
        while((dni / 10000000 ) < 0.9 || dni > 99999999){
            System.out.println("El dni necesita 8 digitos");
            dni = scanner.nextInt();
        }

        System.out.println("Dime tu sexo (H o M)");
        char sexo = scanner.next().toUpperCase().charAt(0);

        while (sexo != 'H' && sexo != 'M') {
            System.out.println("Tiene que ser H o M");
            sexo = scanner.next().toUpperCase().charAt(0);
        }

        System.out.println("Dime tu peso");
        float peso = scanner.nextFloat();
        while(peso > 200){
            System.out.println("Si no te puedes ni mover de la cama, ¿como vas a usar esto?");
            peso = scanner.nextFloat();
        }

        System.out.println("Dime en que año has nacido");
        int año = scanner.nextInt();
        while(año < 1930 || año > 2025){
            System.out.println("Pero que hablas muchacho");
            año = scanner.nextInt();
        }

        System.out.println("Dime que mes");
        int mes = scanner.nextInt();
        while (mes < 1 || mes > 12){
            System.out.println("Los meses son del 1 al 12");
            mes = scanner.nextInt();
        }

        System.out.println("Y el dia");
        int dia = scanner.nextInt();
        while(dia < 1 || dia > 30){
            System.out.println("Los dias son del 1 al 30");
            dia = scanner.nextInt();
        }

        System.out.println("Ahora dime tu altura");
        float altura = scanner.nextFloat();

        Persona p = null;
        try {
            p = new Persona(nombre, dni, sexo, peso, LocalDate.of(año, mes, dia), altura);
        } catch (MiException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("La letra de tu DNI es: " + p.getLetraDNI());
        System.out.println("Tu IMC es: " + p.getIMC());
    }


}


