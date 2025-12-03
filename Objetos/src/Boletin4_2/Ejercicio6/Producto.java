package Boletin4_2.Ejercicio6;


import Boletin4_2.Ejercicio6.ProductoException.ProductoException;

public class Producto {

    private static double Iva;
    public static int contador;
    private int codigoIdentif;
    private String descripcion;
    private double precioSinIVA;

    public Producto(double Iva, String descripcion, double precioSinIVA, int contador) throws ProductoException {
        this.codigoIdentif = contador++;
        this.descripcion = descripcion;
        setPrecioSinIVA(precioSinIVA);
        Producto.Iva = Iva;
        this.contador = contador;
    }

    public static int getContador() {return contador;}



    public double getIva() { return Iva; }
    public int getCodigoIdentif() { return codigoIdentif; }
    public String getDescripcion() { return descripcion; }
    public double getPrecioSinIVA() { return precioSinIVA; }


    public static void setContador(int contador) {
        Producto.contador = contador;
    }

    public void setIva(double Iva) {
        this.Iva = Iva;
    }

    public void setCodigoIdentif(int codigoIdentif) {

        this.codigoIdentif = codigoIdentif;
    }

    public void setDescripcion(String descripcion) {

        this.descripcion = descripcion;
    }

    public void setPrecioSinIVA(double precioSinIVA) throws ProductoException {
        if(precioSinIVA < 0){
            throw new ProductoException("Error: El precio del producto no puede ser negativo");
        }
        this.precioSinIVA = precioSinIVA;
    }

    public double precioConIva(double precioSinIVA){
        double precioConIva = (precioSinIVA * Iva) + precioSinIVA;
        return  precioConIva;
    }



}
