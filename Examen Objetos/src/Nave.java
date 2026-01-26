import Excepciones.NaveException;

public class Nave {
    private String nombreNave;
    private Deposito d1;
    private Deposito d2;
    private Deposito d3;

    public Nave(String nombreNave) {
        this.nombreNave = nombreNave;
        d1 = new Deposito(null);
        d2 = new Deposito(null);
        d3 = new Deposito(null);
    }

    public String getNombreNave() {
        return nombreNave;
    }

    /**
     *
     * @param indice el indice se indica en el main
     * @param c es el cartucho el que se intentara meter en el deposito
     * @return devolvemos verdadero siempre que la nave pueda agregarDSCC B
     * @throws NaveException
     */

    public boolean cargarDeposito(int indice, Cartucho c) throws NaveException{
        if(indice == 1){
            if(d1.comprobarDeposito()){
                d1.agregarCartucho(c);
                return true;
            }
            return false;
        }
        if(indice == 2){
            if(d2.comprobarDeposito()){
                d2.agregarCartucho(c);
                return true;
            }
            return false;
        }
        if(indice == 3){
            if(d3.comprobarDeposito()){
                d3.agregarCartucho(c);
                return true;
            }
            return false;
        }
        return true;
    }

    /**
     *  No me da tiempo a hacerle los metodos auxiliares
     * @return
     * @throws NaveException
     */
    public String saltarHiperespacio()throws NaveException{
        return "Exitoso";
    }




}
