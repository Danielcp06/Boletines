package Mini_Boletin.Ejercicio4;

import Mini_Boletin.Ejercicio2.Estudiante;
import Mini_Boletin.Ejercicio3.Usuario;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    static void main() {
        Evento evento = new Evento("Invitacion a la isla", LocalDate.of(2019,10,12));
        LocalDateAdapter adapter = new LocalDateAdapter();

        Gson gson = new GsonBuilder().setPrettyPrinting().registerTypeAdapter(LocalDate.class,adapter).create();
        try(FileWriter escritor = new FileWriter("usuario.json");
            FileReader lector = new FileReader("usuario.json"))
        {
            gson.toJson(evento,escritor);
            escritor.flush();

            Evento evento1 = gson.fromJson(lector, Evento.class);

            System.out.println(evento1.toString());
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

    }
}
