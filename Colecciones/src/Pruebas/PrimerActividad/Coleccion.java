package Pruebas.PrimerActividad;

import java.util.ArrayList;
import java.util.Collection;

public class Coleccion {
    static void main(String[] args) {
        Collection<String> c = new ArrayList<>();
        c.add("Hola ");
        c.add("Mundo");
        for (String n:c){
            System.out.println(n);
        }

        if (c.contains("Mundo")){
            System.out.println("Borro");
            c.remove("Mundo");
        }
    }
}
