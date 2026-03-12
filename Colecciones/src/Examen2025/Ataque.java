package Examen2025;

import exceptions.DBException;

public class Ataque {
    private String nombre;
    private int ki;
    private int perfeccionDeAtaque;
    private int dañoProvoca;

    public Ataque(String nombre, int ki, int perfeccionDeAtaque, int dañoProvoca) throws DBException {
        this.nombre = nombre;
        setKi(ki);
        setPerfeccionDeAtaque(perfeccionDeAtaque);
        setDañoProvoca(dañoProvoca);
    }

    public String getNombre() {
        return nombre;
    }

    public int getKi() {
        return ki;
    }

    public int getPerfeccionDeAtaque() {
        return perfeccionDeAtaque;
    }

    public int getDañoProvoca() {
        return dañoProvoca;
    }

    public void setKi(int ki) throws DBException {
        if (ki <= 0){
            throw new DBException("El ki no puede ser 0 o menor");
        }
        this.ki = ki;
    }

    public void setPerfeccionDeAtaque(int perfeccionDeAtaque) throws DBException {
        if (perfeccionDeAtaque < 1 || perfeccionDeAtaque > 3){
            throw new DBException("El nivel de perfeccion de un ataque va del 1 al 3");
        }
        this.perfeccionDeAtaque = perfeccionDeAtaque;
    }

    public void setDañoProvoca(int dañoProvoca) throws DBException {
        if (dañoProvoca <=0){
            throw new DBException("El daño no puede ser 0 o inferior");
        }
        this.dañoProvoca = dañoProvoca;
    }
}
