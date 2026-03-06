package Examen2022;

import java.util.HashMap;
import java.util.Map;

public class Mazo extends Cromos {
    private Map<String, Integer> inventario;

    public Mazo(String identificador, Map<String, Integer> inventario) {
        super(identificador);
        this.inventario = new HashMap();
    }
}
