package Boletin61.Ejercicio6;

import Boletin61.Ejercicio6.exception.CajaException;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Almacen {
    private List<Caja> cajas;
    private int countClientes;

    public Almacen(List<Caja> cajas, int countClientes) {
        this.cajas = cajas;
        this.countClientes = countClientes;
    }

    public void nuevoCliente() throws CajaException {
        Caja mejorCaja = cajas.stream()
                .filter(Caja::isAbierto)
                .min(Caja::compareTo)
                .orElseThrow(() -> new CajaException("No hay cajas abiertas"));

        Cliente nuevo = new Cliente(countClientes++);
        /*mejorCaja.add(nuevo);

        System.out.println("Es usted el cliente " + nuevo.getId() +
                " vaya a la caja " + cajaElegida.getNumero());

         */
    }



    public void atender(){

    }
}
