package Boletin4_2.Ejercicio6;




/*
Crear una clase que represente Producto con las siguientes características:
● Tienen un código que los identifica de manera única y que se asigna
automáticamente en el momento de la creación.
● Guardan la descripción y el precio sin IVA.
● Todos los productos comparten el mismo IVA (supongamos el 20%), que puede
variar en función de las decisiones del gobierno.
La clase Producto debe proporcionar los métodos adecuados:
● Constructor.
● Métodos para consulta y modificación de los atributos.
● Metodo para calcular el precio de venta del producto que se obtiene sumándole al
precio el IVA correspondiente.
Realiza un programa principal que pruebe la clase anterior.
 */

import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    static void main(String[] args) {
        System.out.println("¿Qué quieres comprar?");
        String compra = sc.nextLine();
        System.out.println("¿Cuanto vale?");
        double precio = sc.nextDouble();

        Producto p = new Producto(1, 0.2);
        System.out.println(Producto.precioConIva);
    }

    

}
