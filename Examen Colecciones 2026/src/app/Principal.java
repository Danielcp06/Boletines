package app;

import exceptions.EmpresaException;
import model.Empleado;
import model.Nomina;
import model.TDepartamento;

import java.time.YearMonth;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Principal {
    private List<Empleado> empleados;

    public Principal() {
        empleados = new ArrayList<>();
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public static void main(String[] args) {
        Principal principal = new Principal();
        principal.inicializarEmpleados();

        try {
            // Este empleado obviamente existe
            principal.buscarEmpleado(principal.empleados.getFirst().getDni());
        }catch (EmpresaException e){
            System.out.println(e.getMessage());
        }
        try{
            // Este empleado no existe
            principal.buscarEmpleado("12345678A");
        }catch (EmpresaException e){
            System.out.println(e.getMessage());
        }
        System.out.println();

        System.out.println("#############");
        System.out.println("Número de empleados por departamento:");
        principal.mostrarNumeroEmpleadosPorDepartamento();
        System.out.println();

        System.out.println("#############");
        System.out.printf("Porcentaje de retención para los trabajadores que llevan menos de 1 año trabajando: %.2f€%n",
                principal.porcentajeRetencionTrabajadoresNuevos());
        System.out.println();

        System.out.println("#############");
        System.out.println("Empleados que más cobran:");
        principal.empleadosQueMasCobran();
        System.out.println();

        System.out.println("#############");
        System.out.println("Coste total en salarios");
        principal.costeTotalSalarios(YearMonth.of(2024, 12));
        System.out.println();

        System.out.println("#############");
        System.out.println("Todos los empleados ordenados por antigüedad");
        principal.mostrarTodosEmpleadosOrdenados();
        System.out.println();


    }


    /**
     * buscamos empleados por sus dni
     * @param dni como dni es un atributo de empleados y aqui un string cogemos el getDNI de la clase empleados y
     *            con el equal lo "igualamos" con dni para ver si son iguales
     * @throws EmpresaException
     */
    private void buscarEmpleado(String dni) throws EmpresaException {
        empleados.stream().filter(empleado -> empleado.getDni().equalsIgnoreCase(dni))
                .findFirst().orElseThrow(() -> new EmpresaException("Ese trabajador no esta en la empresa"));
    }

    /**
     * Comprobamos cada departamento para saber cuantos empleados hay en ellos
     */
    private void mostrarNumeroEmpleadosPorDepartamento() {
        //Comprobamos el primer departamento
        long contador = empleados.stream().filter(empleado -> empleado.getDepartamento() == TDepartamento.CONTABILIDAD)
                .count();
        System.out.println("En el departamento de contabilidad hay: " +contador+ " empleados");

        //Comprobamos el segundo departamento
        long contador1 = empleados.stream().filter(empleado -> empleado.getDepartamento() == TDepartamento.DISEÑO)
                .count();
        System.out.println("En el departamento de diseño hay: " +contador1+ " empleados");

        //Comprobamos el tercer departamento
        long contador2 = empleados.stream().filter(empleado -> empleado.getDepartamento() == TDepartamento.INFORMÁTICA)
                .count();
        System.out.println("En el departamento de informatica hay: " +contador2+ " empleados");
    }

    private double porcentajeRetencionTrabajadoresNuevos() {
        return 0.0;
    }

    /**
     * Primero usasmos una variable la cual me va a decir cual es el salario maximo que se ha ganado este ultimo mes
     * Despues hacemos un flujo con el cual igualamos el salario base del ultimo mes de empleados y lo imprimimos por
     * si hay alguno igual no solo nos imprima uno
     */
    private void empleadosQueMasCobran() {
        double salarioMax = empleados.stream()
                        .mapToDouble(empleado -> empleado.getUltimaNomina().getSalarioNeto())
                        .max().orElse(0);

        empleados.stream().filter(empleado -> empleado.getUltimaNomina().getSalarioNeto() == salarioMax)
                .forEach(System.out::println);
    }

    private void costeTotalSalarios(YearMonth fecha) {

    }


    /**
     * Metodo que muestra todos los empleados ordenados primero por su salario y si alguno de ellos son iguales
     * compara por sus apellidos
     */
    private void mostrarTodosEmpleadosOrdenados() {
        empleados.stream()
                .sorted(Comparator.comparing(Empleado::fechaPrimeraNomina)
                        .thenComparing(Comparator.comparing(Empleado::getApellido)))
                .forEach(System.out::println);
    }

    public void inicializarEmpleados() {
        Random random = new Random();

        // Configuración para generar 5 empleados por cada departamento
        for (TDepartamento dept : TDepartamento.values()) {
            // Los departamentos tendrán entre 3 y 7 empleados
            int numEmpleados = random.nextInt(5) + 3;
            for (int i = 1; i <= numEmpleados; i++) {
                String nombre = "Empleado " + i + "_" + dept.name().charAt(0);
                String apellido = "Apellido " + (random.nextInt(10) + i);
                String dni = (random.nextInt(90000000) + 10000000) + "X";

                Empleado emp = new Empleado(nombre, apellido, dni, dept);

                // Generamos entre 5 y 30 nóminas para cada uno
                // Algunos empezarán hace 30 meses, otros hace solo 5
                int numNominas = random.nextInt(26) + 5;
                YearMonth mesInicio = YearMonth.now().minusMonths(numNominas);

                for (int m = 0; m < numNominas; m++) {
                    YearMonth mesNomina = mesInicio.plusMonths(m);
                    // Salarios entre 1500 y 3500
                    double salarioBase = 1500 + (random.nextDouble() * 2000);
                    // Retenciones entre 10% y 22%
                    double retencion = 10 + (random.nextDouble() * 12);

                    emp.getNominas().add(new Nomina(mesNomina, salarioBase, retencion));
                }
                empleados.add(emp);
            }
        }
    }
}
