import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Clase que gestiona la entrada del teclado para el juego.
 */
public class KeyHandler implements KeyListener {

    // Bandera pública que GamePanel y Player revisarán para saber si saltar
    public boolean spacePressed = false;

    // Métodos obligatorios de la interfaz KeyListener

    @Override
    public void keyTyped(KeyEvent e) {
        // No lo usaremos en este juego simple.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode(); // Obtiene el código de la tecla pulsada

        // Verificamos si la tecla pulsada es ESPACIO
        if (code == KeyEvent.VK_SPACE) {
            spacePressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        // Cuando la tecla ESPACIO se suelta, la bandera vuelve a false
        if (code == KeyEvent.VK_SPACE) {
            spacePressed = false;
        }
    }
}