package Examen2024;

import exceptions.TiendaException;

import java.util.HashSet;
import java.util.Set;

public class Categoria {
    private String nombre;
    private Set<Producto> productos;

    public Categoria(String nombre) {
        this.nombre = nombre;
        this.productos = new HashSet<>();
    }

    public String getNombre() {
        return nombre;
    }

    public Set<Producto> getProductos() {
        return productos;
    }

    public void addProducto(Producto p) throws TiendaException {
        if (!productos.add(p)){
            throw new TiendaException("El producto no se ha podido añadir a la lista");
        }
    }



}
