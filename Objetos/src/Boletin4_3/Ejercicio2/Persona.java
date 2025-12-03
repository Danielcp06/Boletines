package Boletin4_3.Ejercicio2;


import Boletin4_3.Ejercicio2.Exception.MensajeException;

public class Persona {
    private String nombre;
    private Mensaje[] buzonMensajeRecibido;
    private Mensaje[] buzonMensajeEnviado;

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void enviarMensaje(Mensaje m) throws MensajeException {
        if(m.getAsunto() == null || m.getAsunto().isBlank() || m.getCuerpo() == null || m.getCuerpo().isBlank() || m.getDestinatario() == null){
            throw new MensajeException("Error: Al mensaje le falta algo");
        }
    }

    public void buscarMensajeMasAntiguo(Mensaje[] buzonMensajeRecibido){

    }

}
