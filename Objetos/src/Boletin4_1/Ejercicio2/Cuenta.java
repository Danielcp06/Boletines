package Boletin4_1.Ejercicio2;

import Boletin4_1.Ejercicio2.excepciones.MiExection;

public class Cuenta {
    private double saldo;
    private int numeroIngresos;
    private int numeroReintegros;

    public Cuenta(double saldoInicial) throws MiExection{
        setSaldo(saldoInicial);
        setNumeroIngresos();
        setNumeroReintegros();
    }

    public double getSaldo() {
        return saldo;
    }

    private void setSaldo(double saldoInicial) throws MiExection {
        if (saldoInicial < 0){
            throw new MiExection("Error: El saldo inicial no puede ser negativo");
        }
        this.saldo=saldoInicial;
    }

    public int getNumeroIngresos() {
        return numeroIngresos;
    }

    private void setNumeroIngresos() {
        this.numeroIngresos = 0;
    }

    public int getNumeroReintegros() {
        return numeroReintegros;
    }

    private void setNumeroReintegros() {
        this.numeroReintegros = 0;
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "saldo=" + saldo +
                ", numeroIngresos=" + numeroIngresos +
                ", numeroReintegros=" + numeroReintegros +
                '}';
    }

    public void reintegro(double dineroASacar) throws MiExection {
        if (dineroASacar < 0) {
            throw new MiExection("El saldo no puede ser negativo");
        }
        if (dineroASacar > this.saldo) {
            throw new MiExection("No tienes suficiente saldo");
        }
        saldo -= dineroASacar;
        numeroReintegros++;
    }

    public void ingreso(double dineroAIngresar) throws MiExection {
        if (dineroAIngresar < 0) {
            throw new MiExection("El saldo no puede ser negativo");
        }
        saldo += dineroAIngresar;
        numeroIngresos++;
    }

    public void consulta() {
        System.out.println(toString());
    }


}