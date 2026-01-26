public class GestorEnvios {
    public double calcularEnvio(double precio) {
        double envio = 0.0;
        if (precio < 20) envio = 5.0;
        if (precio >= 20) envio = 3.0;
        if (precio >= 50) envio = 0.0;
        return envio;
    }


}
