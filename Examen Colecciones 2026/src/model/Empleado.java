package model;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Empleado {
    public String nombre;
    public String apellido;
    public String dni;
    public TDepartamento departamento;
    public List<Nomina> nominas;

    public Empleado(String nombre, String apellido, String dni, TDepartamento departamento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.departamento = departamento;
        this.nominas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDni() {
        return dni;
    }

    public TDepartamento getDepartamento() {
        return departamento;
    }

    public List<Nomina> getNominas() {
        return nominas;
    }

    @Override
    public String toString() {
        return "%s %s (%s) - Departamento: %s".formatted(nombre, apellido, dni, departamento);
    }


    public YearMonth fechaPrimeraNomina() {
        // TODO: Implementar
        // Debe devolver el mes de la nómina más antigua.
        // Puedes usar .orElse(null) si usas un Stream
        return nominas.stream()
                .min((n1, n2) -> n1.getMes().compareTo(n2.getMes().minusYears(1)))
                .orElse(null).getMes();
    }

    /**
     * metodo el cual nos devulve de todos las nominas que tengamos la ultima
     * @return
     */
    public Nomina getUltimaNomina() {
        // TODO: Implementar
        // Debe devolver el objeto Nomina más reciente.
        // Puedes usar .orElse(null) si usas un Stream
        return nominas.stream()
                .max((n1, n2) -> n1.getMes().compareTo(n2.getMes()))
                .orElse(null);
    }



}

