package Examen2024;

import exceptions.TiendaException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Tienda miTienda = new Tienda("PcComponentes de Hacendado");

        // 1. Creamos algunas categorías
        Categoria c1 = new Categoria("Portátiles");
        Categoria c2 = new Categoria("Periféricos");
        Categoria c3 = new Categoria("Ofertas");

        try {
            miTienda.addCategoria(c1);
            miTienda.addCategoria(c2);
            miTienda.addCategoria(c3);
            System.out.println("Categorías añadidas correctamente.");
        } catch (TiendaException e) {
            System.err.println(e.getMessage());
        }

        // 2. Creamos productos
        // Producto 1: Con stock y fecha antigua
        Producto p1 = new Producto("Apple", "MacBook Pro", "M3 Max", 3500.0, LocalDate.now().minusYears(2), 10);
        // Producto 2: Sin stock y fecha reciente
        Producto p2 = new Producto("Logitech", "MX Master 3S", "Ratón pro", 99.0, LocalDate.now().minusMonths(3), 0);
        // Producto 3: Con stock y fecha reciente
        Producto p3 = new Producto("Razer", "BlackWidow", "Teclado RGB", 150.0, LocalDate.now().minusDays(10), 5);

        try {
            // Añadimos p1 a Portátiles y Ofertas
            miTienda.addProducto(p1, Arrays.asList(c1, c3));
            // Añadimos p2 a Periféricos y Ofertas (Este no tiene stock)
            miTienda.addProducto(p2, Arrays.asList(c2, c3));
            // Añadimos p3 solo a Periféricos
            miTienda.addProducto(p3, List.of(c2));

            System.out.println("Productos distribuidos en categorías.");
        } catch (TiendaException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n--- PRUEBAS DE MÉTODOS ---");

        // 3. Categorías con productos sin stock (Debería salir 'Periféricos' y 'Ofertas' por el ratón)
        System.out.println("Categorías con falta de stock: " +
                miTienda.categoriasConProductosSinStock().stream().map(Categoria::getNombre).toList());

        // 4. Categorías de un producto (p1 está en Portátiles y Ofertas)
        System.out.println("¿Dónde está el MacBook Pro?: " +
                miTienda.categoriasDeProducto(p1).stream().map(Categoria::getNombre).toList());

        // 5. Todos los productos ordenados por precio (Mayor a menor)
        System.out.println("Productos por precio (Desc):");
        miTienda.getTodosLosProductosOrdenadosPorPrecio().forEach(p ->
                System.out.println(" - " + p.getModelo() + ": " + p.getPrecio() + "€"));

        // 6. Productos del último año (Deberían salir el ratón y el teclado)
        System.out.println("Novedades del último año: " +
                miTienda.productosUltimoAnno().stream().map(Producto::getModelo).toList());

        // 7. Eliminar producto
        boolean eliminado = miTienda.eliminaProducto(p1);
        System.out.println("¿Se ha eliminado el MacBook Pro?: " + eliminado);
        System.out.println("¿Sigue en alguna categoría?: " + miTienda.categoriasDeProducto(p1).isEmpty());
    }
}