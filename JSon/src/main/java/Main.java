import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Persona> personas = new ArrayList<>();

        personas.add(new Persona("Alejandro Hernández", "12345678A", 600111222));
        personas.add(new Persona("María García", "87654321B", 600333444));
        personas.add(new Persona("Carlos López", "11223344C", 600555666));
        personas.add(new Persona("Laura Martínez", "44332211D", 600777888));
        personas.add(new Persona("Javier Sánchez", "55667788E", 600999000));

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try(FileWriter escritor = new FileWriter("personas.json")) {
            gson.toJson(personas, escritor);
            System.out.println("Archivo generado");
        } catch (IOException e) {
            System.out.println(e.getMessage());;
        }
    }
}