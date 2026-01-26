public class ValidadorClave {
    public boolean esValida(String clave) {
        if (clave == null) {
            return false;
        }
        if (clave.length() < 8) {
            return false;
        }
        // Debe contener al menos un número
        if (!clave.matches(".*\\d.*")) {
            return false;
        }
        return true;
    }
}
