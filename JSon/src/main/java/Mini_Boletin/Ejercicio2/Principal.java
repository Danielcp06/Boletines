package Mini_Boletin.Ejercicio2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Principal {
    static void main() {
        ArrayList<Estudiante> estudiantes = new ArrayList<>();
         estudiantes.add(new Estudiante("Pepe","1ºDAM",6.7));
         estudiantes.add(new Estudiante("Maria","1ºDAM",7.8));
         estudiantes.add(new Estudiante("Manuel","2ºDAM", 5.5));

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try(FileWriter escritor = new FileWriter("estudiantes.json");
            FileReader lector = new FileReader("estudiantes.json"))
        {
            gson.toJson(estudiantes,escritor);
            escritor.flush();

            Type miLista = new TypeToken<ArrayList<Estudiante>>(){}.getType();
            ArrayList<Estudiante> listaEstudiantes = gson.fromJson(lector,miLista);

            listaEstudiantes.forEach(System.out::println);
        } catch (IOException e) {
            System.out.print(e.getMessage());
        }
    }
}
