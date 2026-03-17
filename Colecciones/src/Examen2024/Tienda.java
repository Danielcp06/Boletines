package Examen2024;



import exceptions.TiendaException;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Tienda {
    private String nombre;
    private Set<Categoria> categorias;

    public Tienda(String nombre) {
        this.nombre = nombre;
        this.categorias = new HashSet<>();
    }

    public String getNombre() {
        return nombre;
    }

    /**
     * Añade una nueva categoría. En caso de que exista, lanza una excepción
     * @param nombre
     * @throws TiendaException
     */
    public void addCategoria(Categoria nombre) throws TiendaException {
        if (!categorias.add(nombre)){
            throw new TiendaException("La categoria ya existia");
        }
    }

    /**
     * Añade un producto a una lista de categorías. Se añadirá a aquellas categorías en las que todavía no exista. En
     * aquellas donde ya exista, no se hará nada.
     * @param p
     * @param categorias
     */
    public void addProducto(Producto p, List<Categoria> categorias) throws TiendaException {
        for (Categoria categoria : categorias) {
            if (!this.categorias.contains(categoria)) {
                throw new TiendaException("Error: La categoría '" + categoria.getNombre() + "' no existe en la tienda.");
            }
        }
        for (Categoria categoria : categorias) {
            for (Categoria categoria1 : this.categorias) {
                if (categoria1.equals(categoria)) {
                    try {
                        categoria1.addProducto(p);
                    } catch (TiendaException e){
                        System.out.println(e.getMessage());
                    }

                }
            }
        }

    }

    /**
     * Devuelve un conjunto con aquellas categorías que contienen algún producto sin stock
     * @return
     */
    public Set<Categoria> categoriasConProductosSinStock() {
        return categorias.stream()
                .filter(categoria -> categoria.getProductos().stream()
                        .anyMatch(producto -> producto.getStock() == 0))
                .collect(Collectors.toSet());
    }

    /**
     * Devuelve un conjunto con las categorías a las que pertenece un producto determinado
     * @param p
     * @return
     */
    public Set<Categoria> categoriasDeProducto(Producto p) {
        return categorias.stream()
                .filter(c -> c.getProductos().contains(p))
                .collect(Collectors.toSet());
    }

    /**
     * Devuelve un listado con todos los productos de la tienda (sin repetir) ordenados por precio de mayor a menor
     * @return
     */
    public List<Producto> getTodosLosProductosOrdenadosPorPrecio(){
        return categorias.stream()
                .flatMap(categoria -> categoria.getProductos().stream())
                .distinct()
                .sorted((p1,p2) -> (int) (p2.getPrecio() - p1.getPrecio()))
                .collect(Collectors.toList());

    }

    /**
     * Elimina un producto de todas las categorías donde aparezca.
     * @param p
     * @return true si el producto aparecía en alguna categoría
     */
    public boolean eliminaProducto(Producto p){
        boolean eliminado = false;
        for (Categoria categoria : categorias){
            if (categoria.getProductos().remove(p)){
                eliminado = true;
            }
        }
        return eliminado;
    }

    /**
     * Devuelve un conjunto con aquellos productos que han sido añadido en el último año (a partir de la fecha actual)
     * @return
     */
    public Set<Producto> productosUltimoAnno(){
        LocalDate haceUnAno = LocalDate.now().minusYears(1);
        return categorias.stream()
                .flatMap(categoria -> categoria.getProductos().stream())
                .filter(producto -> producto.getFechaIncorporacion().isAfter(haceUnAno) || producto.getFechaIncorporacion().isEqual(haceUnAno))
                .collect(Collectors.toSet());
    }

}