package Pruebas.TerceraActividad;

import java.time.LocalDateTime;

public class Mensaje {
    private String mensaje;
    private LocalDateTime fecha;

    public Mensaje(String mensaje, LocalDateTime fecha) {
        this.mensaje = mensaje;
        this.fecha = fecha;
    }

    public String getMensaje() {
        return mensaje;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }
}
