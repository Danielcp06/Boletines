import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import  static org.junit.jupiter.api.Assertions.*;

public class GestorEnviosTest {
    static GestorEnvios g;

    @BeforeAll
    static void setup(){
        g = new GestorEnvios();
    }


    @ParameterizedTest(name = "El pedido es de {0} y su coste sería {1}")
    @CsvSource({
            "10.0, 5.0",
            "20.0, 3.0",
            "40.0, 3.0",
            "49.0, 3.0",
            "50.0, 0.0"
    })

    void testingMasivo(double precio, double valorEsperado){
        double res = g.calcularEnvio(precio);
        assertEquals(valorEsperado, res);
    }

}