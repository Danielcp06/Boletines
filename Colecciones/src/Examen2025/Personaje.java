package Examen2025;

import exceptions.DBException;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Personaje {
    private String nombre;
    private TRaza raza;
    private int vidaMaxima;
    private int vidaActual;
    private int kiMaximo;
    private int kiActual;
    private Set<Ataque> ataques;
    private boolean muerto;

    public Personaje(String nombre, TRaza raza, int vidaMaxima, int vidaActual, int kiMaximo, int kiActual) throws DBException {
        this.nombre = nombre;
        this.raza = raza;
        setVidaMaxima(vidaMaxima);
        setVidaActual(vidaActual);
        setKiMaximo(kiMaximo);
        setKiActual(kiActual);
        ataques = new HashSet<>();
        muerto = false;

    }

    public String getNombre() {
        return nombre;
    }

    public TRaza getRaza() {
        return raza;
    }

    public int getVidaMaxima() {
        return vidaMaxima;
    }

    public int getVidaActual() {
        return vidaActual;
    }

    public int getKiMaximo() {
        return kiMaximo;
    }

    public int getKiActual() {
        return kiActual;
    }

    public Set<Ataque> getAtaques() {
        return ataques;
    }

    public void setVidaMaxima(int vidaMaxima) throws DBException {
        if (vidaMaxima < 1 || vidaMaxima > 100){
            throw new DBException("La vida maxima tiene que estar entre 1 y 100");
        }
        this.vidaMaxima = vidaMaxima;
    }

    public void setVidaActual(int vidaActual) throws DBException {
        if (vidaActual > vidaMaxima || vidaActual < 0){
            throw new DBException("La vida actual tiene que estar entre 0 y la vida maxima");
        }
        this.vidaActual = vidaActual;
    }

    public void setKiMaximo(int kiMaximo) throws DBException {
        if (kiMaximo > 100 || kiMaximo < 1){
            throw new DBException("Los valores del ki tiene que estar entre 1 y 100");
        }
        this.kiMaximo = kiMaximo;
    }

    public void setKiActual(int kiActual) throws DBException {
        if (kiActual > kiMaximo || kiActual < 1){
            throw new DBException("Los valores de tu ki actual estan mal churri");
        }
        this.kiActual = kiActual;
    }

    public boolean estaMuerto(){
        if (vidaActual == 0){
            return true;
        }
        return false;
    }

    public void recibirDaño(int daño){
        if (!estaMuerto()){
            if (daño > vidaActual){
                vidaActual = 0;
            }else {
                vidaActual = vidaActual - daño;
            }
        }
    }

    public void addAtaque(Ataque ataque) throws DBException {
        if (!ataques.add(ataque)){
            throw new DBException("El ataque ya existia");
        }

    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Personaje personaje)) return false;
        return Objects.equals(nombre, personaje.nombre) && raza == personaje.raza;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, raza);
    }

    @Override
    public String toString() {
        return "Personaje{" +
                "nombre='" + nombre + '\'' +
                ", raza=" + raza +
                ", vidaMaxima=" + vidaMaxima +
                ", vidaActual=" + vidaActual +
                ", kiMaximo=" + kiMaximo +
                ", kiActual=" + kiActual +
                ", ataques=" + ataques +
                ", muerto=" + muerto +
                '}';
    }
}
