package Boletin4_3.Ejercicio2;


import Boletin4_3.Ejercicio2.Exception.MensajeException;

import java.time.LocalDateTime;

public class Persona {
    private String nombre;
    private Mensaje[] buzonMensajeRecibido;
    private Mensaje[] buzonMensajeEnviado;

    public Persona(String nombreRemi) {
        this.nombre = nombreRemi;
        buzonMensajeRecibido = new Mensaje[5];
        buzonMensajeEnviado = new Mensaje[5];
    }

    public String getNombre() {
        return nombre;
    }

    public void enviarMensaje(String asunto, String cuerpo, Persona destinatario) throws MensajeException {
        if (asunto == null || asunto.isBlank() || cuerpo == null || cuerpo.isBlank() || destinatario == null) {
            throw new MensajeException("Error: Al mensaje le falta algo");
        }
        if (estaLlenoEnviado()){
            throw new MensajeException("Esta lleno payasete");
        }
        if (destinatario.estaLlenoRecibido()){
            throw new MensajeException("La otra persona no puede recivir mas mensajes");
        }


        Mensaje m = new Mensaje(asunto, cuerpo,this, destinatario, LocalDateTime.now());

        for (int i = 0; i < buzonMensajeEnviado.length ; i++) {
            if (buzonMensajeEnviado[i] == null){
                buzonMensajeEnviado[i] = m;
                break;
            }
        }


        for (int i = 0; i < destinatario.buzonMensajeRecibido.length; i++) {
            if (destinatario.buzonMensajeRecibido[i] == null){
                destinatario.buzonMensajeRecibido[i] = m;
                break;
            }

        }

    }

    public void borrarMensajeRecibidoMasAntiguo() {
        for (int i = 0; i < buzonMensajeRecibido.length - 1 && buzonMensajeRecibido[i] != null;  i++) {
            buzonMensajeRecibido[i] = buzonMensajeRecibido[i + 1];
        }
        buzonMensajeRecibido[buzonMensajeRecibido.length - 1] = null;

    }

    public void borrarMensajeEnviadoMasAntiguo() {
        for (int i = 0; i < buzonMensajeEnviado.length - 1 && buzonMensajeEnviado[i] != null;  i++) {
            buzonMensajeEnviado[i] = buzonMensajeEnviado[i + 1];
        }
        buzonMensajeEnviado[buzonMensajeEnviado.length - 1] = null;

    }



    public boolean estaLlenoRecibido() {
        for (int i = 0; i < buzonMensajeRecibido.length; i++) {
            if (buzonMensajeRecibido[i] == null){
                return false;
            }
        }
        return true;
    }

    public boolean estaLlenoEnviado() {
        for (int i = 0; i < buzonMensajeEnviado.length; i++) {
            if (buzonMensajeEnviado[i] == null){
                return false;
            }
        }
        return true;
    }

}
