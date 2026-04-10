package Mini_Boletin.Ejercicio1;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static void main() {
        Videojuego videojuego = new Videojuego("Howart Legacy", "Juani", 2019);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try {
            String json = gson.toJson(videojuego);
            Files.writeString(Paths.get("videojuego.json"), json);

            Path ruta = Paths.get("videojuego.json");
            String jsonLeido = Files.readString(ruta);

            Gson gson1 = new Gson();
            Videojuego videojuego1 = gson1.fromJson(jsonLeido, Videojuego.class);

            System.out.println(videojuego1.toString());
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
