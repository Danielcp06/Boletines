import Excepciones.NaveException;

public class Deposito {
    private Cartucho[] cartuchos;


    public Deposito(Cartucho[] cartuchos) {
        setCartuchos(cartuchos);
    }

    public Cartucho[] getCartuchos() {
        return cartuchos;
    }

    public void setCartuchos(Cartucho[] cartuchos) {
        cartuchos = new Cartucho[5];
        this.cartuchos = cartuchos;
    }


    /**
     * Hacemos el metodo comprobar deposito para ver si hay algun hueco libre
     * @return devolvemos verdadero si hay un hueco libre y falso si esta lleno
     */
    public boolean comprobarDeposito(){
        for (int i = 0; i < cartuchos.length; i++) {
            if (cartuchos[i] == null){
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param c son los cartuchos que le legan a la nave
     * @return devolvemos verdadero si se agrega corractamente
     */
    public boolean agregarCartucho(Cartucho c) {
        for (int i = 0; i < cartuchos.length; i++) {
            if (cartuchos[i] == null){
                cartuchos[i] = c;
                System.out.println("Se agrego el cartucho correctamente");
                return true;
            }
        }
        return false;
    }
}
