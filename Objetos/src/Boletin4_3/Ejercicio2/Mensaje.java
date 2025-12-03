package Boletin4_3.Ejercicio2;
import java.time.LocalDate;


public class Mensaje {
    private String asunto;
    private String cuerpo;
    private LocalDate fechaEnvío;
    private Persona remitente;
    private Persona destinatario;

    public Mensaje(String asunto, String cuerpo, Persona remitente, Persona destinatario) {
        this.asunto = asunto;
        this.cuerpo = cuerpo;
        this.fechaEnvío = LocalDate.now();
        this.remitente = remitente;
        this.destinatario = destinatario;
    }

    public String getAsunto() {
        return asunto;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public LocalDate getFechaEnvío() {
        return fechaEnvío;
    }

    public Persona getRemitente() {
        return remitente;
    }

    public Persona getDestinatario() {
        return destinatario;
    }
}
