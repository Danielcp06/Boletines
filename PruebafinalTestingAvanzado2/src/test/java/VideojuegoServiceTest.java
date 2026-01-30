import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.format.SignStyle;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;


class VideojuegoServiceTest {
    private VideojuegoRepository mockVideojuegoRepository;
    private  VideojuegoService videojuegoService;

    @BeforeEach
    void seUp(){
        mockVideojuegoRepository = mock(VideojuegoRepository.class);
        videojuegoService = new VideojuegoService(mockVideojuegoRepository);
    }

    @Test
    void puntuacionJuegoCon50(){
        int puntuacion = 50;

        String res = videojuegoService.clasificarJuego(puntuacion);
        assertEquals("Bueno", res);
    }

    @Test
    void puntuacionJuegoMenos50(){
        int puntuacion = 49;

        String res = videojuegoService.clasificarJuego(puntuacion);
        assertEquals("Malo", res);
    }

    @Test
    void puntuacionJuegoMas50(){
        int puntuacion = 51;

        String res = videojuegoService.clasificarJuego(puntuacion);
        assertEquals("Bueno", res);
    }

    @Test
    void puntuacionJuego90(){
        int puntuacion = 90;

        String res = videojuegoService.clasificarJuego(puntuacion);
        assertEquals("Obra Maestra", res);
    }

    @Test
    void puntuacionJuegoMas90(){
        int puntuacion = 91;

        String res = videojuegoService.clasificarJuego(puntuacion);
        assertEquals("Obra Maestra", res);
    }

    @Test
    void puntuacionJuegoMenos90(){
        int puntuacion = 89;

        String res = videojuegoService.clasificarJuego(puntuacion);
        assertEquals("Bueno", res);
    }


    @Test
    void puntuacion0(){
        int puntuacion = 0;

        String res = videojuegoService.clasificarJuego(puntuacion);
        assertEquals("Malo", res);
    }

    @Test
    void puntuacion100(){
        int puntuacion = 100;

        String res = videojuegoService.clasificarJuego(puntuacion);
        assertEquals("Obra Maestra", res);
    }

    @ParameterizedTest(name = "La puntuacion es de {0} y su calificacion es de {1}")
    @CsvSource({
         "12, Malo",
         "62, Bueno",
         "75, Bueno",
         "94, Obra Maestra"   
    })
    
    void comprobarPuntuacionesAleatorias(int puntuacion, String calificacion){
        String res = videojuegoService.clasificarJuego(puntuacion);
        assertEquals(calificacion, res);
    }

    @Test
    void puntuacionMenor0(){
        int puntuacion = -1;

        assertThrows(IllegalArgumentException.class, () -> videojuegoService.clasificarJuego(puntuacion));
    }



    @Test
    void puntuacionMayor100(){
        int puntuacion = 101;

        assertThrows(IllegalArgumentException.class, () -> videojuegoService.clasificarJuego(puntuacion));
    }

    @ParameterizedTest(name = "Titulo {1}, Plataforma {2}, Horas Jugadas {3}, Puntuacion {4} es largo {5}")
    @CsvSource({
            "Geometry Dash, Movil, 19, 82, false",
            "Mi amiga Peppa Pig, Movil, 20, 100, false",
            "Call of Duty, Movil, 21, 90, true",
            "Stardew Valley, PC, 49, 72, false",
            "Genshin Impact, PC, 50, 70, false",
            "Clash of Clans, PC, 51, 94, true",
    })
    void esJuegoLargo(String titulo, String plataforma, int horas, int puntuacion, boolean esLargo){
        Videojuego v = new Videojuego(titulo,plataforma,horas,puntuacion);
        boolean res = videojuegoService.esJuegoLargo(v);
        assertEquals(esLargo,res);
    }

    @Test
    void registrarJuego() {
     String titulo = null;
     String plataforma = "Play 5";
     int horas = 60;
     int puntuntuacion = -10;

        assertThrows(IllegalArgumentException.class, () -> {
            videojuegoService.registrarJuego(titulo, plataforma, horas, puntuntuacion);
        });
    }


}