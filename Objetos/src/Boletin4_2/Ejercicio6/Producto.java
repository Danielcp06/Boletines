package Boletin4_2.Ejercicio6;



public class Producto {

    private double Iva;
    private int codigoIdentif;
    private String descripcion;
    private double precioSinIVA;

    public Producto(int codigoIdentif, int Iva, String descripcion, double precioSinIVA) {
        this.codigoIdentif = codigoIdentif;
        this.descripcion = descripcion;
        this.precioSinIVA = precioSinIVA;
        this.Iva = Iva;
    }

    public double getIva() { return Iva; }
    public int getCodigoIdentif() { return codigoIdentif; }
    public String getDescripcion() { return descripcion; }
    public double getPrecioSinIVA() { return precioSinIVA; }

    public void setIva(double Iva) {
        this.Iva = Iva;
    }

    public void setCodigoIdentif(int codigoIdentif) {
        this.codigoIdentif = codigoIdentif;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecioSinIVA(double precioSinIVA) {
        this.precioSinIVA = precioSinIVA;
    }

    public double precioConIva(double precioSinIVA){
        double precioConIva = (precioSinIVA * Iva) + precioSinIVA;
        return  precioConIva;
    }
}
