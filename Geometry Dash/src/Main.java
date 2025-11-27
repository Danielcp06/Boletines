import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) {
        // 1. Crear la ventana
        JFrame window = new JFrame();

        // 2. Configuración básica de la ventana
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cierra el programa al cerrar la ventana
        window.setResizable(false); // Evita que el usuario cambie el tamaño (importante en juegos)
        window.setTitle("Geometry Dash Clone"); // Título de la ventana

        // 3. Añadir el Panel del Juego (El lienzo)
        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);

        // 4. Ajustes finales
        window.pack(); // Ajusta el tamaño de la ventana al tamaño preferido del GamePanel
        window.setLocationRelativeTo(null); // Centra la ventana en la pantalla
        window.setVisible(true); // Hace visible la ventana

        // 5. Iniciar el bucle del juego
        gamePanel.startGameThread();
    }
}