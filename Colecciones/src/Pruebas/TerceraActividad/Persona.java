package Pruebas.TerceraActividad;

import Pruebas.TerceraActividad.exception.CorreoException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class Persona {
    private int edad;
    private String nombre;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public int getEdad() {
        return edad;
    }

    public List<String> getMensajes() {
        return mensajes;
    }

    public String getNombre() {
        return nombre;
    }

    private List<String> mensajes = new ArrayList<>();

    public abstract void enviarMensaje (String mensaje, Persona destinatario) throws CorreoException;


}
