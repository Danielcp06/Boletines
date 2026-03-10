package Examen2022;

import Examen2023.exceptions.FutbolException;
import exceptions.MazoException;

import java.util.HashMap;
import java.util.Map;

public class Mazo {
    private Map<Cromos, Integer> inventario;

    public Mazo() {
        this.inventario = new HashMap();
    }

    public void añadirCromo(Cromos cromoAñadir) {
        if (inventario.containsKey(cromoAñadir)) {
            this.inventario.put(cromoAñadir, inventario.get(cromoAñadir) + 1);
        } else {
            inventario.put(cromoAñadir, 1);
        }
    }

    public void intercambiarCromo(Cromos cromoIntercambio, Cromos cromoNuevo) throws MazoException {
        if (inventario.containsKey(cromoIntercambio)) {
            this.inventario.put(cromoIntercambio, inventario.get(cromoIntercambio) - 1);
            if (inventario.get(cromoIntercambio) == 0) {
                inventario.remove(cromoIntercambio);
            }
        } else {
            throw new MazoException("Ese cromo no se encuentra en tu mazo");
        }
        añadirCromo(cromoNuevo);
    }


}
