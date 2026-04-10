package Mini_Boletin.Ejercicio3;


import Mini_Boletin.Ejercicio1.Videojuego;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    static void main() {
        Usuario usuario = new Usuario("Bermudo","ChamorroAprobado","jberanc123@g.educaand.es", new Direccion("Calle reventada","La Redondela",21410));

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try(FileWriter escritor = new FileWriter("usuario.json");
            FileReader lector = new FileReader("usuario.json"))
        {
            gson.toJson(usuario,escritor);
            escritor.flush();

            Gson gson1 = new Gson();
            Usuario usuario1 = gson1.fromJson(lector, Usuario.class);

            System.out.println(usuario1.toString());
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

}
