import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class GestorDescuentoTest {


    static GestorDescuento g;

    @BeforeAll
    static void setUp() {
        g = new GestorDescuento();
    }

    @Test
    void adulto_SinDescuento() throws IllegalAccessException {


        //ACT
        double res = g.calcular(500, 45, 2);

        //Assert
        assertEquals(500, res);
    }

    @Test
    void senior65_Descuentos() throws IllegalAccessException {

        //ACT
        double res = g.calcular(100, 65, 1);

        assertEquals(50, res);
    }

    @Test
    void cantidad5_SinBonusExtra() throws IllegalAccessException {
// 10€, 30 años, 5 items > Total 50
        double res = g.calcular(10.0, 30, 5);
        assertEquals(50.0, res);
    }

    @Test
    void precioNegativo_LanzaExcepcion() {
        assertThrows(IllegalArgumentException.class, () -> {
            g.calcular(-50, 30, 1);
        });
    }

    // FORMA CORRECTA (JUnit 5)
    @ParameterizedTest
    @ValueSource(ints = {0, 5, 9})
    void niños_DescuentoOk(int edad) {
// Se ejecuta 3 veces inyectando 'edad'
    }

}


