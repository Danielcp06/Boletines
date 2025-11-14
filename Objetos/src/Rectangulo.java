/*
Crear una clase Rectangulo con los atributos longitud y ancho, cada uno con un
valor predeterminado igual a 1. Proporcionar los métodos set y get para los
atributos longitud y ancho respectivamente. El método set debe verificar que
longitud y ancho contengan números reales mayores que cero y menores que
20. Además, proporcionar métodos que calculen el perímetro y el área del
rectángulo.
Escribir un método main que solicite los datos de un rectángulo y muestre cual es
su área y su perímetro. Probar a introducir un dato incorrecto (mayor o igual que
20).
*/

import java.util.Scanner;

public class Rectangulo {
    double longitud;
    double ancho;

    public Rectangulo() {
        double longitud = 1;
        double ancho = 1;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        if (longitud > 0 && longitud < 20){
            this.longitud = longitud;
        }
    }

    public double getAncho() {
        return ancho;
    }

    public void setAncho(double ancho) {
        if (ancho > 0 && ancho < 20) {
            this.ancho = ancho;
        }
    }

    public double areaRectangulo(){
        return this.longitud*this.ancho;
    }

    public double calcularPerimetro(){
        return this.longitud*2 + this.ancho*2;

    }


    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Rectangulo r = new Rectangulo();
        System.out.println("Dime el ancho de tu rectangulo");
        double num1 = sc.nextDouble();
        while(num1 <=0 || num1 >= 20){
            if (num1 <= 0){
                System.out.println("Tiene que ser un numero mayor que 0");
                num1 = sc.nextDouble();
            } else {
                System.out.println("Tiene que ser menor que 20");
                num1 = sc.nextDouble();
            }

        }
        System.out.println("Ahora dime la longitud");
        double num2 = sc.nextDouble();
        while (num2 < 0 || num2 == num1 || num2 >= 20) {
           if (num2 <= 0){
               System.out.println("Tiene que ser mayor que 0");
               num2 = sc.nextDouble();
           }else {
               if (num2 == num1){
                   System.out.println("La longitud y el ancho no pueden ser iguales sino seria un cuadrado");
                   num2 = sc.nextDouble();
               }else{
                   System.out.println("El numero no puede ser mayor que 20");
                   num2 = sc.nextDouble();
               }
           }


        }

        r.setAncho(num1);
        r.setLongitud(num2);
        System.out.println("El perimetro es " + r.calcularPerimetro() + " y el area " + r.areaRectangulo());
    }
}
