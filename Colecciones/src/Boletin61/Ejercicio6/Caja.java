package Boletin61.Ejercicio6;

import java.util.List;

public class Caja implements Comparable<Caja> {
    private int numero;
    private boolean abierto;
    private List<Cliente> cola;

    public Caja(int numero, boolean abierto, List<Cliente> cola) {
        this.numero = numero;
        this.abierto = abierto;
        this.cola = cola;
    }

    public boolean isAbierto() {
        return abierto;
    }

    public void abrir(){
        abierto = true;
    }

    public void cerrar(){
        abierto = false;
    }

    public int numClientes(){
        return cola.size();
    }

    public void añadirCliente(Cliente cliente){
        cliente
    }

    @Override
    public int compareTo(Caja o) {
        if (numClientes() == o.numClientes()){
            return numero - o.numero;
        }
        return numClientes() - o.numClientes();
    }
}
