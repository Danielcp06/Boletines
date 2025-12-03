package Boletin4_3.Ejercicio2;


import Boletin4_3.Ejercicio2.Exception.MensajeException;

public class Persona {
    private String nombreRemi;
    private String nombreDest;
    private Mensaje[] buzonMensajeRecibido = new Mensaje[5];
    private Mensaje[] buzonMensajeEnviado;

    public Persona(String nombreRemi, String nombreDest) {
        this.nombreRemi = nombreRemi;
        this.nombreDest = nombreDest;
    }
    public String getNombreRemi() {
        return nombreRemi;
    }

    public void enviarMensaje(Mensaje m) throws MensajeException {
        if(m.getAsunto() == null || m.getAsunto().isBlank() || m.getCuerpo() == null || m.getCuerpo().isBlank() || m.getDestinatario() == null){
            throw new MensajeException("Error: Al mensaje le falta algo");
        }
        System.out.println("Se ha enviado correctamente");
    }

    public void buscarMensajeMasAntiguo(Mensaje[] buzonMensajeRecibido){
        buzonMensajeRecibido[0] = buzonMensajeRecibido[1];
        buzonMensajeRecibido[1] = buzonMensajeRecibido[2];
        buzonMensajeRecibido[2] = buzonMensajeRecibido[3];
        buzonMensajeRecibido[3] = buzonMensajeRecibido[4];
        buzonMensajeRecibido[4] = null;
    }



}
