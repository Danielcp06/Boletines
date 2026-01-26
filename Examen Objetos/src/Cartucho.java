import Excepciones.NaveException;

public class Cartucho {
    private String id;
    private String tipo;
    private double potencia;
    private double peso;

    public Cartucho(String id, String tipo, double potencia, double peso) throws NaveException {
        this.id = id;
        this.tipo = tipo;
        setPotencia(potencia);
        setPeso(peso);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPotencia() {
        return potencia;
    }

    /**
     *
     * @param potencia cambiamos el valor de potencia gracias al setter
     * @throws NaveException si la potencia es menor que 0 lanzamos una excepcion ya que no puede haber una potencia negativa
     */
    public void setPotencia(double potencia) throws NaveException {
        if (potencia < 0){
            throw new NaveException("Error: La potencia no puede ser negativa");
        }
        this.potencia = potencia;
    }

    public double getPeso() {
        return peso;
    }

    /**
     *
     * @param peso cambiamos es valor del peso con el setter
     * @throws NaveException comprobamos si el peso es negativo o 0 y si lo es lanzamos una excepcion ya que no puede ser 0 ni negativo
     */
    public void setPeso(double peso) throws NaveException {
        if(peso <= 0){
            throw new NaveException("Error: El peso no puede ser 0 o negativo");
        }
        this.peso = peso;
    }
}
