import java.util.Scanner;

public class Ejercicio_6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce el número de alumnos: ");
        int numAlumnos = sc.nextInt();

        int aprobados = 0;
        int suspensos = 0;

        for (int i = 1; i <= numAlumnos; i++) {
            System.out.print("Nota del alumno " + i + ": ");
            double nota = sc.nextDouble();

            if (nota >= 5) {
                aprobados++;
            } else {
                suspensos++;
            }
        }

        double porcentajeAprobados = (aprobados * 100.0) / numAlumnos;
        double porcentajeSuspensos = (suspensos * 100.0) / numAlumnos;

        System.out.println("Aprobados: " + aprobados + " (" + porcentajeAprobados + "%)");
        System.out.println("Suspensos: " + suspensos + " (" + porcentajeSuspensos + "%)");

        sc.close();
    }
}


