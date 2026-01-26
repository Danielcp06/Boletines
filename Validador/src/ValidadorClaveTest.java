import static org.junit.jupiter.api.Assertions.*;

class ValidadorClaveTest {
    import org.junit.jupiter.api.Test;
    import static org.junit.jupiter.api.Assertions.*;

    class ValidadorClaveTest {

        // Creamos el objeto que vamos a probar
        ValidadorClave validador = new ValidadorClave();

        @org.junit.jupiter.api.Test
        void claveValida_DeberiaRetornarTrue() {
            // CASO CORRECTO: Cumple todas las reglas (no null, >8 chars, tiene números)
            boolean resultado = validador.esValida("ClaveSegura123");
            assertTrue(resultado, "Una clave válida debería devolver true");
        }

        @org.junit.jupiter.api.Test
        void claveCorta_DeberiaRetornarFalse() {
            // FALLO REGLA 2: Tiene números, pero es muy corta
            boolean resultado = validador.esValida("Test1");
            assertFalse(resultado, "Una clave de menos de 8 caracteres debe fallar");
        }

        @org.junit.jupiter.api.Test
        void claveNull_DeberiaRetornarFalse() {
            // FALLO REGLA 1: Es null
            boolean resultado = validador.esValida(null);
            assertFalse(resultado, "Una clave null debe devolver false sin dar error");
        }


    }
}