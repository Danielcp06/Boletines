package Main;

import Interfaz.Apilable;
import domain.*;

public class Main {
    private Juguetes[] juguetes;




    static void main(String[] args) {
        FigurasDeMadera f = new FigurasDeMadera ("Figurita", "Shein","Marruecos",1920, "marron",7);
        JuguetesMusicalesMadera m  = new JuguetesMusicalesMadera("Flauta","Pepe", "Suiza",2019, 5);
        VehiculosPlastico v = new VehiculosPlastico("Coche","Kiat", TipoPlastico.PVC, 4);
        PiezasDeLego p = new PiezasDeLego("Pepe", "Luis Vuiton",TipoPlastico.ABS, 12,"Rojo");



    }
    public void apilar(Juguetes juguete){
    if (juguete instanceof Apilable){

    }

    }
}
