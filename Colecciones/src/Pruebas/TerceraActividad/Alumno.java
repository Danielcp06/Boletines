package Pruebas.TerceraActividad;

import Pruebas.TerceraActividad.exception.CorreoException;

import java.time.LocalDateTime;

public abstract class Alumno extends Persona {

    public Alumno(String nombre, int edad) {
        super(nombre, edad);
    }

    @Override
    public void enviarMensaje(String mensaje, Persona destinatario) throws CorreoException {
        if (getEdad() < 18 && destinatario instanceof Alumno){
            throw new CorreoException("Solo puedes enviar mensajes a profesores");
        }else {
            getMensajes().add(mensaje);
        }
    }
}
